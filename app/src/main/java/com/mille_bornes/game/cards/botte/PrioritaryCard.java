package com.mille_bornes.game.cards.botte;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;

public class PrioritaryCard extends Card {

    public PrioritaryCard(){
        super("prioritaire");
    }

    public boolean isPlayable(Player player) {
        return true;
    }

    public void action(Player player) {
        player.addState(StateEnum.PRIORITAIRE);
        if(player.hasState(StateEnum.ARRET)){
            player.delState(StateEnum.ARRET);
        }

        if(player.hasState(StateEnum.LIMITATION)){
            player.delState(StateEnum.LIMITATION);
        }
    }
    
}
