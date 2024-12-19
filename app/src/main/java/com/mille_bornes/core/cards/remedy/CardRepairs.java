package com.mille_bornes.core.cards.remedy;

import com.mille_bornes.constants.cards.CardTypeHazard;
import com.mille_bornes.constants.cards.CardTypeSafety;
import com.mille_bornes.core.cards.hazard.CardAccident;
import com.mille_bornes.core.cards.hazard.CardHazard;
import com.mille_bornes.core.cards.safety.CardDrivingAce;
import com.mille_bornes.core.cards.safety.CardSafety;
import com.mille_bornes.constants.cards.CardType;


public class CardRepairs extends CardRemedy {

    public CardRepairs() {
        super(CardType.REPAIRS);
    }

    @Override
    public CardTypeHazard getHazardCard() {
        return CardTypeHazard.ACCIDENT;
    }

    @Override
    public CardHazard getHazardCardInstance() {
        return new CardAccident();
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
