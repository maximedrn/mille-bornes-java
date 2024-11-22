package com.mille_bornes.game.cards.botte;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;

public class ExtraTankCard extends Card {

    public ExtraTankCard(){
        super("citerne");
    }

    public boolean isPlayable(Player player) {
        return true;
    }

    public void action(Player player) {
        player.addState(StateEnum.CITERNE);
        if(player.hasState(StateEnum.PANNE)){
            player.delState(StateEnum.PANNE);
        }
    }
    
}
