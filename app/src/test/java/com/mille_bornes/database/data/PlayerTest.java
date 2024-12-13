package com.mille_bornes.database.data;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.mille_bornes.constants.PlayerType;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlayerTest extends DatabaseTestBase {

    private static final String name = "Player 0";
    public static final Integer playIndex = 0;

    @BeforeAll
    public static void beforeAll() {
        final Game game = new Game();
        final Player player = new Player(
            PlayerTest.name, PlayerTest.playIndex
        );
        player.setGame(game);
        RoundTest.persist(player);
    }

    private Player getPlayer(Session session) {
        return session.get(Player.class, id);
    }

    @Test
    public void testGetId() {
        final Player player = this.getPlayer(this.getSession());
        assertNotNull(player.getId());
        assertEquals(PlayerTest.id, player.getId());
    }

    @Test
    public void testGetName() {
        final Player player = this.getPlayer(this.getSession());
        assertEquals(PlayerTest.name, player.getName());
    }

    @Test
    public void testGetPlayIndex() {
        final Player player = this.getPlayer(this.getSession());
        assertEquals(PlayerTest.playIndex, player.getIndex());
    }

    @Test
    public void testGetType() {
        final Player player = this.getPlayer(this.getSession());
        assertEquals(PlayerType.HUMAN.toString(), player.getType());
    }

    @Test
    @Order(1)
    public void testGetScore() {
        final Player player = this.getPlayer(this.getSession());
        assertEquals(0, player.getScore());
    }

    @Test
    @Order(2)
    public void testSetScore() {
        final Session session = this.startTransaction();
        final Player player = this.getPlayer(session);
        player.setScore(100);
        player.addScore(100);
        this.endTransaction(session);
        assertEquals(200, player.getScore());
    }

    @Test
    @Order(Integer.MAX_VALUE)
    public void testToString() {
        System.out.println(this.getPlayer(this.getSession()));
    }
}
