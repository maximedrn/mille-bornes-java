package com.mille_bornes.game.cards.borne;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;
import com.mille_bornes.game.utils.BorneEnum;

public class Borne100Card extends BorneCard {

    public Borne100Card(){
        super(BorneEnum.BORNE_100);
    }

    /**
     * {@inheritDoc}
     */
    public boolean isPlayable(Player player) {
        return !player.hasState(StateEnum.ARRET) && !player.hasState(StateEnum.CREVAISON) && !player.hasState(StateEnum.PANNE) && !player.hasState(StateEnum.ACCIDENT) && !player.hasState(StateEnum.LIMITATION) && (player.getGameScore() + getBorneValue() <= 700);
    }

    public int compareTo(BorneCard card) {
        
    }

    @Override
    public int compareTo(Card card) {
        return this.getBorneValue() - card.getBorneValue();
    }

}
