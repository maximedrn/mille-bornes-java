package com.mille_bornes.database.data;

import com.mille_bornes.constants.Exceptions;
import com.mille_bornes.constants.cards.CardType;
import com.mille_bornes.database.DatabaseUtil;
import com.mille_bornes.database.data.helper.OrderedDatabaseTable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;


/**
 * Represents a card in the game. Stored in the database.
 * Do not use this class directly, use the {@link DatabaseUtil} class instead.
 */
@MappedSuperclass
public abstract class Card extends OrderedDatabaseTable<Card> {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "round_id", nullable = false)
    private Round round;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "player_id", nullable = true)
    private Player player;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(nullable = true)
    private Integer value;

    public Card() {}

    /**
     * Constructor for cards in the deck.
     * @param type The type of the card.
     */
    public Card(final CardType type) {
        assert type != null : Exceptions.CARD_TYPE_CANNOT_BE_NULL;
        this.type = type.toString();
        this.value = type.getValue();
    }

    public Card(final Card card) {
        this(card.getType());
        this.player = card.getPlayer();
        this.round = card.getRound();
        this.index = card.getIndex();
    }

    public abstract Boolean canBeAppliedTo(final Player player);

    public StackCard applyTo(final Player player) {
        return player.addCardToStack(this);
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
        final String valueString = value == null ? "" : value.toString();
        return String.join(" ", type, valueString);
    }
}
