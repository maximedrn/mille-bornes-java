package com.mille_bornes.game.cards.borne;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.BorneEnum;

public abstract class BorneCard extends Card {

    private BorneEnum borne;
    
    public BorneCard(BorneEnum borne) {
        super(borne.toString());
        this.borne = borne;
    }

    public abstract boolean isPlayable(Player player);

    public void action(Player player){
        player.setGameScore(player.getGameScore() + borne.getValue());
    }
}
