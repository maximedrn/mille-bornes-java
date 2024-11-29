package com.mille_bornes.game.cards.botte;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.players.Player;

public abstract class BotteCard extends Card {

    private boolean coupFourre;

    public BotteCard(String name){
        super(name);
        coupFourre = false;
    }

    public boolean getCoupFourre(){
        return coupFourre;
    }

    public void setCoupFourre(boolean coupFourre){
        this.coupFourre = coupFourre;
    }

    public abstract boolean isPlayable(Player player);

    public abstract boolean isCoupFourre(Player player);

    public abstract void action(Player player);
    
}