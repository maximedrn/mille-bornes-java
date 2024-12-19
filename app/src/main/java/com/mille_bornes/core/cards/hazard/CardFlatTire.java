package com.mille_bornes.core.cards.hazard;

import com.mille_bornes.constants.cards.CardTypeSafety;
import com.mille_bornes.core.cards.safety.CardPunctureProof;
import com.mille_bornes.core.cards.safety.CardSafety;
import com.mille_bornes.constants.cards.CardType;


public class CardFlatTire extends CardHazard {

    public CardFlatTire() {
        super(CardType.FLAT_TIRE);
    }

    public CardTypeSafety getCounterCard() {
        return CardTypeSafety.PUNCTURE_PROOF;
    }

    public CardSafety getCounterCardInstance() {
        return new CardPunctureProof();
    }
}
