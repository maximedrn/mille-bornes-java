package com.mille_bornes.game.players;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.cards.attack.AttackCard;

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
        hasPlayed = false;
        return card;
    }

    /**
     * Plays a card against an opponent or oneself.
     *
     * @param card the card to be played
     * @param opponent the opponent player
     * @return true if the card was successfully played, false otherwise
     */
    public boolean play(Card card, Player opponent){
        if(card instanceof AttackCard){
            if(card.isPlayable(opponent)){
                card.action(opponent);
                hasPlayed = true;
                return true;
            }
        }

        else {
            if(card.isPlayable(this)){
                card.action(this);
                hasPlayed = true;
                return true;
            }
        }
        return false;
    }
}
