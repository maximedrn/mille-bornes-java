package com.mille_bornes.core.cards.hazard;

import com.mille_bornes.constants.cards.CardArea;
import com.mille_bornes.constants.cards.CardTypeSafety;
import com.mille_bornes.constants.cards.CardType;
import com.mille_bornes.core.cards.ICardCounter;
import com.mille_bornes.core.cards.safety.CardSafety;
import com.mille_bornes.database.data.Card;
import com.mille_bornes.database.data.Player;


public abstract class CardHazard extends Card implements ICardCounter {

    public CardHazard(final CardType cardType) {
        super(cardType);
    }

    public abstract CardTypeSafety getCounterCard();
    public abstract CardSafety getCounterCardInstance();

    @Override
    public Boolean canBeAppliedTo(final Player player) {
        final CardArea cardArea = this.getType().getCardArea();
        final Boolean battleMode = player.isInBattleMode(cardArea);
        final CardTypeSafety counterCard = this.getCounterCard();
        final Boolean hasCounter = player.hasSafetyCard(counterCard);
        return !(battleMode || hasCounter);
    }
}
