package com.mille_bornes;

import java.util.ArrayList;
import java.util.Collections;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.cards.attack.AccidentCard;
import com.mille_bornes.game.cards.attack.FlatTireCard;
import com.mille_bornes.game.cards.attack.NoGasCard;
import com.mille_bornes.game.cards.attack.SpeedLimitCard;
import com.mille_bornes.game.cards.attack.StopCard;
import com.mille_bornes.game.cards.borne.Borne100Card;
import com.mille_bornes.game.cards.borne.Borne200Card;
import com.mille_bornes.game.cards.borne.Borne25Card;
import com.mille_bornes.game.cards.borne.Borne50Card;
import com.mille_bornes.game.cards.borne.Borne75Card;
import com.mille_bornes.game.cards.botte.ExtraTankCard;
import com.mille_bornes.game.cards.botte.PrioritaryCard;
import com.mille_bornes.game.cards.botte.UnbreakableCard;
import com.mille_bornes.game.cards.remedy.DriveCard;
import com.mille_bornes.game.cards.remedy.EndLimitCard;
import com.mille_bornes.game.cards.remedy.GasCardCard;
import com.mille_bornes.game.cards.remedy.RepairCard;
import com.mille_bornes.game.cards.remedy.SpareTireCard;
import com.mille_bornes.game.database.DataBaseDAO;
import com.mille_bornes.game.players.Player;

public class Game {
    private boolean isEnd;

    private Player winner;

    private ArrayList<Player> players;

    private DataBaseDAO dbDAO;

    private ArrayList<Card> pit;

    private ArrayList<Card> deck;

    private int round;

    Game(ArrayList<Player> players, DataBaseDAO dbDAO){
        this.players = players;
        this.dbDAO = dbDAO;
        winner = null;
        isEnd = false;
        pit = new ArrayList<>();
        deck = new ArrayList<>();
        round = 0;
    }

    private void initDeck(){
        deck.add(new DriveCard());
        deck.add(new ExtraTankCard());
        deck.add(new PrioritaryCard());
        deck.add(new UnbreakableCard());

        for(int i = 0; i < 3; i++){
            deck.add(new NoGasCard());
            deck.add(new FlatTireCard());
            deck.add(new AccidentCard());
        }

        for(int i = 0; i < 4; i++){
            deck.add(new SpeedLimitCard());
            deck.add(new Borne200Card());
        }

        for(int i = 0; i < 5; i++){
            deck.add(new StopCard());
        }

        for(int i = 0; i < 6; i++){
            deck.add(new EndLimitCard());
            deck.add(new GasCardCard());
            deck.add(new SpareTireCard());
            deck.add(new RepairCard());
        }

        for(int i = 0; i < 10; i++){
            deck.add(new Borne25Card());
            deck.add(new Borne50Card());
            deck.add(new Borne75Card());
        }

        for(int i = 0; i < 12; i++){
            deck.add(new Borne100Card());
        }

        for(int i = 0; i < 14; i++){
            deck.add(new DriveCard());
        }

        Collections.shuffle(deck);
    }

    private void initGame(){
        winner = null;
        isEnd = false;
        pit.clear();
        deck.clear();
        initDeck();
        round = 0;
    }

    private void drawCard(Player player){
        if(deck.isEmpty()){
            deck.addAll(pit);
            Collections.reverse(deck);
            pit.clear();
        }

        player.addCard(deck.getFirst());
        deck.removeFirst();
    }

    private void saveRound(){

    }

    private String printRound(){
        return "Round : {\t\nnumero : " + round;
    }

    private void round(){

    }

    private void saveGame(){

    }

    public void playGame(){
        initGame();
    }

    public String toString(){
        return null;
    }
}
