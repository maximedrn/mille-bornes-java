package game.cards;
import game.players.Player;

public abstract class Card {
    private String name;

    public Card(String name) { /* Constructor */ }

    public String getName() { /* Getter */ }
    public abstract boolean isPlayable(Player player);
    public abstract void action(Player player);
    public abstract String toString();
}

