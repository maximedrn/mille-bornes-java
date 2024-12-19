package com.mille_bornes.core.cards.hazard;

import com.mille_bornes.constants.cards.CardTypeSafety;
import com.mille_bornes.core.cards.safety.CardRightOfWay;
import com.mille_bornes.core.cards.safety.CardSafety;
import com.mille_bornes.constants.cards.CardType;

public class CardSpeedLimit extends CardHazard {

    public CardSpeedLimit() {
        super(CardType.SPEED_LIMIT);
    }

    public CardTypeSafety getCounterCard() {
        return CardTypeSafety.RIGHT_OF_WAY;
    }

    public CardSafety getCounterCardInstance() {
        return new CardRightOfWay();
    }
}
