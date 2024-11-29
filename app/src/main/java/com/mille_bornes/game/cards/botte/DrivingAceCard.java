package com.mille_bornes.game.cards.botte;

import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;

public class DrivingAceCard extends BotteCard {

    public DrivingAceCard(){
        super("as du volant");
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
        return player.hasState(StateEnum.ACCIDENT);
    }

    /**
     * {@inheritDoc}
    */
    public void action(Player player) {
        setCoupFourre(false);
        player.addState(StateEnum.AS_DU_VOLANT);
        if(isCoupFourre(player)){
            setCoupFourre(true);
            player.delState(StateEnum.ACCIDENT);
        }
    }
}
