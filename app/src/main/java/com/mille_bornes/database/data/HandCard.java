package com.mille_bornes.database.data;

import com.mille_bornes.constants.cards.CardType;
import com.mille_bornes.database.DatabaseUtil;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


/**
 * Represents a card from a hand in the game. Stored in the database.
 * Do not use this class directly, use the {@link DatabaseUtil} class instead.
 */
@Entity
@Table(name = "hand_cards")
public class HandCard extends Card {

    @Transient
    private Card card;

    public HandCard() {}

    /**
     * Constructor for cards in the deck.
     * @param type The type of the card.
     */
    public HandCard(final CardType type) {
        super(type);
    }

    public HandCard(final Card card) {
        super(card);
        this.card = card;
    }

    @Override
    public Boolean canBeAppliedTo(final Player player) {
        if (this.card == null) return false;
        return this.card.canBeAppliedTo(player);
    }
}
