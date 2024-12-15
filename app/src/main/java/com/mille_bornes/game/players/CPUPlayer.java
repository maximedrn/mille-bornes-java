package com.mille_bornes.game.players;

import java.util.List;

/**
 * Abstract class representing a CPU player in the Mille Bornes game.
 * This class extends the Player class and provides a method for CPU strategy.
 */
public abstract class CPUPlayer extends Player {
    
    /**
     * Constructs a CPUPlayer with the specified name.
     *
     * @param name the name of the CPU player
     */
    public CPUPlayer(String name) {
        super(name);
    }

    /**
     * Defines the strategy for the CPU player against a list of opponents.
     *
     * @param opponents a list of Player objects representing the opponents
     * @return the selected Card by the CPU player and the selected opponent
     */
    public abstract List<Object> CPUStrategy(List<Player> opponents);
}
