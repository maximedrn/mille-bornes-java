package com.mille_bornes.game.cards.botte;

import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;

public class PrioritaryCard extends BotteCard {

    public PrioritaryCard(){
        super("prioritaire");
    }

    /**
     * {@inheritDoc}
    */
    public boolean isPlayable(Player player) {
        return true;
    }

    /**
     * {@inheritDoc}
    */
    public boolean isCoupFourre(Player player) {
        return player.hasState(StateEnum.ARRET) || player.hasState(StateEnum.LIMITATION);
    }

    /**
     * {@inheritDoc}
    */
    public void action(Player player) {
        setCoupFourre(false);
        player.addState(StateEnum.PRIORITAIRE);
        if(player.hasState(StateEnum.ARRET)){
            setCoupFourre(true);
            player.delState(StateEnum.ARRET);
        }

        if(player.hasState(StateEnum.LIMITATION)){
            setCoupFourre(true);
            player.delState(StateEnum.LIMITATION);
        }
    }
    
}
