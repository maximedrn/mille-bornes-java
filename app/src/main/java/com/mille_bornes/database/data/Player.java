package com.mille_bornes.database.data;

import java.util.List;

import com.mille_bornes.constants.Exceptions;
import com.mille_bornes.constants.PlayerType;
import com.mille_bornes.database.data.helper.DatabaseArray;
import com.mille_bornes.database.data.helper.OrderedDatabaseArray;
import com.mille_bornes.database.data.helper.OrderedDatabaseTable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * Represents a player in the game. Stored in the database.
 * Do not use this class directly, use the {@link DatabaseUtil} class instead.
 */
@Entity
@Table(name = "players")
public class Player extends OrderedDatabaseTable<Player> {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @Column(nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type = PlayerType.HUMAN.toString();

    @Column(nullable = true)
    private int score = 0;

    @OneToMany(
        mappedBy = "player",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Card> hand = new DatabaseArray<Card>();

    @OneToMany(
        mappedBy = "player",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Card> stack = new OrderedDatabaseArray<Card>();

    public Player() {}

    /**
     * Constructor for players in a game.
     * @param name The name of the player.
     * @param index The index of the player in the game.
     * @param type The type of the player.
     */
    public Player(final String name, final Integer index, final PlayerType type) {
        super(index);
        assert name != null : Exceptions.PLAYER_NAME_CANNOT_BE_NULL;
        assert name != "" : Exceptions.PLAYER_NAME_CANNOT_BE_EMPTY;
        assert type != null : Exceptions.PLAYER_TYPE_CANNOT_BE_NULL;
        this.name = name;
        this.type = type.toString();
    }

    public Player(final String name, final Integer index) {
        this(name, index, PlayerType.HUMAN);
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(final Game game) {
        assert game != null : Exceptions.GAME_CANNOT_BE_NULL;
        this.game = game;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(final Integer score) {
        assert score >= 0 : Exceptions.SCORE_MUST_BE_POSITIVE;
        this.score = score;
    }

    public void addScore(final Integer score) {
        this.setScore(this.getScore() + score);
    }

    public DatabaseArray<Card> getHand() {
        return new DatabaseArray<Card>(this.hand);
    }

    public OrderedDatabaseArray<Card> getStack() {
        return new OrderedDatabaseArray<Card>(this.stack);
    }

    public void addCard(final Card card) {
        assert card != null : Exceptions.CARD_CANNOT_BE_NULL;
        this.hand.add(card);
        card.setPlayer(this);
    }

    public void addCards(final List<Card> cards) {
        cards.forEach(this::addCard);
    }

    /**
     * Moves a card from the player's hand to the stack. The card has been 
     * played. It sets the index of the card to the size of the stack.
     * @param card The card to move to the stack.
     */
    public void moveCardToStack(final Card card) {
        assert card != null : Exceptions.CARD_CANNOT_BE_NULL;
        if (this.hand.remove(card)) this.stack.add(card);
        else throw new IllegalArgumentException(Exceptions.CARD_NOT_IN_HAND);
    }

    public Boolean equals(final Player player) {
        return this.getId().equals(player.getId());
    }

    public String toString() {
        final String id = super.toString();
        final String score = "(" + this.getScore() + " bornes)";
        return String.join(" ", id, this.getName(), score);
    }
}
