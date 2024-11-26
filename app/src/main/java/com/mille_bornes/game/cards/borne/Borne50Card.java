package com.mille_bornes.game.cards.borne;

import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;
import com.mille_bornes.game.utils.BorneEnum;

public class Borne50Card extends BorneCard {

    public Borne50Card(){
        super(BorneEnum.BORNE_50);
    }

    public boolean isPlayable(Player player) {
        return !player.hasState(StateEnum.ARRET) && !player.hasState(StateEnum.CREVAISON) && !player.hasState(StateEnum.PANNE) && !player.hasState(StateEnum.ACCIDENT);
    }

}