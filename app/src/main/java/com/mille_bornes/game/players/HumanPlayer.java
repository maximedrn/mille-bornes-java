package com.mille_bornes.game.players;

import java.util.List;
import com.mille_bornes.game.cards.Card;

public class HumanPlayer extends Player {
    public HumanPlayer(String name){
        super(name);
    }

    public Card selectionAction(List<Player> opponents){
        return null;
    }
}
