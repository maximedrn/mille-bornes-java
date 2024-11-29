package com.mille_bornes.game.cards.remedy;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;

public class DriveCard extends Card {

    public DriveCard(){
        super("feu vert");
    }

    /**
     * {@inheritDoc}
     */
    public boolean isPlayable(Player player) {
        return player.hasState(StateEnum.ARRET);
    }

    /**
     * {@inheritDoc}
     */
    public void action(Player player) {
        player.delState(StateEnum.ARRET);
    }
    
}
