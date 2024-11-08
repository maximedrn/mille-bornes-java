import java.util.List;

public abstract class Player {
    private String name;
    private int totalScore;
    private int score;
    private List<Card> hand;
    private List<State> states;

    public Player(String name) { /* Constructor */ }

    public String getName() { /* Getter */ }
    public int getTotalScore() { /* Getter */ }
    public void setTotalScore(int totalScore) { /* Setter */ }
    public int getScore() { /* Getter */ }
    public void setScore(int score) { /* Setter */ }

    public Card getCard(int index) { /* Method to get a card */ }
    public void addCard(Card card) { /* Add a card to the hand */ }
    public void removeCard(int index) { /* Remove a card from the hand */ }
    public void clearHand() { /* Clear all cards from the hand */ }

    public State getState(int index) { /* Get a state */ }
    public void addState(State state) { /* Add a state */ }
    public void removeState(int index) { /* Remove a state */ }

    public abstract Card playCard();
    public abstract Card discardCard();
    public abstract String toString();
}
