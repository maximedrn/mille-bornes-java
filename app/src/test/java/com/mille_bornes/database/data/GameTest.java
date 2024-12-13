package com.mille_bornes.database.data;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mille_bornes.constants.GameStatus;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameTest extends DatabaseTestBase {

    @BeforeAll
    public static void beforeAll() {
        final Game game = new Game();
        RoundTest.persist(game);
    }

    private Game getGame(Session session) {
        return session.get(Game.class, id);
    }

    @Test
    public void testGetId() {
        final Game game = this.getGame(this.getSession());
        assertNotNull(game.getId());
        assertEquals(GameTest.id, game.getId());
    }

    @Test
    @Order(1)
    public void testGetStatus() {
        final Game game = this.getGame(this.getSession());
        assertEquals(GameStatus.IN_PROGRESS, game.getStatus());
    }

    @Test
    @Order(2)
    public void testSetStatus() {
        final Session session = this.startTransaction();
        final Game game = this.getGame(session);
        game.setStatus(GameStatus.FINISHED);
        this.endTransaction(session);
        assertEquals(GameStatus.FINISHED, game.getStatus());
    }

    @Test
    @Order(3)
    public void testGetRounds() {
        final Game game = this.getGame(this.getSession());
        assertNotNull(game.getRounds());
        assertTrue(game.getRounds().isEmpty());
    }

    @Test
    @Order(4)
    public void testAddRound() {
        final Session session = this.startTransaction();
        final Game game = this.getGame(session);
        final Round round = new Round(0);
        game.addRound(round);
        this.endTransaction(session);
        assertEquals(1, game.getRounds().size());
        assertTrue(game.getRounds().contains(round));
    }

    @Test
    @Order(Integer.MAX_VALUE)
    public void testToString() {
        System.out.println(this.getGame(this.getSession()));
    }
}
