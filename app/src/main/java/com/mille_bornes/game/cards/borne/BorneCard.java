package com.mille_bornes.game.cards.borne;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.BorneEnum;

/**
 * Abstract class representing a borne card in the Mille Bornes game.
 * This class extends the Card class and provides functionality specific to borne cards.
 */
public abstract class BorneCard extends Card {

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
     * {@inheritDoc}
     */
    public void action(Player player){
        player.setGameScore(player.getGameScore() + borne.getValue());
    }
}
