package com.mille_bornes.database.data;

import java.util.List;

import com.mille_bornes.constants.Exceptions;
import com.mille_bornes.constants.PlayerType;
import com.mille_bornes.constants.cards.CardArea;
import com.mille_bornes.constants.cards.CardTypeHazard;
import com.mille_bornes.constants.cards.CardTypeSafety;
import com.mille_bornes.database.DatabaseUtil;
import com.mille_bornes.database.data.helper.DatabaseList;
import com.mille_bornes.database.data.helper.OrderedDatabaseList;
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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
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
    private List<HandCard> hand = new DatabaseList<HandCard>();

    @OneToMany(
        mappedBy = "player",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<StackCard> stack = new OrderedDatabaseList<StackCard>();

    public Player() {}

    /**
     * Constructor for players in a game.
     * @param name The name of the player.
     * @param type The type of the player.
     */
    public Player(final String name, final PlayerType type) {
        assert name != null : Exceptions.PLAYER_NAME_CANNOT_BE_NULL;
        assert name != "" : Exceptions.PLAYER_NAME_CANNOT_BE_EMPTY;
        assert type != null : Exceptions.PLAYER_TYPE_CANNOT_BE_NULL;
        this.name = name;
        this.type = type.toString();
    }

    public Player(final String name, final Integer index) {
        this(name, PlayerType.HUMAN);
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(final Game game) {
        assert game != null : Exceptions.GAME_CANNOT_BE_NULL;
        this.game = game;
        this.setIndex(game.getPlayers().size());
    }

    public String getName() {
        return this.name;
    }

    public PlayerType getType() {
        return PlayerType.valueOf(this.type.toUpperCase());
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

    public DatabaseList<HandCard> getHand() {
        return new DatabaseList<HandCard>(this.hand);
    }

    public OrderedDatabaseList<StackCard> getStack() {
        return new OrderedDatabaseList<StackCard>(this.stack);
    }

    /**
     * Retrieve cards currently in the stack according to the card area.
     * It helps to know which card is at the top of each part of the stack.
     * @see https://www.hasbro.com/common/instruct/MilleBorne(French).pdf#page=5
     * @param cardArea The area of the card to retrieve.
     * @return The cards in the stack according to the card area.
     */
    public OrderedDatabaseList<StackCard> getStackByArea(
        final CardArea cardArea
    ) {
        return new OrderedDatabaseList<StackCard>(
            this.stack
                .stream()
                .filter((final StackCard card) -> (
                    card.getType()
                        .getCardArea()
                        .equals(cardArea)
                ))
                .toList()
        );
    }

    public HandCard addCardToHand(final Card card) {
        assert card != null : Exceptions.CARD_CANNOT_BE_NULL;
        card.setPlayer(this);
        final HandCard handCard = new HandCard(card);
        this.hand.add(handCard);
        return handCard;
    }

    public List<HandCard> addCardsToHand(final List<Card> cards) {
        return cards.stream()
            .map(this::addCardToHand)
            .toList();
    }

    public StackCard addCardToStack(final Card card) {
        assert card != null : Exceptions.CARD_CANNOT_BE_NULL;
        card.setPlayer(this);
        card.setIndex(this.stack.size());
        final StackCard stackCard = new StackCard(card);
        this.stack.add(stackCard);
        return stackCard;
    }

    public List<StackCard> addCardsToStack(final List<Card> cards) {
        return cards.stream()
            .map(this::addCardToStack)
            .toList();
    }

    /**
     * Moves a card from the player's hand to the stack. The card has been 
     * played. It sets the index of the card to the size of the stack.
     * @param card The card to move to the stack.
     */
    public void moveCardToStack(final Card card) {
        assert card != null : Exceptions.CARD_CANNOT_BE_NULL;
        if (this.hand.remove(card)) this.stack.add(new StackCard(card));
        else throw new IllegalArgumentException(Exceptions.CARD_NOT_IN_HAND);
    }

    public Boolean hasSafetyCard(final CardTypeSafety safetyCard) {
        return this.getStackByArea(safetyCard.getCardArea())
            .stream()
            .anyMatch((final StackCard card) -> (
                card.getType()
                    .getInstance()
                    .equals(safetyCard)
            ));
    } 

    public Boolean hasHazardCard(final CardTypeHazard hazardCard) {
        final CardArea area = hazardCard.getCardArea();
        final OrderedDatabaseList<StackCard> stack = this.getStackByArea(area);
        return stack.isEmpty() ? false : stack
            .getLast() // Get the last card in the battle area.
            .getType() // Get the type of the card (global enum).
            .getInstance() // Get the instance of the card (specific enum).
            .equals(hazardCard); // Check if the card is the hazard card.
    }

    public Boolean isInBattleMode(final CardArea area) {
        final OrderedDatabaseList<StackCard> stack = this.getStackByArea(area);
        return stack.isEmpty() ? false : stack
            .getLast() // Get the last card in the battle area.
            .getType() // Get the type of the card (global enum).
            .getInstance() // Get the instance of the card (specific enum).
            instanceof CardTypeHazard;
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
