package com.mille_bornes.game.cards;

import com.mille_bornes.game.utils.StateEnum;
import com.mille_bornes.game.players.Player;

@SuppressWarnings("unused")
public abstract class Card {
    private String name;

    public Card(String name) {
        this.name = name;
    }

    public String getName() { 
        return name;
    }

    public abstract boolean isPlayable(Player player);

    public abstract void action(Player player);

    public String toString(){
        return "carte " + name;
    }
}
