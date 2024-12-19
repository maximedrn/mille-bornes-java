package com.mille_bornes.core.cards.distance;

import com.mille_bornes.constants.cards.CardTypeHazard;
import com.mille_bornes.constants.cards.CardType;


public class CardDistance50 extends CardDistance {

    public CardDistance50() {
        super(CardType.MILEAGE_50);
    }

    @Override
    public CardTypeHazard getHazardCard() {
        return CardTypeHazard.NULL;
    }
}
