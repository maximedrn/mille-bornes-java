package com.mille_bornes.core.cards.remedy;

import com.mille_bornes.constants.cards.CardTypeHazard;
import com.mille_bornes.constants.cards.CardTypeSafety;
import com.mille_bornes.core.cards.hazard.CardHazard;
import com.mille_bornes.core.cards.hazard.CardRedLight;
import com.mille_bornes.core.cards.safety.CardRightOfWay;
import com.mille_bornes.core.cards.safety.CardSafety;
import com.mille_bornes.constants.cards.CardType;


public class CardGreenLight extends CardRemedy {

    public CardGreenLight() {
        super(CardType.GREEN_LIGHT);
    }

    @Override
    public CardTypeHazard getHazardCard() {
        return CardTypeHazard.RED_LIGHT;
    }

    @Override
    public CardHazard getHazardCardInstance() {
        return new CardRedLight();
    }

    @Override
    public CardTypeSafety getCounterCard() {
        return CardTypeSafety.RIGHT_OF_WAY;
    }

    @Override
    public CardSafety getCounterCardInstance() {
        return new CardRightOfWay();
    }
}
