package com.mille_bornes.game.cards.remedy;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;

public class SpareTireCard extends Card {

    public SpareTireCard(){
        super("roue de secours");
    }

    public boolean isPlayable(Player player) {
        return player.hasState(StateEnum.CREVAISON);
    }

    public void action(Player player) {
        player.delState(StateEnum.CREVAISON);
    }
    
}
