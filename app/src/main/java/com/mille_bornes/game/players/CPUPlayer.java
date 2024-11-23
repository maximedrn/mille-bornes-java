package com.mille_bornes.game.players;

import java.util.List;
import com.mille_bornes.game.cards.Card;

public abstract class CPUPlayer extends Player {
    public CPUPlayer(String name) {
        super(name);
    }

    public abstract Card cpustrategy(List<Player> opponents);
}