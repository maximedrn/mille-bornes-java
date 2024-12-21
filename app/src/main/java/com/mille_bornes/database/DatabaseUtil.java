package com.mille_bornes.database;

import java.util.List;

import org.hibernate.Session;

import com.mille_bornes.constants.GameStatus;
import com.mille_bornes.database.data.Card;
import com.mille_bornes.database.data.DeckCard;
import com.mille_bornes.database.data.Game;
import com.mille_bornes.database.data.Player;
import com.mille_bornes.database.data.Round;
import com.mille_bornes.database.data.helper.DatabaseTable;

import jakarta.transaction.Transactional;


/**
 * Utility class to interact with the database (DAO).
 * This class is used to interact with the database and perform operations 
 * such as adding players, starting a new round, etc.
 */
public class DatabaseUtil {

    private final String gameId;

    public DatabaseUtil() {
        final Game game = new Game();
        this.gameId = game.getId();
        this.merge(game);
    }

    public DatabaseUtil(final String gameId) {
        this.gameId = gameId;
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

    @Transactional
    public void addPlayer(final Player player) {
        final Game game = this.getGame();
        game.addPlayer(player);
        this.merge(game);
    }

    @Transactional
    public void addPlayers(final Player player) {
        final Game game = this.getGame();
        game.addPlayer(player);
        this.merge(game);
    }

    @Transactional
    public Round newRound() {
        final Integer index = this.getGame().getRounds().size();
        final Round newRound = new Round(index);
        final Game game = this.getGame();
        game.addRound(newRound);
        this.merge(newRound);
        return newRound;
    }

    public Round getCurrentRound() {
        final Round round = this.getGame().getRounds().getLast();
        return round != null ? round : this.newRound();
    }

    @Transactional
    public void saveCards(final List<Card> cards) {
        final Round round = this.getCurrentRound();
        round.addCards(cards);
        this.merge(round);
    }

    public List<DeckCard> getRoundDeck() {
        return this.getCurrentRound().getCards()
            .stream()
            .filter((final Card card) -> card.getPlayer() == null)
            .toList();
    }

    private List<Card> getPlayerCards(final List<? extends Card> cards) {
        final Round round = this.getCurrentRound();
        return cards
            .stream()
            .filter((final Card card) -> card.getRound().equals(round))
            .map(card -> (Card) card)
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

    @Transactional
    public void addCardToPlayerHand(final Player player, final Card card) {
        card.setRound(this.getCurrentRound());
        this.merge(player.addCardToHand(card));
    }

    @Transactional
    public void addCardToPlayerStack(final Player player, final Card card) {
        card.setRound(this.getCurrentRound());
        this.merge(player.addCardToStack(card));
    }

    @Transactional
    public void applyCardToPlayer(final Player player, final Card card) {
        card.setRound(this.getCurrentRound());
        this.merge(card.applyTo(player));
    }

    @Transactional
    public void addScoreToPlayer(final Player player, final Integer score) {
        player.addScore(score);
        this.merge(player);
    }
}
