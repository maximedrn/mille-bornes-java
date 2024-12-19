package com.mille_bornes.database.data;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

import com.mille_bornes.database.DatabaseUtil;
import com.mille_bornes.database.data.helper.DatabaseList;
import com.mille_bornes.database.data.helper.OrderedDatabaseTable;


/**
 * Represents a round in the game. Stored in the database.
 * Do not use this class directly, use the {@link DatabaseUtil} class instead.
 */
@Entity
@Table(name = "rounds")
public class Round extends OrderedDatabaseTable<Round> {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @OneToMany(
        mappedBy = "round",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<DeckCard> cards = new DatabaseList<DeckCard>();

    public Round() {
        super();
    }

    public Round(final Integer index) {
        super(index);
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(final Game game) {
        this.game = game;
    }

    /**
     * Retrieves all the cards in the round, and their state. It can
     * be a card from the deck, a card from the player's hand or stack.
     * @return A list of all the cards, and their state, in the round.
     */
    public List<DeckCard> getCards() {
        return this.cards;
    }

    public void addCard(final Card card) {
        card.setRound(this);
        this.cards.add(new DeckCard(card));
    }

    public void addCards(final List<Card> cards) {
        cards.forEach(this::addCard);
    }

    public String toString() {
        final String id = super.toString();
        return String.format(" ", id, this.cards.size());
    }
}
