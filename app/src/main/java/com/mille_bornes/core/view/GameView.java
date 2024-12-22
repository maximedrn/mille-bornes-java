package com.mille_bornes.core.view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GameView {

    private final Button newGameButton;
    private final Button quitButton;
    private final Button drawCardButton;
    private final Button discardCardButton;

    private final VBox rootLayout;
    private final HBox buttonLayout;
    private final Label deckCountLabel;
    private final Label currentPlayerLabel;
    private final TextArea messageArea;

    public GameView(Stage stage) {
        // Initialisation des boutons
        newGameButton = new Button("Nouvelle Partie");
        quitButton = new Button("Quitter");
        drawCardButton = new Button("Piocher une carte");
        discardCardButton = new Button("Défausser une carte");

        // Zone d'affichage des informations
        deckCountLabel = new Label("Cartes restantes dans le paquet : 0");
        currentPlayerLabel = new Label("Joueur actuel : Aucun");
        messageArea = new TextArea();
        messageArea.setEditable(false);
        messageArea.setPrefHeight(100);

        // Mise en page des boutons
        buttonLayout = new HBox(10);
        buttonLayout.getChildren().addAll(newGameButton, drawCardButton, discardCardButton, quitButton);

        // Disposition principale
        rootLayout = new VBox(10);
        rootLayout.getChildren().addAll(currentPlayerLabel, deckCountLabel, buttonLayout, messageArea);

        // Configuration de la scène
        Scene scene = new Scene(rootLayout, 600, 400);
        stage.setTitle("Mille Bornes");
        stage.setScene(scene);
        stage.show();
    }

    public Button getNewGameButton() {
        return newGameButton;
    }

    public Button getQuitButton() {
        return quitButton;
    }

    public Button getDrawCardButton() {
        return drawCardButton;
    }

    public Button getDiscardCardButton() {
        return discardCardButton;
    }

    public void updatePlayerHands(String handsInfo) {
        messageArea.appendText("Mains des joueurs :\n" + handsInfo + "\n");
    }

    public void updateDeckCount(int count) {
        deckCountLabel.setText("Cartes restantes dans le paquet : " + count);
    }

    public void updateCurrentPlayer(String playerName) {
        currentPlayerLabel.setText("Joueur actuel : " + playerName);
    }

    public void showMessage(String message) {
        messageArea.appendText(message + "\n");
    }
}
