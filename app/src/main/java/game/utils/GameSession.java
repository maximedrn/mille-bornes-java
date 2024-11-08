package game.utils;
import game.cards.*;
import game.players.*;
import java.util.List;

public class GameSession {
    private boolean isFinished;
    private Player winner;
    private List<Player> participants;
    private int currentPlayerTurn;

    public GameSession(List<Player> players, CardDatabaseDAO database) { /* Constructor */ }

    public void initializeDeck(CardDatabaseDAO database) { /* Initialize the deck */ }
    public void addPlayer(Player player) { /* Add a player */ }
    public void start() { /* Start the game */ }
    public void end() { /* End the game */ }
    public Player nextPlayer() { /* Move to the next player */ }
    public boolean isFinished() { /* Check if the game is finished */ }
}

