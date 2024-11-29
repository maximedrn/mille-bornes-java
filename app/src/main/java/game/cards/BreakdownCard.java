package game.cards;

import game.players.Player;

public class BreakdownCard extends Card {
   
    
    public BreakdownCard(String name){
        //constructeur
        super(name);
    }

    public boolean isPlayable(Player player){
        /*
         * vérifier les conndictions!
         */
        return true;
    }
    /*
     * 
     */
    public  void action(Player player){

    }
    /*
     * 
     */
    public  String toString(){
        return " Carte Breakdown ";
    }
}
