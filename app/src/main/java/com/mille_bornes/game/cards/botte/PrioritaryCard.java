package com.mille_bornes.game.cards.botte;

import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;

public class PrioritaryCard extends BotteCard {
    
    private boolean arret;

    private boolean limitation;

    public PrioritaryCard(){
        super("prioritaire");
        arret = false;
        limitation = false;
    }

    /**
     * {@inheritDoc}
    */
    public boolean isPlayable(Player player) {
        return true;
    }

    /**
     * {@inheritDoc}
    */
    public boolean isCoupFourre(Player player) {
        return player.hasState(StateEnum.ARRET) || player.hasState(StateEnum.LIMITATION);
    }

    /**
     * Returns whether the arret is active.
     *
     * @return true if arret is active, false otherwise
     */
    public boolean isArret(){
        return arret;
    }

    /**
     * Returns whether the limitation is active.
     *
     * @return true if limitation is active, false otherwise
     */
    public boolean isLimitation(){
        return limitation;
    }

    /**
     * {@inheritDoc}
    */
    public void action(Player player) {
        arret = false;
        limitation = false;
        setCoupFourre(false);
        player.addState(StateEnum.PRIORITAIRE);
        if(player.hasState(StateEnum.ARRET)){
            setCoupFourre(true);
            arret = true;
            player.delState(StateEnum.ARRET);
        }

        if(player.hasState(StateEnum.LIMITATION)){
            setCoupFourre(true);
            limitation = true;
            player.delState(StateEnum.LIMITATION);
        }
    }
    
}
