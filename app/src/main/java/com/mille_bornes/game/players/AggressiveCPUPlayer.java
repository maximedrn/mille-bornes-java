package com.mille_bornes.game.players;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.AbstractMap.SimpleEntry;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.cards.attack.AttackCard;
import com.mille_bornes.game.cards.borne.BorneCard;
import com.mille_bornes.game.cards.botte.BotteCard;

public class AggressiveCPUPlayer extends CPUPlayer {
    public AggressiveCPUPlayer(){
        super("bot 1");
    }

    public Card cpustrategy(List<Player> opponents) {
        ArrayList<Card> attackDeck = new ArrayList<>();
        ArrayList<Card> borneDeck = new ArrayList<>();
        ArrayList<Card> defenseDeck = new ArrayList<>();
        ArrayList<Card> botteDeck = new ArrayList<>();
        Random rand = new Random();

        for(Card card : deck){
            if(card.getClass() == AttackCard.class){
                attackDeck.add(card);
            }
            else if(card.getClass() == BorneCard.class){
                borneDeck.add(card);
            }
            else if(card.getClass() == BotteCard.class){
                botteDeck.add(card);
            }
            else{
                defenseDeck.add(card);
            }
        }

        if((!attackDeck.isEmpty()) && (rand.nextDouble() < 0.7)){
            ArrayList<SimpleEntry<Player,Card>> attackList = new ArrayList<>();
            for(Player opponent : opponents){
                for(Card card : attackDeck){
                    if(card.isPlayable(opponent)){
                        attackList.add(new SimpleEntry<>(opponent, card));
                    }
                }
            }

            if(!attackList.isEmpty()){
                SimpleEntry<Player, Card> attack = attackList.get(rand.nextInt(attackList.size()));
                attack.getValue().action(attack.getKey());
                return attack.getValue();
            }
        }

        ArrayList<Card> borneList = new ArrayList<>();
        for(Card card : borneDeck){
            
        }

        return null;
    }
}
