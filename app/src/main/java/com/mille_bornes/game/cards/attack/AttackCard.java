package com.mille_bornes.game.cards.attack;

import com.mille_bornes.game.cards.Card;
import com.mille_bornes.game.players.Player;

public abstract class AttackCard extends Card {

    public AttackCard(String name) {
        super(name);
    }

    public abstract boolean isPlayable(Player opponent);

    public abstract void action(Player opponent);
}

