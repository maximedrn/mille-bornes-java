package com.mille_bornes.game.players;

import java.util.List;
import com.mille_bornes.game.cards.Card;

/**
 * Represents a human player in the Mille Bornes game.
 * This class extends the Player class and provides functionality
 * specific to human players.
 */
public class HumanPlayer extends Player {
    
    /**
     * Constructs a new HumanPlayer with the specified name.
     *
     * @param name the name of the player
     */
    public HumanPlayer(String name){
        super(name);
    }

    /**
     * Allows the human player to select an action based on the current game state.
     *
     * @param opponents a list of opponent players
     * @return the selected Card action by the human player
     */
    public Card selectionAction(List<Player> opponents){
        return null;
    }
}
