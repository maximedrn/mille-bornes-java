package com.mille_bornes.database.data;

import java.util.List;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mille_bornes.core.cards.hazard.CardAccident;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RoundTest extends DatabaseTestBase {

    @BeforeAll
    public static void beforeAll() {
        final Game game = new Game();
        final Round round = new Round(0);
        game.addRound(round);
        RoundTest.persist(round);
    }

    private Round getRound(Session session) {
        return session.get(Round.class, RoundTest.id);
    }

    @Test
    public void testGetId() {
        final Round round = this.getRound(this.getSession());
        assertNotNull(round.getId());
        assertEquals(RoundTest.id, round.getId());
    }

    @Test
    public void testGetGame() {
        final Round round = this.getRound(this.getSession());
        assertNotNull(round.getGame());
    }

    @Test
    public void testGetRoundIndex() {
        final Round round = this.getRound(this.getSession());
        assertEquals(0, round.getIndex());
    }

    @Test
    @Order(1)
    public void getCards() {
        final Round round = this.getRound(this.getSession());
        assertEquals(0, round.getCards().size());
    }

    @Test
    @Order(2)
    public void addCards() {
        final Session session = this.startTransaction();
        final Round round = this.getRound(session);
        final Card firstCard = new CardAccident();
        final Card secondCard = new CardAccident();
        round.addCards(List.of(firstCard, secondCard));
        this.endTransaction(session);
        assertEquals(2, round.getCards().size());
        assertEquals(firstCard, round.getCards().get(0));
    }

    @Test
    @Order(Integer.MAX_VALUE)
    public void testToString() {
        System.out.println(this.getRound(this.getSession()));
    }
}
