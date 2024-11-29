package com.mille_bornes.game.cards.botte;

import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;

public class ExtraTankCard extends BotteCard {

    public ExtraTankCard(){
        super("citerne");
    }

    public boolean isPlayable(Player player) {
        return true;
    }

    public boolean isCoupFourre(Player player) {
        return player.hasState(StateEnum.PANNE);
    }

    public void action(Player player) {
        setCoupFourre(false);
        player.addState(StateEnum.CITERNE);
        if(isCoupFourre(player)){
            setCoupFourre(true);
            player.delState(StateEnum.PANNE);
        }
    }
    
}
