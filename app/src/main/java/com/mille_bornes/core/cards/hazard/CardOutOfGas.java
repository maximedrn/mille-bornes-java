package com.mille_bornes.core.cards.hazard;

import com.mille_bornes.constants.cards.CardTypeSafety;
import com.mille_bornes.core.cards.safety.CardExtraTank;
import com.mille_bornes.core.cards.safety.CardSafety;
import com.mille_bornes.constants.cards.CardType;


public class CardOutOfGas extends CardHazard {

    public CardOutOfGas() {
        super(CardType.OUT_OF_GAS);
    }

    public CardTypeSafety getCounterCard() {
        return CardTypeSafety.EXTRA_TANK;
    }

    public CardSafety getCounterCardInstance() {
        return new CardExtraTank();
    }
}
