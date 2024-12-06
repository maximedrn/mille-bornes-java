package com.mille_bornes.database.data;

import com.mille_bornes.database.exceptions.IllegalScoreException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


enum PlayerType {
    HUMAN,
    ROBOT;

    /**
     * @return the lowercase name of the enum constant.
     */
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}


@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @Column(nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type = PlayerType.HUMAN.toString();

    @Column(nullable = false)
    private int score = 0;

    public Player(final Game game, final String name) {
        this.game = game;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public Game getGame() {
        return this.game;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(final Integer score) {
        if (score >= 0) this.score = score;
        throw new IllegalScoreException("Score must be positive.");
    }

    public void addScore(final Integer score) {
        this.score += score;
    }
}
