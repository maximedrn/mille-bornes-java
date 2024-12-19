package com.mille_bornes.database.data;

import java.util.List;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.mille_bornes.constants.cards.CardType;
import com.mille_bornes.core.cards.hazard.CardAccident;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CardTest extends DatabaseTestBase {

    private static String gameId;

    @BeforeAll
    public static void beforeAll() {
        final Game game = new Game();
        CardTest.gameId = game.getId();
        final Round round = new Round(0);
        final Card card = new CardAccident();
        round.addCards(List.of(card));
        game.addRound(round);
        RoundTest.persist(card);
    }

    private Card getCard(Session session) {
        return session.get(Card.class, id);
    }

    @Test
    public void testGetId() {
        final Card card = this.getCard(this.getSession());
        assertNotNull(card.getId());
        assertEquals(CardTest.id, card.getId());
    }

    @Test
    public void testGetType() {
        final Card card = this.getCard(this.getSession());
        assertEquals(CardType.ACCIDENT, card.getType());
    }

    @Test
    @Order(1)
    public void testGetPlayer() {
        final Card card = this.getCard(this.getSession());
        assertNull(card.getPlayer());
    }

    @Test
    @Order(2)
    public void testSetPlayer() {
        final Session session = this.startTransaction();
        final Card card = this.getCard(session);
        final Player player = new Player("Player 0", 0);
        player.setGame(session.get(Game.class, CardTest.gameId));
        player.addCardToHand(card);
        player.moveCardToStack(card);
        this.endTransaction(session);
        assertNotNull(card.getPlayer());
        assertEquals(player, card.getPlayer());
    }

    @Test
    public void testGetValue() {
        final Card card = this.getCard(this.getSession());
        assertNull(card.getValue());
    }

    @Test
    @Order(Integer.MAX_VALUE)
    public void testToString() {
        System.out.println(this.getCard(this.getSession()));
    }
}
