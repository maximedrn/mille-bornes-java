package game.cards;
import game.players.Player;

public abstract class Card {
    private String name;

    public Card(String name) {
        /* Constructor */
        this.name = name;
    }

    public String getName() { 
        return name;
     }
    public abstract boolean isPlayable(Player player);
    public abstract void action(Player player);
    public abstract String toString();
}

