package com.mille_bornes.database.data;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.mille_bornes.constants.Exceptions;
import com.mille_bornes.constants.GameStatus;
import com.mille_bornes.database.data.helper.DatabaseList;
import com.mille_bornes.database.data.helper.DatabaseTable;
import com.mille_bornes.database.data.helper.OrderedDatabaseList;


/**
 * Represents a game. Stored in the database.
 * Do not use this class directly, use the {@link DatabaseUtil} class instead.
 */
@Entity
@Table(name = "games")
public class Game extends DatabaseTable<Game> {

    private static final String DATE_FORMAT = "dd/MM/uuuu HH:mm";

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
    private List<Round> rounds = new OrderedDatabaseList<Round>();

    @OneToMany(
        mappedBy = "game",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Player> players = new OrderedDatabaseList<Player>();

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public String getCreatedAtString() {
        return this.createdAt.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }

    public GameStatus getStatus() {
        return GameStatus.valueOf(this.status.toUpperCase());
    }

    public void setStatus(final GameStatus status) {
        assert status != null : Exceptions.GAME_STATUS_CANNOT_BE_NULL;
        this.status = status.toString();
    }

    public DatabaseList<Round> getRounds() {
        return new DatabaseList<Round>(this.rounds);
    }

    public void addRound(final Round round) {
        assert round != null : Exceptions.ROUND_CANNOT_BE_NULL;
        round.setGame(this);
        this.rounds.add(round);
    }

    public DatabaseList<Player> getPlayers() {
        return new DatabaseList<Player>(this.players);
    }

    public void addPlayer(final Player player) {
        assert player != null : Exceptions.PLAYER_CANNOT_BE_NULL;
        player.setGame(this);
        this.players.add(player);
    }

    public void addPlayers(final List<Player> players) {
        players.forEach(this::addPlayer);
    }

    public String toString() {
        final String id = super.toString();
        final Integer playersNumber = this.players.size();
        final GameStatus status = this.getStatus();
        return String.format(" ", id, playersNumber, status);
    }
}
