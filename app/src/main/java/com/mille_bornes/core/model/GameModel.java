package com.mille_bornes.core.model;

import com.mille_bornes.database.DatabaseUtil;
import com.mille_bornes.database.data.Card;
import com.mille_bornes.database.data.Player;
import com.mille_bornes.database.data.DeckCard;

import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private final DatabaseUtil databaseUtil;
    private final DeckCard deck;
    private final List<Player> players;
    private int currentPlayerIndex;
    private String message;

    public GameModel() {
        this.databaseUtil = new DatabaseUtil();
        this.deck = new DeckCard(); // Initialisation du paquet
        this.players = new ArrayList<>(); // Initialisation des joueurs
        this.currentPlayerIndex = 0;
    }

    // Réinitialise la partie
    public void resetGame() {
        this.databaseUtil.endGame();
        this.deck.shuffle(); // Mélange le paquet
        this.players.clear(); // Supprime les joueurs
        this.currentPlayerIndex = 0; // Réinitialise l'indice du joueur
        this.message = "Le jeu a été réinitialisé.";
    }

    // Ajoute un joueur
    public void addPlayer(String name) {
        this.players.add(new Player(name));
    }

    // Renvoie le joueur actuel
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    // Passe au joueur suivant
    public void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    // Pioche une carte pour le joueur actuel
    public Card drawCard() {
        Player currentPlayer = getCurrentPlayer();
        Card drawnCard = deck.drawCard();
        if (drawnCard != null) {
            currentPlayer.addCardToHand(drawnCard);
            this.message = currentPlayer.getName() + " a pioché : " + drawnCard;
        } else {
            this.message = "Le paquet est vide.";
        }
        return drawnCard;
    }

    // Getter et Setter pour le message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Méthode pour récupérer les joueurs
    public List<Player> getPlayers() {
        return players;
    }

    // Récupère le nombre de cartes restantes dans le paquet
    public int getDeckCount() {
        return deck.getRemainingCards();
    }
}
