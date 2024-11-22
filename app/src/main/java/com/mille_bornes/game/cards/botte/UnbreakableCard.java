package com.mille_bornes.game.cards.botte;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;

public class UnbreakableCard extends Card {

    public UnbreakableCard(){
        super("increvable");
    }

    public boolean isPlayable(Player player) {
        return true;
    }

    public void action(Player player) {
        player.addState(StateEnum.INCREVABLE);
        if(player.hasState(StateEnum.CREVAISON)){
            player.delState(StateEnum.CREVAISON);
        }
    }
    
}
