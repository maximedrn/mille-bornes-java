package com.mille_bornes.database;

import java.util.List;

import org.hibernate.Session;

import com.mille_bornes.constants.GameStatus;
import com.mille_bornes.database.data.Card;
import com.mille_bornes.database.data.Game;
import com.mille_bornes.database.data.Player;
import com.mille_bornes.database.data.Round;
import com.mille_bornes.database.data.helper.DatabaseTable;


/**
 * Utility class to interact with the database (DAO).
 * This class is used to interact with the database and perform operations 
 * such as adding players, starting a new round, etc.
 */
public class DatabaseUtil {

    private final String gameId;

    public DatabaseUtil(final List<Player> players) {
        final Game game = new Game();
        game.addPlayers(players);
        this.gameId = game.getId();
        this.merge(game);
    }

    private void merge(final DatabaseTable<?> table) {
        final Session session = HibernateUtil.open();
        session.beginTransaction();
        session.merge(table);
        session.getTransaction().commit();
        session.close();
    }

    private Game getGame() {
        final Session session = HibernateUtil.open();
        final Game game = session.get(Game.class, this.gameId);
        session.close();
        return game;
    }

    public void endGame() {
        final Game game = this.getGame();
        game.setStatus(GameStatus.FINISHED);
        this.merge(game);
    }

    public List<Player> getPlayers() {
        return this.getGame().getPlayers();
    }

    public void addPlayer(final Player player) {
        final Game game = this.getGame();
        player.setGame(game);
        this.merge(game);
    }

    public Round getCurrentRound() {
        return this.getGame().getRounds().getLast();
    }

    public void newRound() {
        final Round previousRound = this.getCurrentRound();
        final Round round = new Round(previousRound.getIndex() + 1);
        this.merge(round);
    }

    public void saveCards(final List<Card> cards) {
        final Round round = this.getCurrentRound();
        round.addCards(cards);
        this.merge(round);
    }

    public List<Card> getRoundDeck() {
        return this.getCurrentRound().getCards()
            .stream()
            .filter((final Card card) -> card.getPlayer() == null)
            .toList();
    }

    private List<Card> getPlayerCards(final List<Card> cards) {
        final Round round = this.getCurrentRound();
        return cards
            .stream()
            .filter((final Card card) -> card.getRound().equals(round))
            .toList();
    }

    /**
     * Get the deck of the player in the current round.
     * @param player The player to get the deck of.
     * @return The deck of the player in the current round.
     */
    public List<Card> getPlayerHand(final Player player) {
        return this.getPlayerCards(player.getHand());
    }

    /**
     * Get the stack of the player in the current round.
     * @param player The player to get the stack of.
     * @return The stack of the player in the current round.
     */
    public List<Card> getPlayerStack(final Player player) {
        return this.getPlayerCards(player.getStack());
    }

    public void addCardToPlayer(final Player player, final Card card) {
        card.setRound(this.getCurrentRound());
        card.setPlayer(player);
        this.merge(card);
    }

    public void addScoreToPlayer(final Player player, final Integer score) {
        player.addScore(score);
        this.merge(player);
    }
}
