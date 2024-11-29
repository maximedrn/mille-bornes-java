package game.cards;

import game.players.Player;

public abstract class AttackCard extends Card{
   
    public AttackCard(String name){
        super(name);
    }
    public  boolean isPlayable(Player player){
        /*
         * 
         */
        return true;
    }
    public  void action(Player player){
        /*
         * 
         */
    }
    public  String toString(){
        /*
         * 
         */
        return "Carte Attaque : "+getName();
    }
}
