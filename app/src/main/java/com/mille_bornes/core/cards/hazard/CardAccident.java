package com.mille_bornes.core.cards.hazard;

import com.mille_bornes.constants.cards.CardTypeSafety;
import com.mille_bornes.core.cards.safety.CardDrivingAce;
import com.mille_bornes.core.cards.safety.CardSafety;

import com.mille_bornes.constants.cards.CardType;


public class CardAccident extends CardHazard {

    public CardAccident() {
        super(CardType.ACCIDENT);
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
