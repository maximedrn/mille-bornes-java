package com.mille_bornes.game.cards.remedy;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;

public class GasCardCard extends Card {

    public GasCardCard(){
        super("essence");
    }

    public boolean isPlayable(Player player) {
        return player.hasState(StateEnum.PANNE);
    }

    public void action(Player player) {
        player.delState(StateEnum.PANNE);
    }
    
}
