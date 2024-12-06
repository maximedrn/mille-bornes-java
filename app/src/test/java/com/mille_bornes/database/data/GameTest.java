package com.mille_bornes.database.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GameTest extends DatabaseTestBase {

    private final Game game = new Game();

    @Test
    public void testGetId() {
        final Session session = this.getSession();
        if (this.game.getId() == null) session.persist(this.game);
        assertNotNull(this.game.getId());
    }

    @Test
    public void testGetStatus() {
        assertEquals(GameStatus.IN_PROGRESS, this.game.getStatus());
    }

    @Test
    public void testSetStatus() {
        this.game.setStatus(GameStatus.FINISHED);
        assertEquals(GameStatus.FINISHED, this.game.getStatus());
    }

    @Test
    public void testGetPlayers() {
        assertNotNull(this.game.getPlayers());
        assertTrue(this.game.getPlayers().isEmpty());
    }

    @Test
    public void testAddPlayer() {
        final Player player = new Player(this.game, "Player 0");
        this.game.addPlayer(player);
        assertEquals(1, this.game.getPlayers().size());
        assertTrue(this.game.getPlayers().contains(player));
    }

    @Test
    public void testAddPlayers() {
        final List<Player> players = new ArrayList<Player>();
        players.add(new Player(this.game, "Player 1"));
        players.add(new Player(this.game, "Player 2"));
        this.game.addPlayers(players);
        assertEquals(2, this.game.getPlayers().size());
        assertTrue(this.game.getPlayers().containsAll(players));
    }

    @Test
    public void testGetCards() {
        assertNotNull(this.game.getCards());
        assertTrue(this.game.getCards().isEmpty());
    }

    @Test
    public void testAddCard() {
        final Player player = new Player(this.game, "Player 0");
        final Round round = new Round(this.game, 0, player);
        final Card card = new Card(this.game, round, CardType.ATTACK);
        this.game.addCard(card);
        assertEquals(1, this.game.getCards().size());
        assertTrue(this.game.getCards().contains(card));
    }

    @Test
    public void testAddCards() {
        final Player player = new Player(this.game, "Player 0");
        final Round round = new Round(this.game, 0, player);
        final Card card1 = new Card(this.game, round, CardType.ATTACK);
        final Card card2 = new Card(this.game, round, CardType.DEFENSE);
        final List<Card> cards = new ArrayList<Card>();
        cards.addAll(List.of(card1, card2));
        this.game.addCards(cards);
        assertEquals(2, this.game.getCards().size());
        assertTrue(this.game.getCards().containsAll(cards));
    }

    @Test
    public void testGetRounds() {
        assertNotNull(this.game.getRounds());
        assertTrue(this.game.getRounds().isEmpty());
    }

    @Test
    public void testAddRound() {
        final Player player = new Player(this.game, "Player 0");
        final Round round = new Round(this.game, 0, player);
        this.game.addRound(round);
        assertEquals(1, this.game.getRounds().size());
        assertTrue(this.game.getRounds().contains(round));
    }
}
