package com.mille_bornes.core.cards.remedy;

import com.mille_bornes.constants.cards.CardTypeHazard;
import com.mille_bornes.constants.cards.CardTypeSafety;
import com.mille_bornes.core.cards.hazard.CardFlatTire;
import com.mille_bornes.core.cards.hazard.CardHazard;
import com.mille_bornes.core.cards.safety.CardPunctureProof;
import com.mille_bornes.core.cards.safety.CardSafety;
import com.mille_bornes.constants.cards.CardType;


public class CardSpareTire extends CardRemedy {

    public CardSpareTire() {
        super(CardType.SPARE_TIRE);
    }

    @Override
    public CardTypeHazard getHazardCard() {
        return CardTypeHazard.FLAT_TIRE;
    }

    @Override
    public CardHazard getHazardCardInstance() {
        return new CardFlatTire();
    }

    @Override
    public CardTypeSafety getCounterCard() {
        return CardTypeSafety.PUNCTURE_PROOF;
    }

    @Override
    public CardSafety getCounterCardInstance() {
        return new CardPunctureProof();
    }
}
