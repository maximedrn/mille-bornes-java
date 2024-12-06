package com.mille_bornes.database.data;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "rounds")
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    /**
     * The index of the round in the game. Allows to sort 
     * the rounds in the game. Starts from 0.
     */
    @Column(name = "round_index", nullable = false)
    private Integer roundIndex;

    @ManyToOne
    @JoinColumn(name = "player", nullable = false)
    private Player player;

    @OneToMany(
        mappedBy = "round",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Card> actions = new ArrayList<Card>();

    public Round(
        final Game game,
        final Integer roundIndex,
        final Player player
    ) {
        this.game = game;
        this.roundIndex = roundIndex;
        this.player = player;
    }

    public String getId() {
        return this.id;
    }

    public Game getGame() {
        return this.game;
    }

    public Integer getRoundIndex() {
        return this.roundIndex;
    }

    public Player getPlayer() {
        return this.player;
    }

    public List<Card> getActions() {
        return this.actions;
    }

    public void addAction(final Card action) {
        this.actions.add(action);
    }

    public void addActions(final List<Card> actions) {
        this.actions.addAll(actions);
    }
}
