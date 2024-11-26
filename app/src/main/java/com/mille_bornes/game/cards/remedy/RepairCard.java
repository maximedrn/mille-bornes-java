package com.mille_bornes.game.cards.remedy;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;

public class RepairCard extends Card {

    public RepairCard(){
        super("reparation");
    }

    public boolean isPlayable(Player player) {
        return player.hasState(StateEnum.ACCIDENT);
    }

    public void action(Player player) {
        player.delState(StateEnum.ACCIDENT);
    }
    
}
