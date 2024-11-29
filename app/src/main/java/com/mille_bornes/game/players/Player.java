package com.mille_bornes.game.players;

import com.mille_bornes.game.cards.*;
import com.mille_bornes.game.utils.StateEnum;
import java.util.ArrayList;

/**
 * Abstract class representing a player in the Mille Bornes game.
 */
public abstract class Player {
    protected String name;
    protected int globalScore;
    protected int gameScore;
    protected ArrayList<Card> deck;
    protected ArrayList<StateEnum> states;
    protected boolean play;
    protected boolean discard;

    /**
     * Constructs a Player with the specified name.
     * 
     * @param name the name of the player
     */
    public Player(String name){
        this.name = name;
        globalScore = 0;
        gameScore = 0;
        play = false;
        discard = false;
        deck = new ArrayList<>();
    }

    /**
     * Returns the name of the player.
     * 
     * @return the name of the player
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the global score of the player.
     * 
     * @return the global score
     */
    public int getGlobalScore(){
        return globalScore;
    }

    /**
     * Sets the global score of the player.
     * 
     * @param score the new global score
     */
    public void setGlobalScore(int score){
        if(score > -1){
            globalScore = score;
        }
    }

    /**
     * Returns the game score of the player.
     * 
     * @return the game score
     */
    public int getGameScore(){
        return gameScore;
    }

    /**
     * Sets the game score of the player.
     * 
     * @param score the new game score
     */
    public void setGameScore(int score){
        if(score > -1){
            gameScore = score;
        }
    }

    /**
     * Retrieves a card from the player's deck at the specified index.
     * 
     * @param index the index of the card
     * @return the card at the specified index, or null if index is invalid
     */
    public Card getCard(int index){
        return ((index > -1) && (index < deck.size()))? deck.get(index) : null;
    }

    /**
     * Adds a card to the player's deck.
     * 
     * @param card the card to be added
     */
    public void addCard(Card card){
        if(card != null){
            deck.add(card);
        }
    }

    /**
     * Removes a card from the player's deck at the specified index.
     * 
     * @param index the index of the card to be removed
     */
    public void delCard(int index){
        if((index > -1) && (index < deck.size())){
            deck.remove(index);
        }
    }

    /**
     * Removes a specific card from the player's deck.
     * 
     * @param card the card to be removed
     */
    public void delCard(Card card){
        if((card != null) && (hasCard(card))){
            deck.remove(card);
        }
    }

    /**
     * Clears all cards from the player's deck.
     */
    public void clearDeck(){
        deck.clear();
    }

    /**
     * Returns the number of cards in the player's deck.
     * 
     * @return the size of the deck
     */
    public int deckSize(){
        return deck.size();
    }

    /**
     * Checks if the player has a specific card in their deck.
     * 
     * @param card the card to check
     * @return true if the card is in the deck, false otherwise
     */
    public boolean hasCard(Card card){
        return deck.contains(card);
    }

    /**
     * Retrieves a state from the player's states at the specified index.
     * 
     * @param index the index of the state
     * @return the state at the specified index, or null if index is invalid
     */
    public StateEnum getState(int index){
        return ((index > -1) && (index < states.size()))? states.get(index) : null;
    }

    /**
     * Adds a state to the player's states.
     * 
     * @param state the state to be added
     */
    public void addState(StateEnum state){
        if(state != null){
            states.add(state);
        }
    }

    /**
     * Removes a state from the player's states at the specified index.
     * 
     * @param index the index of the state to be removed
     */
    public void delState(int index){
        if((index > -1) && (index < states.size())){
            states.remove(index);
        }
    }

    /**
     * Removes a specific state from the player's states.
     * 
     * @param state the state to be removed
     */
    public void delState(StateEnum state){
        if((state != null) && (hasState(state))){
            states.remove(state);
        }
    }

    /**
     * Clears all states from the player's states.
     */
    public void clearStates(){
        states.clear();
    }

    /**
     * Checks if the player has a specific state.
     * 
     * @param state the state to check
     * @return true if the state is present, false otherwise
     */
    public boolean hasState(StateEnum state){
        return states.contains(state);
    }

    /**
     * Returns the number of states the player has.
     * 
     * @return the size of the states
     */
    public int statesSize(){
        return states.size();
    }

    /**
     * Returns whether the player is currently playing a card.
     * 
     * @return true if the player is playing a card, false otherwise
     */
    public boolean getPlay(){
        return play;
    }

    /**
     * Returns whether the player is currently discarding a card.
     * 
     * @return true if the player is discarding a card, false otherwise
     */
    public boolean getDiscard(){
        return discard;
    }

    /**
     * Plays a card from the player's deck at the specified index.
     * 
     * @param index the index of the card to be played
     * @return the played card
     */
    public Card playCard(int index){
        Card card = getCard(index);
        delCard(index);
        play = true;
        discard = false;
        return card;
    }

    /**
     * Discards a card from the player's deck at the specified index.
     * 
     * @param index the index of the card to be discarded
     * @return the discarded card
     */
    public Card discardCard(int index){
        Card card = getCard(index);
        delCard(index);
        discard = true;
        play = false;
        return card;
    }

    /**
     * Returns a string representation of the player.
     * 
     * @return a string containing player details
     */
    public String toString(){
        String string = "Player : {\n\tname : " + name + ",\n\tgameScore : " + gameScore + ",\n\tglobalScore : " + globalScore + ",\n\tdeck : {";
        
        if(deckSize() > 0){
            for(int i = 0; i < deckSize() - 1; i++){
                string += getCard(i) + ", ";
            }
            string += getCard(deckSize() - 1);
        }

        string += "},\n\tstates : {";
        
        if(statesSize() > 0){
            for(int i = 0; i < statesSize() - 1; i++){
                string += getState(i) + ", ";
            }
            string += getCard(statesSize() - 1);
        }

        string += "},\n\taction : ";
        
        if(play && !discard){
            string += "play";
        } else if (!play && discard){
            string += "discard";
        }

        return string += "\n}";
    }
}
