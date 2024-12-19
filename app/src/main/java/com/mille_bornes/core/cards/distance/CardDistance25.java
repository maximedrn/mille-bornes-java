package com.mille_bornes.core.cards.distance;

import com.mille_bornes.constants.cards.CardTypeHazard;
import com.mille_bornes.constants.cards.CardType;


public class CardDistance25 extends CardDistance {

    public CardDistance25() {
        super(CardType.MILEAGE_25);
    }

    @Override
    public CardTypeHazard getHazardCard() {
        return CardTypeHazard.NULL;
    }
}
