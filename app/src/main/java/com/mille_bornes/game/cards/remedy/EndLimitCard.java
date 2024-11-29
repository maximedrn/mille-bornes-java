package com.mille_bornes.game.cards.remedy;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;

public class EndLimitCard extends Card {

    public EndLimitCard(){
        super("fin de limitation");
    }

    /**
     * {@inheritDoc}
     */
    public boolean isPlayable(Player player) {
        return player.hasState(StateEnum.LIMITATION);
    }

    /**
     * {@inheritDoc}
     */
    public void action(Player player) {
        player.delState(StateEnum.LIMITATION);
    }
    
}
