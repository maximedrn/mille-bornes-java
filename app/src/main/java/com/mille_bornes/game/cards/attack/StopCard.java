package com.mille_bornes.game.cards.attack;

import com.mille_bornes.game.players.Player;
import com.mille_bornes.game.utils.StateEnum;

public class StopCard extends AttackCard {
    
    public StopCard(){
        super("feu rouge");
    }

    public boolean isPlayable(Player opponent){
        return !opponent.hasState(StateEnum.ARRET) && !opponent.hasState(StateEnum.CREVAISON) && !opponent.hasState(StateEnum.PANNE) && !opponent.hasState(StateEnum.ACCIDENT) && !opponent.hasState(StateEnum.PRIORITAIRE);
    }

    public void action(Player opponent) {
        opponent.addState(StateEnum.ARRET);
    }
    
}