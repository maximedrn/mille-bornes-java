package com.mille_bornes.players;
import com.mille_bornes.utils.StateEnum;
import com.mille_bornes.cards.*;
import java.util.ArrayList;

public abstract class Player {
    private String name;
    private int globalScore;
    private int gameScore;
    private ArrayList<Card> deck;
    private ArrayList<StateEnum> states;
    private boolean play;
    private boolean discard;

    public Player(String name){
        this.name = name;
        globalScore = 0;
        gameScore = 0;
        play = false;
        discard = false;
        deck = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public int getGlobalScore(){
        return globalScore;
    }

    public void setGlobalScore(int score){
        if(score > -1){
            globalScore = score;
        }
    }

    public int getGameScore(){
        return gameScore;
    }

    public void setGameScore(int score){
        if(score > -1){
            gameScore = score;
        }
    }

    public Card getCard(int index){
        return ((index > -1) && (index < deck.size()))? deck.get(index) : null;
    }

    public void addCard(Card card){
        if(card != null){
            deck.add(card);
        }
    }

    public void delCard(int index){
        if((index > -1) && (index < deck.size())){
            deck.remove(index);
        }
    }

    public void clearDeck(){
        deck.clear();
    }

    public int deckSize(){
        return deck.size();
    }

    public StateEnum getState(int index){
        return ((index > -1) && (index < states.size()))? states.get(index) : null;
    }

    public void addState(StateEnum state){
        if(state != null){
            states.add(state);
        }
    }

    public void delState(int index){
        if((index > -1) && (index < states.size())){
            states.remove(index);
        }
    }

    public void clearStates(){
        states.clear();
    }

    public int statesSize(){
        return states.size();
    }

    public boolean getPlay(){
        return play;
    }

    public boolean getDiscard(){
        return discard;
    }

    public Card playCard(int index){
        Card card = getCard(index);
        delCard(index);
        play = true;
        discard = false;
        return card;
    }

    public Card discardCard(int index){
        Card card = getCard(index);
        delCard(index);
        discard = true;
        play = false;
        return card;
    }

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
