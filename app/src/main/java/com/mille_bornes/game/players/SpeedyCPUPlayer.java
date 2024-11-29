package com.mille_bornes.game.players;

import java.util.List;
import com.mille_bornes.game.cards.Card;

public class SpeedyCPUPlayer extends CPUPlayer {
    public SpeedyCPUPlayer(){
        super("bot 2");
    }

    /**
     * {@inheritDoc}
     */
    public Card cpustrategy(List<Player> opponents) {
        return null;
    }
}