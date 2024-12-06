package com.mille_bornes.game.cards.borne;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.BorneEnum;

/**
 * Abstract class representing a borne card in the Mille Bornes game.
 * This class extends the Card class and provides functionality specific to borne cards.
 */
public abstract class BorneCard extends Card implements Comparable<BorneCard> {

    private BorneEnum borne;
    
    /**
     * Constructs a BorneCard with the specified BorneEnum.
     *
     * @param borne the BorneEnum representing the type of Borne card
     */
    public BorneCard(BorneEnum borne) {
        super(borne.toString());
        this.borne = borne;
    }

    /**
     * {@inheritDoc}
     */
    public abstract boolean isPlayable(Player player);

    /**
     * Retrieves the value of the borne.
     *
     * @return the value of the borne
     */
    public int getBorneValue(){
        return borne.getValue();
    }

    /**
     * {@inheritDoc}
     */
    public void action(Player player){
        player.setGameScore(player.getGameScore() + borne.getValue());
    }

    /**
     * Compares this Card object with the specified Card object for order.
     * Returns a negative integer, zero, or a positive integer as this Card
     * is less than, equal to, or greater than the specified Card.
     *
     * @param card the Card to be compared
     * @return a negative integer, zero, or a positive integer as this Card
     *         is less than, equal to, or greater than the specified Card
     */
    public abstract int compareTo(BorneCard card);
}