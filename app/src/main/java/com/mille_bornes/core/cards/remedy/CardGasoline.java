package com.mille_bornes.core.cards.remedy;

import com.mille_bornes.constants.cards.CardTypeHazard;
import com.mille_bornes.constants.cards.CardTypeSafety;
import com.mille_bornes.core.cards.hazard.CardHazard;
import com.mille_bornes.core.cards.hazard.CardOutOfGas;
import com.mille_bornes.core.cards.safety.CardExtraTank;
import com.mille_bornes.core.cards.safety.CardSafety;
import com.mille_bornes.constants.cards.CardType;


public class CardGasoline extends CardRemedy {

    public CardGasoline() {
        super(CardType.GASOLINE);
    }

    @Override
    public CardTypeHazard getHazardCard() {
        return CardTypeHazard.OUT_OF_GAS;
    }

    @Override
    public CardHazard getHazardCardInstance() {
        return new CardOutOfGas();
    }

    @Override
    public CardTypeSafety getCounterCard() {
        return CardTypeSafety.EXTRA_TANK;
    }

    @Override
    public CardSafety getCounterCardInstance() {
        return new CardExtraTank();
    }
}
