package com.mille_bornes.game.cards;

import com.mille_bornes.game.players.Player;

/**
 * Abstract class representing a card in the Mille Bornes game.
 */
public abstract class Card {
    
    private String name;

    /**
     * Constructs a Card with the specified name.
     *
     * @param name the name of the card
     */
    public Card(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the card.
     *
     * @return the name of the card
     */
    public String getName() { 
        return name;
    }

    /**
     * Determines if the card is playable by the specified player.
     *
     * @param player the player to check
     * @return true if the card is playable, false otherwise
     */
    public abstract boolean isPlayable(Player player);

    /**
     * Executes the action associated with the card for the specified player.
     *
     * @param player the player to perform the action on
     */
    public abstract void action(Player player);

    /**
     * Returns a string representation of the card.
     *
     * @return a string representation of the card
     */
    public String toString(){
        return "carte " + name;
    }
}
