package com.mille_bornes.core.cards.remedy;

import com.mille_bornes.constants.cards.CardTypeHazard;
import com.mille_bornes.constants.cards.CardTypeSafety;
import com.mille_bornes.core.cards.hazard.CardHazard;
import com.mille_bornes.core.cards.hazard.CardSpeedLimit;
import com.mille_bornes.core.cards.safety.CardDrivingAce;
import com.mille_bornes.core.cards.safety.CardSafety;
import com.mille_bornes.constants.cards.CardType;


public class CardEndOfSpeedLimit extends CardRemedy {

    public CardEndOfSpeedLimit() {
        super(CardType.END_OF_SPEED_LIMIT);
    }

    @Override
    public CardTypeHazard getHazardCard() {
        return CardTypeHazard.SPEED_LIMIT;
    }

    @Override
    public CardHazard getHazardCardInstance() {
        return new CardSpeedLimit();
    }

    @Override
    public CardTypeSafety getCounterCard() {
        return CardTypeSafety.DRIVING_ACE;
    }

    @Override
    public CardSafety getCounterCardInstance() {
        return new CardDrivingAce();
    }
}
