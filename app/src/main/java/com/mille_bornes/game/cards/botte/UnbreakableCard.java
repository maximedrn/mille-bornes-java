package com.mille_bornes.game.cards.botte;

import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;

public class UnbreakableCard extends BotteCard {

    public UnbreakableCard(){
        super("increvable");
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
        return player.hasState(StateEnum.CREVAISON);
    }

    /**
     * {@inheritDoc}
     */
    public void action(Player player) {
        setCoupFourre(false);
        player.addState(StateEnum.INCREVABLE);
        if(isCoupFourre(player)){
            setCoupFourre(true);
            player.delState(StateEnum.CREVAISON);
        }
    }
    
}
