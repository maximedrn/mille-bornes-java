package game.cards;
import game.players.Player;

public abstract class AttackCard extends Card {
    public AttackCard(String name) { super(name); }

    public abstract boolean isPlayable(Player opponent);
    public abstract void action(Player opponent);
}

