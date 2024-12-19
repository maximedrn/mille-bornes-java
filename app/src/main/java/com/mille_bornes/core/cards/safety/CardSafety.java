package com.mille_bornes.core.cards.safety;

import com.mille_bornes.constants.cards.CardTypeHazard;
import com.mille_bornes.constants.cards.CardType;
import com.mille_bornes.constants.cards.ICardProperty;
import com.mille_bornes.core.cards.ICardCounter;
import com.mille_bornes.database.data.Card;
import com.mille_bornes.database.data.Player;


public class CardSafety extends Card implements ICardCounter {

    public CardSafety(final CardType cardType) {
        super(cardType);
    }

    @Override
    public ICardProperty getCounterCard() {
        return CardTypeHazard.NULL;
    }

    @Override
    public Boolean canBeAppliedTo(final Player player) {
        return true;
    }
}
