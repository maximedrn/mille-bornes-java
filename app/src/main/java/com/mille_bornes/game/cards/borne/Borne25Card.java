package com.mille_bornes.game.cards.borne;

import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;
import com.mille_bornes.game.utils.BorneEnum;

public class Borne25Card extends BorneCard {

    public Borne25Card(){
        super(BorneEnum.BORNE_25);
    }

    public boolean isPlayable(Player player) {
        return !player.hasState(StateEnum.ARRET) && !player.hasState(StateEnum.CREVAISON) && !player.hasState(StateEnum.PANNE) && !player.hasState(StateEnum.ACCIDENT);
    }

}
