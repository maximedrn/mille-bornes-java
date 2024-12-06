package com.mille_bornes.game.players;

import java.util.List;
import com.mille_bornes.game.cards.Card;

/**
 * Represents a human player in the Mille Bornes game.
 * This class extends the Player class and provides functionality
 * specific to human players.
 */
public class HumanPlayer extends Player {

    private boolean hasPlayed;

    private Card cardPlayed;

    private Player oppenentSelected;
    
    /**
     * Constructs a new HumanPlayer with the specified name.
     *
     * @param name the name of the player
     */
    public HumanPlayer(String name){
        super(name);
        hasPlayed = false;
        cardPlayed = null;
        oppenentSelected = null;
    }

    /**
     * Allows the human player to select an action based on the current game state.
     *
     * @return the selected Card action by the human player
     */
    public Card selectAction(){
        while(!hasPlayed){
            // Wait for user to play
        }
        
        Card card = cardPlayed;
        cardPlayed = null;
        if(getPlay()){
            if(oppenentSelected != null){
                card.action(oppenentSelected);
                oppenentSelected = null;
            }

            else{
                card.action(this);
            }
        }
        
        delCard(card);
        return card;
    }
}
