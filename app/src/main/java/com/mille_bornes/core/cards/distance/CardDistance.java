package com.mille_bornes.core.cards.distance;

import com.mille_bornes.constants.cards.CardTypeHazard;
import com.mille_bornes.constants.cards.CardTypeSafety;
import com.mille_bornes.constants.cards.CardType;
import com.mille_bornes.core.cards.ICardCounter;
import com.mille_bornes.database.data.Card;
import com.mille_bornes.database.data.Player;
import com.mille_bornes.database.data.StackCard;


public abstract class CardDistance extends Card implements ICardCounter {

    public CardDistance(final CardType cardType) {
        super(cardType);
    }

    public CardTypeSafety getCounterCard() {
        return CardTypeSafety.DRIVING_ACE;
    }

    public CardTypeHazard getHazardCard() {
        return CardTypeHazard.SPEED_LIMIT;
    }

    @Override
    public Boolean canBeAppliedTo(final Player player) {
        final CardTypeHazard hazardCard = this.getHazardCard();
        final Boolean hasHazard = player.hasHazardCard(hazardCard);
        final CardTypeSafety counterCard = this.getCounterCard();
        final Boolean hasSafety = player.hasSafetyCard(counterCard);
        return !hasHazard || hasSafety;
    }

    @Override
    public StackCard applyTo(final Player player) {
        player.addScore(this.getValue());
        return super.applyTo(player);
    }
}
