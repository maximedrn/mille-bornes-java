package com.mille_bornes.database.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


enum CardType {
    BORN,
    ATTACK,
    DEFENSE,
    SPEED_LIMIT,
    STOP;

    /**
     * @return the lowercase name of the enum constant.
     */
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}


@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "round_id", nullable = false)
    private Round round;

    /**
     * If null, the card is in the deck.
     */
    @ManyToOne
    @JoinColumn(name = "player_id", nullable = true)
    private Player player;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(nullable = true)
    private Integer value;

    public Card(
        final Game game,
        final Round round,
        final Player player,
        final CardType type,
        final Integer value
    ) {
        this.game = game;
        this.round = round;
        this.player = player;
        this.type = type.toString();
        this.value = value;
    }

    public Card(
        final Game game,
        final Round round,
        final Player player,
        final CardType type
    ) {
        this.game = game;
        this.round = round;
        this.player = player;
        this.type = type.toString();
        this.value = null;
    }

    public Card(
        final Game game,
        final Round round,
        final CardType type,
        final Integer value
    ) {
        this.game = game;
        this.round = round;
        this.player = null;
        this.type = type.toString();
        this.value = value;
    }

    public Card(
        final Game game,
        final Round round,
        final CardType type
    ) {
        this.game = game;
        this.round = round;
        this.player = null;
        this.type = type.toString();
        this.value = null;
    }

    public String getId() {
        return this.id;
    }

    public Game getGame() {
        return this.game;
    }

    public Round getRound() {
        return this.round;
    }

    public Player getPlayer() {
        return this.player;
    }

    public CardType getType() {
        return CardType.valueOf(this.type.toUpperCase());
    }

    public Integer getValue() {
        return this.value;
    }
}
