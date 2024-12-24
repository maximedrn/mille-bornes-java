package com.mille_bornes.game.players;

import java.util.ArrayList;
import java.util.List;

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
     * @return the selected Card by the human player and the selected opponent
     */
    public List<Object> selectAction(){
        while(!hasPlayed){
            // Wait for user to play
        }
        ArrayList<Object> returnList = new ArrayList<>();
        
        Card card = cardPlayed;
        cardPlayed = null;
        returnList.add(card);

        Player player = oppenentSelected;
        if(oppenentSelected != null){
            oppenentSelected = null;
        }
        returnList.add(player);

        delCard(card);
        hasPlayed = false;
        return returnList;
    }

    /**
     * Plays a card against an opponent or oneself.
     *
     * @param card the card to be played
     * @param opponent the opponent player
     * @return true if the card was successfully played, false otherwise
     */
    public boolean play(Card card, Player opponent){
        if((card != null) && (hasCard(card))){
            if(card instanceof AttackCard){
                if((opponent != null) && (card.isPlayable(opponent))){
                    card.action(opponent);
                    cardPlayed = card;
                    hasPlayed = true;
                    playCard();
                    return true;
                }
            }
    
            else {
                if(card.isPlayable(this)){
                    card.action(this);
                    cardPlayed = card;
                    hasPlayed = true;
                    playCard();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean discard(Card card){
        if((card != null) && (hasCard(card))){
            cardPlayed = card;
            hasPlayed = true;
            discardCard();
            return true;
        }
        return false;
    }
}