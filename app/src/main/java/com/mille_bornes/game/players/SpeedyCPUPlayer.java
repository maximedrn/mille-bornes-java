package com.mille_bornes.game.players;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.AbstractMap.SimpleEntry;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.cards.attack.AttackCard;
import com.mille_bornes.game.cards.borne.BorneCard;
import com.mille_bornes.game.cards.botte.BotteCard;
import com.mille_bornes.game.cards.botte.PrioritaryCard;
import com.mille_bornes.game.cards.remedy.EndLimitCard;
import com.mille_bornes.game.utils.StateEnum;

public class SpeedyCPUPlayer extends CPUPlayer {
    public SpeedyCPUPlayer(){
        super("bot 2");
    }

    /**
     * {@inheritDoc}
     */
    public List<Object> CPUStrategy(List<Player> opponents) {
        ArrayList<AttackCard> attackDeck = new ArrayList<>();
        ArrayList<BorneCard> borneDeck = new ArrayList<>();
        ArrayList<Card> defenseDeck = new ArrayList<>();
        ArrayList<BotteCard> botteDeck = new ArrayList<>();
        ArrayList<Object> returnList = new ArrayList<>();
        Random rand = new Random();

        for(Card card : deck){
            if(card instanceof AttackCard){
                attackDeck.add((AttackCard) card);
            }
            else if(card instanceof BorneCard){
                borneDeck.add((BorneCard) card);
            }
            else if(card instanceof BotteCard){
                botteDeck.add((BotteCard) card);
            }
            else{
                defenseDeck.add(card);
            }
        }

        if((!borneDeck.isEmpty()) && (rand.nextDouble() < 0.7)){
            ArrayList<BorneCard> borneList = new ArrayList<>();
            for(BorneCard card : borneDeck){
                if(card.isPlayable(this)){
                    borneList.add(card);
                }
            }

            if(!borneList.isEmpty()){
                if(this.hasState(StateEnum.LIMITATION)){
                    if((this.hasCard(new PrioritaryCard())) && (rand.nextDouble() < 0.5)){
                        Card card = getCard(getCardIndex(new PrioritaryCard()));
                        card.action(this);
                        playCard();
                        delCard(card);
                        returnList.add(card);
                        returnList.add(null);
                        return returnList;
                    }

                    if((this.hasCard(new EndLimitCard())) && (rand.nextDouble() < 0.5)){
                        Card card = getCard(getCardIndex(new EndLimitCard()));
                        card.action(this);
                        playCard();
                        delCard(card);
                        returnList.add(card);
                        returnList.add(null);
                        return returnList;
                    }
                }

                borneList.sort(Comparator.reverseOrder());
                Card card = borneList.get(0);
                card.action(this);
                playCard();
                delCard(card);
                returnList.add(card);
                returnList.add(null);
                return returnList;
            }
        }

        if(!botteDeck.isEmpty()){
            ArrayList<BotteCard> botteList = new ArrayList<>();
            for(BotteCard card : botteDeck){
                if((boolean) card.isCoupFourre(this)){
                    botteList.add(card);
                }
            }

            if(!botteList.isEmpty()){
                Card card = botteList.get(rand.nextInt(botteList.size()));
                card.action(this);
                playCard();
                delCard(card);
                returnList.add(card);
                returnList.add(null);
                return returnList;
            } 
            
            else if(rand.nextDouble() < 0.5){
                Card card = botteDeck.get(rand.nextInt(botteDeck.size()));
                card.action(this);
                playCard();
                delCard(card);
                returnList.add(card);
                returnList.add(null);
                return returnList;
            }
        }

        if(!defenseDeck.isEmpty()){
            ArrayList<Card> defenseList = new ArrayList<>();
            for(Card card : defenseDeck){
                if(card.isPlayable(this)){
                    defenseList.add(card);
                }
            }

            if(!defenseList.isEmpty()){
                Card card = defenseList.get(rand.nextInt(defenseList.size()));
                card.action(this);
                playCard();
                delCard(card);
                returnList.add(card);
                returnList.add(null);
                return returnList;
            }
        }

        if(attackDeck.isEmpty()){
            ArrayList<SimpleEntry<Player,AttackCard>> attackList = new ArrayList<>();
            for(Player opponent : opponents){
                for(AttackCard card : attackDeck){
                    if(card.isPlayable(opponent)){
                        attackList.add(new SimpleEntry<>(opponent, card));
                    }
                }
            }

            if(!attackList.isEmpty()){
                SimpleEntry<Player, AttackCard> attack = attackList.get(rand.nextInt(attackList.size()));
                attack.getValue().action(attack.getKey());
                playCard();
                delCard(attack.getValue());
                returnList.add(attack.getValue());
                returnList.add(attack.getKey());
                return returnList;
            }
        }

        Card card = null;
        while(card == null){
            card = getCard(rand.nextInt(deckSize()));
            if(card instanceof BotteCard){
                card = null;
            }
        }

        discardCard();
        delCard(card);
        returnList.add(card);
        returnList.add(null);
        return returnList;
    }
}