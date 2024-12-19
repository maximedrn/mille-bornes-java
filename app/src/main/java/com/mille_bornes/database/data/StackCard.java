package com.mille_bornes.database.data;

import com.mille_bornes.constants.cards.CardType;
import com.mille_bornes.database.DatabaseUtil;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


/**
 * Represents a card from a stack in the game. Stored in the database.
 * Do not use this class directly, use the {@link DatabaseUtil} class instead.
 */
@Entity
@Table(name = "stack_cards")
public class StackCard extends Card {

    @Transient
    private Card card;

    public StackCard() {}

    /**
     * Constructor for cards in the deck.
     * @param type The type of the card.
     */
    public StackCard(final CardType type) {
        super(type);
    }

    public StackCard(final Card card) {
        super(card);
        this.card = card;
    }

    @Override
    public Boolean canBeAppliedTo(final Player player) {
        if (this.card == null) return false;
        return this.card.canBeAppliedTo(player);
    }
}
