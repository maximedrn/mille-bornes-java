package com.mille_bornes.game.utils;

import java.util.ArrayList;
import java.util.Collections;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.cards.attack.AccidentCard;
import com.mille_bornes.game.cards.attack.AttackCard;
import com.mille_bornes.game.cards.attack.FlatTireCard;
import com.mille_bornes.game.cards.attack.NoGasCard;
import com.mille_bornes.game.cards.attack.SpeedLimitCard;
import com.mille_bornes.game.cards.attack.StopCard;
import com.mille_bornes.game.cards.borne.Borne100Card;
import com.mille_bornes.game.cards.borne.Borne200Card;
import com.mille_bornes.game.cards.borne.Borne25Card;
import com.mille_bornes.game.cards.borne.Borne50Card;
import com.mille_bornes.game.cards.borne.Borne75Card;
import com.mille_bornes.game.cards.borne.BorneCard;
import com.mille_bornes.game.cards.botte.BotteCard;
import com.mille_bornes.game.cards.botte.DrivingAceCard;
import com.mille_bornes.game.cards.botte.ExtraTankCard;
import com.mille_bornes.game.cards.botte.PrioritaryCard;
import com.mille_bornes.game.cards.botte.UnbreakableCard;
import com.mille_bornes.game.cards.remedy.DriveCard;
import com.mille_bornes.game.cards.remedy.EndLimitCard;
import com.mille_bornes.game.cards.remedy.GasCardCard;
import com.mille_bornes.game.cards.remedy.RepairCard;
import com.mille_bornes.game.cards.remedy.SpareTireCard;
import com.mille_bornes.game.database.DataBaseDAO;
import com.mille_bornes.game.players.CPUPlayer;
import com.mille_bornes.game.players.HumanPlayer;
import com.mille_bornes.game.players.Player;

public class Game {
    private boolean isEnd;

    private Player winner;

    private ArrayList<Player> players;

    private DataBaseDAO dbDAO;

    private ArrayList<Card> pit;

    private ArrayList<Card> deck;

    private int round;

    /**
     * Constructs a Game instance with the specified players and database access object.
     *
     * @param players the list of players participating in the game
     * @param dbDAO the database access object for saving/loading game data
     */
    Game(ArrayList<Player> players, DataBaseDAO dbDAO){
        this.players = new ArrayList<>();
        this.players.addAll(players);
        this.dbDAO = dbDAO;
        winner = null;
        isEnd = false;
        pit = new ArrayList<>();
        deck = new ArrayList<>();
        round = 0;
    }

    /**
     * Initializes the deck with the appropriate cards for the game.
     */
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

    /**
     * Initializes the game state for a new game.
     */
    private void initGame(){
        winner = null;
        isEnd = false;
        pit.clear();
        deck.clear();
        initDeck();
        round = 0;
    }

    /**
     * Draws a card for the specified player from the deck.
     *
     * @param player the player who is drawing a card
     */
    private void drawCard(Player player){
        if(deck.isEmpty()){
            deck.addAll(pit);
            Collections.reverse(deck);
            pit.clear();
        }

        player.addCard(deck.getFirst());
        deck.removeFirst();
    }

    /**
     * Saves the current round's state.
     */
    private void saveRound(){

    }

    /**
     * Prints the details of the current round.
     *
     * @param roundPlayer the player who played in the current round
     * @param cardSelected the card that was played
     * @param opponentSelected the opponent affected by the card
     * @return a string representation of the round details
     */
    private String printRound(Player roundPlayer, Card cardSelected, Player oppenentSelected){
        String str = "round " + round + " : " + roundPlayer.getName();
        if(roundPlayer.getPlay()){
            str += " has played " + cardSelected;
            if(cardSelected instanceof AttackCard){
                str += " against " + oppenentSelected.getName();
            }
        }

        else if(roundPlayer.getDiscard()){
            str += " has discarded " + cardSelected;
        }

        if(roundPlayer.getGameScore() >= 700){
            str += "and " + roundPlayer.getName() + " has won";
        }

        return str += ".\n";
    }

    /**
     * Executes a round of the game.
     */
    private void round(){
        round++;
        Player roundPlayer = players.get(round % players.size());
        Card card;
        Player oppenentSelected;
        ArrayList<Player> opponents = new ArrayList<>();
        ArrayList<Object> returnList = new ArrayList<>();
        opponents.addAll(players);
        opponents.remove(roundPlayer);
        drawCard(roundPlayer);

        if(roundPlayer instanceof CPUPlayer){
            returnList = (ArrayList<Object>) ((CPUPlayer)roundPlayer).CPUStrategy(opponents);
        }

        else {
            returnList = (ArrayList<Object>) ((HumanPlayer)roundPlayer).selectAction();
        }
        card = (Card) returnList.get(0);
        oppenentSelected = (Player) returnList.get(1);

        if(roundPlayer.getPlay()){
            if(card instanceof BotteCard){
                if(((BotteCard) card).getCoupFourre()){
                    if(card instanceof PrioritaryCard){
                        if(((PrioritaryCard) card).isLimitation()){
                            pit.add(new SpeedLimitCard());
                        }

                        else{
                            pit.add(new StopCard());
                        }
                    }

                    else if(card instanceof DrivingAceCard){
                        pit.add(new AccidentCard());
                    }

                    else if(card instanceof ExtraTankCard){
                        pit.add(new NoGasCard());
                    }

                    else{
                        pit.add(new FlatTireCard());
                    }
                }
            }

            else if((!(card instanceof BorneCard)) && (!(card instanceof AttackCard))){
                if(card instanceof DriveCard){
                    pit.add(new StopCard());
                }

                else if(card instanceof EndLimitCard){
                    pit.add(new SpeedLimitCard());
                }

                else if(card instanceof GasCardCard){
                    pit.add(new NoGasCard());
                }

                else if(card instanceof RepairCard){
                    pit.add(new AccidentCard());
                }

                else{
                    pit.add(new FlatTireCard());
                }

                pit.add(card);
            }
        }

        else if(roundPlayer.getDiscard()){
            pit.add(card);
        }

        if(roundPlayer.getGameScore() >= 700){
            winner = roundPlayer;
            isEnd = true;
        }

        saveRound();
        System.out.print(printRound(roundPlayer, card, oppenentSelected));
    }


    /**
     * Starts the game and continues until a winner is determined.
     */
    public void playGame(){
        initGame();
        while(!isEnd){
            round();
        }
    }

    /**
     * Returns a string representation of the current game state.
     *
     * @return a string representation of the game
     */
    public String toString(){
        String string = "Game : {\t\nnumero : " + round + ",\n\tpit : {";

        if(!pit.isEmpty()){
            for(int i = 0; i < pit.size() - 1; i++){
                string += pit.get(i) + ", ";
            }
            string += pit.getLast();
        }

        string += "},\n\tdeck : {";

        if(!deck.isEmpty()){
            for(int i = 0; i < deck.size() - 1; i++){
                string += deck.get(i) + ", ";
            }
            string += deck.getLast();
        }

        string += "},\n\tplayers : {";

        if(!players.isEmpty()){
            for(int i = 0; i < players.size() - 1; i++){
                string += players.get(i).toString().replaceAll("(?m)^", "\t") + ", ";
            }
            string += players.getLast();
        }

        return string += "},\n\twinner : " + (winner != null? winner.getName() : "null") + ", \n\tisEnd : " + (isEnd ? "yes" : "no") + "\n}";
    }
}