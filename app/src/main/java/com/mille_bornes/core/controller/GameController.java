package com.mille_bornes.core.controller;

import com.mille_bornes.core.model.GameModel;
import com.mille_bornes.core.view.GameView;
import com.mille_bornes.database.data.Card;
import com.mille_bornes.database.data.Player;

public class GameController {

    private final GameModel model;
    private final GameView view;

    public GameController(final GameModel model, final GameView view) {
        this.model = model;
        this.view = view;
        this.setupHandlers();
    }

    private void setupHandlers() {
        // Bouton pour commencer une nouvelle partie
        view.getNewGameButton().setOnAction(e -> {
            model.resetGame(); // Réinitialise la partie dans le modèle
            this.updateView(); // Met à jour la vue
        });

        // Bouton pour quitter le jeu
        view.getQuitButton().setOnAction(e -> System.exit(0));

        // Bouton pour piocher une carte
        view.getDrawCardButton().setOnAction(e -> {
            Player currentPlayer = model.getCurrentPlayer();
            Card drawnCard = model.drawCard(currentPlayer); // Tire une carte
            if (drawnCard != null) {
                view.showMessage(currentPlayer.getName() + " a pioché : " + drawnCard);
            } else {
                view.showMessage("Le paquet est vide !");
            }
            this.updateView();
        });

        // Bouton pour défausser une carte
        view.getDiscardCardButton().setOnAction(e -> {
            Player currentPlayer = model.getCurrentPlayer();
            if (!currentPlayer.getHand().isEmpty()) {
                Card discardedCard = currentPlayer.discardCard(0); // Exemple : défausse la première carte
                view.showMessage(currentPlayer.getName() + " a défaussé : " + discardedCard);
            } else {
                view.showMessage(currentPlayer.getName() + " n'a aucune carte à défausser !");
            }
            this.updateView();
        });
    }

    // Met à jour la vue en fonction des données actuelles du modèle
    private void updateView() {
        view.updatePlayerHands(model.getPlayers()); // Met à jour l'affichage des mains des joueurs
        view.updateDeckCount(model.getDeck().getRemainingCards()); // Met à jour le nombre de cartes restantes
        view.updateCurrentPlayer(model.getCurrentPlayer()); // Met à jour l'affichage du joueur actuel
    }
}