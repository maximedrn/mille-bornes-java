package com.mille_bornes.database.data;

import com.mille_bornes.constants.CardType;
import com.mille_bornes.constants.Exceptions;
import com.mille_bornes.database.DatabaseUtil;
import com.mille_bornes.database.data.helper.OrderedDatabaseTable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


/**
 * Represents a card in the game. Stored in the database.
 * Do not use this class directly, use the {@link DatabaseUtil} class instead.
 */
@Entity
@Table(name = "cards")
public class Card extends OrderedDatabaseTable<Card> {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "round_id", nullable = false)
    private Round round;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id", nullable = true)
    private Player player;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(nullable = true)
    private Integer value;

    public Card() {}

    /**
     * Constructor for cards in the player's hand.
     * @param player The player that has the card (can be null).
     * @param type The type of the card.
     * @param value The value of the card (can be null).
     */
    public Card(final Player player, final CardType type) {
        assert type != null : Exceptions.CARD_TYPE_CANNOT_BE_NULL;
        this.player = player;
        this.type = type.toString();
        this.value = type.getValue();
    }

    /**
     * Constructor for cards in the deck.
     * @param type The type of the card.
     * @param value The value of the card.
     */
    public Card(final CardType type) {
        this(null, type);
    }

    public Round getRound() {
        return this.round;
    }

    public void setRound(final Round round) {
        assert round != null : Exceptions.ROUND_CANNOT_BE_NULL;
        this.round = round;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(final Player player) {
        assert player != null : Exceptions.PLAYER_CANNOT_BE_NULL;
        this.player = player;
        this.removeIndex(); // Reset the index from the deck.
    }

    public CardType getType() {
        return CardType.valueOf(this.type.toUpperCase());
    }

    public Integer getValue() {
        return this.value;
    }

    public String toString() {
        final String type = this.getType().toString();
        final Integer value = this.getValue();
        return String.join(" ", type, value.toString());
    }
}
