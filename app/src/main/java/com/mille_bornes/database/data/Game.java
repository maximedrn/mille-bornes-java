package com.mille_bornes.database.data;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


enum GameStatus {
    IN_PROGRESS,
    FINISHED;

    /**
     * @return the lowercase name of the enum constant.
     */
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}


@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Version
    private Integer version;

    @Column(
        name = "created_at",
        nullable = false,
        updatable = false
    )
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private String status = GameStatus.IN_PROGRESS.toString();

    @OneToMany(
        mappedBy = "game",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Player> players = new ArrayList<Player>();

    @OneToMany(
        mappedBy = "game",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Card> cards = new ArrayList<Card>();

    @OneToMany(
        mappedBy = "game",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Round> rounds = new ArrayList<Round>();

    public String getId() {
        return this.id;
    }

    public GameStatus getStatus() {
        return GameStatus.valueOf(this.status.toUpperCase());
    }

    public void setStatus(final GameStatus status) {
        this.status = status.toString();
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void addPlayer(final Player player) {
        this.players.add(player);
    }

    public void addPlayers(final List<Player> players) {
        this.players.addAll(players);
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public void addCard(final Card card) {
        this.cards.add(card);
    }

    public void addCards(final List<Card> cards) {
        this.cards.addAll(cards);
    }

    public List<Round> getRounds() {
        return this.rounds;
    }

    public void addRound(final Round round) {
        this.rounds.add(round);
    }
}
