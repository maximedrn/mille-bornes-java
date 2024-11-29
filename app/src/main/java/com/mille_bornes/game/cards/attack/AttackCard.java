package com.mille_bornes.game.cards.attack;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.players.Player;

/**
 * Abstract class representing a attack card in the Mille Bornes game.
 * This class extends the Card class and provides functionality specific to attack cards.
 */
public abstract class AttackCard extends Card {

    /**
     * Constructs an AttackCard with the specified name.
     *
     * @param name the name of the attack card
     */
    public AttackCard(String name) {
        super(name);
    }

    /**
     * Determines if the attack card is playable against the specified opponent.
     *
     * @param opponent the player who is the opponent
     * @return true if the card is playable, false otherwise
     */
    public abstract boolean isPlayable(Player opponent);

    /**
     * Executes the action of the attack card against the specified opponent.
     *
     * @param opponent the player who is the opponent
     */
    public abstract void action(Player opponent);
}

