package com.mille_bornes.game.cards.botte;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.players.Player;

/**
 * Abstract class representing a botte card in the Mille Bornes game.
 * This class extends the Card class and provides functionality specific to botte cards.
 */
public abstract class BotteCard extends Card {

    private boolean coupFourre;

    /**
     * Constructs a BotteCard with the specified name.
     *
     * @param name the name of the card
     */
    public BotteCard(String name){
        super(name);
        coupFourre = false;
    }

    /**
     * Returns whether the coupFourre is active.
     *
     * @return true if coupFourre is active, false otherwise
     */
    public boolean getCoupFourre(){
        return coupFourre;
    }

    /**
     * Sets the state of coupFourre.
     *
     * @param coupFourre the new state of coupFourre
     */
    public void setCoupFourre(boolean coupFourre){
        this.coupFourre = coupFourre;
    }

    /**
     * {@inheritDoc}
     */
    public abstract boolean isPlayable(Player player);

    /**
     * Checks if the coupFourre can be applied to the specified player.
     *
     * @param player the player to check
     * @return true if coupFourre can be applied, false otherwise
     */
    public abstract boolean isCoupFourre(Player player);

    /**
     * {@inheritDoc}
     */
    public abstract void action(Player player);
    
}
