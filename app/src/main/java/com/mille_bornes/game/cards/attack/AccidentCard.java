package com.mille_bornes.game.cards.attack;

import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;

public class AccidentCard extends AttackCard {

    public AccidentCard(){
        super("accident");
    }

    public boolean isPlayable(Player opponent){
        return !opponent.hasState(StateEnum.ARRET) && !opponent.hasState(StateEnum.CREVAISON) && !opponent.hasState(StateEnum.PANNE) && !opponent.hasState(StateEnum.ACCIDENT) && !opponent.hasState(StateEnum.AS_DU_VOLANT);
    }

    public void action(Player opponent) {
        opponent.addState(StateEnum.ACCIDENT);
    }
    
}
