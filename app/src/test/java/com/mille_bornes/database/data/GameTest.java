package com.mille_bornes.database.data;

import java.sql.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mille_bornes.database.HibernateUtil;


public class GameTest {

    private final Game game = new Game();
    private final int id = 1;
    private final String winner = "Player";
    private final String startTime;
    private final String endTime;

    public GameTest() {
        final long currentTime = System.currentTimeMillis();
        final String now = new Date(currentTime).toString();
        this.startTime = now;
        this.endTime = now;
    }

    @Test
    public void testSetGame() {
        // Connect to the database and set the game.
        final Session session = HibernateUtil.open();
        final Transaction transaction = session.beginTransaction();
        final Game game = session.get(Game.class, this.id);

        if (game == null) {
            this.game.setId(this.id);
            this.game.setStartTime(this.startTime);
            this.game.setEndTime(this.endTime);
            this.game.setWinner(this.winner);
            session.persist(this.game);
        } else {
            game.setStartTime(this.startTime);
            game.setEndTime(this.endTime);
            game.setWinner(this.winner);
            session.merge(game);
        }

        transaction.commit();
        session.close();
    }

    @Test
    public void testGetGame() {
        // Connect to the database and get the game.
        final Session session = HibernateUtil.open();
        final Game game = session.get(Game.class, this.id);
        session.close();
        // Check that the game was set correctly.
        assertEquals(this.id, game.getId());
        assertEquals(this.startTime, game.getStartTime());
        assertEquals(this.endTime, game.getEndTime());
        assertEquals(this.winner, game.getWinner());
    }
}
