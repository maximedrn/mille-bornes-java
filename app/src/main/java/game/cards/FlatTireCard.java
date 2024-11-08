package game.cards;
import game.players.Player;

public class FlatTireCard extends AttackCard {
    public FlatTireCard() { super("Flat Tire"); }
    @Override public boolean isPlayable(Player opponent) { /* logic */ }
    @Override public void action(Player opponent) { /* logic */ }
}

