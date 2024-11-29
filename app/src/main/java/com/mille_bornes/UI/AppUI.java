package com.mille_bornes.UI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Conteneur principal
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // Top : Section Joueurs (avancement des voitures)
        VBox playerSection = createPlayerSection();
        root.setTop(playerSection);

        // Center : Zone de message
        Label messageZone = new Label("Zone de message : Informations sur le jeu");
        messageZone.setFont(Font.font("Arial", 16));
        messageZone.setPadding(new Insets(10));
        messageZone.setStyle("-fx-background-color: beige; -fx-border-color: black; -fx-border-width: 2;");
        root.setCenter(messageZone);

        // Bottom : Cartes en main
        HBox cardDisplay = createCardDisplay();
        root.setBottom(cardDisplay);

        // Left : Sabot (Pioche et Fosse)
        VBox drawDiscardZone = createDrawDiscardZone();
        root.setLeft(drawDiscardZone);

        // Right : Boutons d'action
        VBox controlButtons = createControlButtons(primaryStage);
        root.setRight(controlButtons);

        // Configurer la scène
        Scene scene = new Scene(root, 900, 600);
        primaryStage.setTitle("Mille Bornes - Jeu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createPlayerSection() {
        VBox playerSection = new VBox(15);
        playerSection.setPadding(new Insets(10));
        playerSection.setAlignment(Pos.CENTER);

        // Exemple pour trois joueurs (à personnaliser)
        HBox joueur = createPlayerRow("Joueur", Color.GREEN, 0.5);
        HBox cpu1 = createPlayerRow("CPU 1", Color.BLUE, 0.3);
        HBox cpu2 = createPlayerRow("CPU 2", Color.RED, 0.7);

        playerSection.getChildren().addAll(joueur, cpu1, cpu2);
        return playerSection;
    }

    private HBox createPlayerRow(String playerName, Color barColor, double progress) {
        HBox playerRow = new HBox(10);
        playerRow.setAlignment(Pos.CENTER_LEFT);

        // Nom du joueur
        Label nameLabel = new Label(playerName);
        nameLabel.setFont(Font.font("Arial", 14));
        nameLabel.setPrefWidth(100);

        // Barre de progression
        ProgressBar progressBar = new ProgressBar(progress);
        progressBar.setPrefWidth(300);
        progressBar.setStyle("-fx-accent: " + toHexString(barColor) + ";");

        // Affichage des points actuels
        Label pointsLabel = new Label((int) (progress * 1000) + " km");
        pointsLabel.setFont(Font.font("Arial", 14));

        playerRow.getChildren().addAll(nameLabel, progressBar, pointsLabel);
        return playerRow;
    }

    private HBox createCardDisplay() {
        HBox cardDisplay = new HBox(10);
        cardDisplay.setPadding(new Insets(10));
        cardDisplay.setAlignment(Pos.CENTER);
        cardDisplay.setStyle("-fx-border-color: black; -fx-border-width: 2;");

        // Ajouter 6 cartes (placeholder avec images officielles à ajouter)
        for (int i = 0; i < 6; i++) {
            ImageView card = new ImageView(new Image("file:assets/cards/back.png")); // Modifier avec vos chemins d'image
            card.setFitWidth(100);
            card.setFitHeight(150);
            cardDisplay.getChildren().add(card);
        }
        return cardDisplay;
    }

    private VBox createDrawDiscardZone() {
        VBox drawDiscardZone = new VBox(20);
        drawDiscardZone.setPadding(new Insets(10));
        drawDiscardZone.setAlignment(Pos.CENTER);

        // Pioche
        ImageView drawPile = new ImageView(new Image("file:assets/cards/draw_pile.png"));
        drawPile.setFitWidth(100);
        drawPile.setFitHeight(150);

        // Fosse
        ImageView discardPile = new ImageView(new Image("file:assets/cards/discard_pile.png"));
        discardPile.setFitWidth(100);
        discardPile.setFitHeight(150);

        drawDiscardZone.getChildren().addAll(drawPile, discardPile);
        return drawDiscardZone;
    }

    private VBox createControlButtons(Stage stage) {
        VBox controlButtons = new VBox(15);
        controlButtons.setPadding(new Insets(10));
        controlButtons.setAlignment(Pos.CENTER);

        Button newGameButton = new Button("Nouvelle Partie");
        newGameButton.setOnAction(e -> confirmNewGame());

        Button quitButton = new Button("Quitter");
        quitButton.setOnAction(e -> confirmExit(stage));

        controlButtons.getChildren().addAll(newGameButton, quitButton);
        return controlButtons;
    }

    private void confirmNewGame() {
        Alert alert = new Alert(AlertType.CONFIRMATION, "Voulez-vous vraiment démarrer une nouvelle partie ?");
        alert.showAndWait();
    }

    private void confirmExit(Stage stage) {
        Alert alert = new Alert(AlertType.CONFIRMATION, "Voulez-vous vraiment quitter ?");
        alert.showAndWait().ifPresent(response -> {
            if (response.getText().equals("OK")) {
                stage.close();
            }
        });
    }

    private String toHexString(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    public static void main(String[] args) {
        launch(args);
    }
}

