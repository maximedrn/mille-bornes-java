package com.mille_bornes.game.cards.botte;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;

public class DrivingAceCard extends Card {

    public DrivingAceCard(){
        super("as du volant");
    }

    public boolean isPlayable(Player player) {
        return true;
    }

    public void action(Player player) {
        player.addState(StateEnum.AS_DU_VOLANT);
        if(player.hasState(StateEnum.ACCIDENT)){
            player.delState(StateEnum.ACCIDENT);
        }
    }
    
}
