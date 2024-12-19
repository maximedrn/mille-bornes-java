package com.mille_bornes.core.cards.remedy;

import com.mille_bornes.constants.cards.CardTypeHazard;
import com.mille_bornes.constants.cards.CardTypeSafety;
import com.mille_bornes.constants.cards.CardType;
import com.mille_bornes.core.cards.ICardCounter;
import com.mille_bornes.core.cards.hazard.CardHazard;
import com.mille_bornes.core.cards.safety.CardSafety;
import com.mille_bornes.database.data.Card;
import com.mille_bornes.database.data.Player;


public abstract class CardRemedy extends Card implements ICardCounter {

    public CardRemedy(final CardType cardType) {
        super(cardType);
    }

    public abstract CardTypeHazard getHazardCard();
    public abstract CardHazard getHazardCardInstance();
    public abstract CardTypeSafety getCounterCard();
    public abstract CardSafety getCounterCardInstance();

    @Override
    public Boolean canBeAppliedTo(final Player player) {
        final CardTypeHazard hazardCard = this.getHazardCard();
        final Boolean hasHazard = player.hasHazardCard(hazardCard);
        final CardTypeSafety counterCard = this.getCounterCard();
        final Boolean hasSafety = player.hasSafetyCard(counterCard);
        return hasHazard && !hasSafety;
    }
}
