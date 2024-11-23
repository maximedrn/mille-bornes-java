package com.mille_bornes.game.players;

import java.util.List;
import com.mille_bornes.game.cards.Card;

public class AggressiveCPUPlayer extends CPUPlayer {
    public AggressiveCPUPlayer(){
        super("bot 1");
    }

    public Card cpustrategy(List<Player> opponents) {
        return null;
    }
}
