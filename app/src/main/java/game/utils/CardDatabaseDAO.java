package game.utils;
import game.cards.Card;
import java.util.List;

public class CardDatabaseDAO {
    private List<Card> database;

    public CardDatabaseDAO() { /* Constructor */ }

    public void addCard(Card card) { /* Add a card to the database */ }
    public void removeCard(Card card) { /* Remove a card from the database */ }
    public Card searchCard(String name) { /* Search a card by name */ }
    public void displayCards() { /* Display all cards */ }
    public void clearDatabase() { /* Clear the database */ }
}

