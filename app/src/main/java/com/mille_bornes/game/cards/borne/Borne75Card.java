package com.mille_bornes.game.cards.borne;

import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;
import com.mille_bornes.game.utils.BorneEnum;

public class Borne75Card extends BorneCard {

    public Borne75Card(){
        super(BorneEnum.BORNE_75);
    }

    /**
     * {@inheritDoc}
     */
    public boolean isPlayable(Player player) {
        return !player.hasState(StateEnum.ARRET) && !player.hasState(StateEnum.CREVAISON) && !player.hasState(StateEnum.PANNE) && !player.hasState(StateEnum.ACCIDENT) && !player.hasState(StateEnum.LIMITATION) && (player.getGameScore() + getBorneValue() <= 700);
    }

    /**
     * {@inheritDoc}
     */
    public int compareTo(BorneCard card) {
        return this.getBorneValue() - card.getBorneValue();
    }
}
