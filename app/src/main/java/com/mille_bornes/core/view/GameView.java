package com.mille_bornes.core.view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class GameView {

    private Button newGameButton, quitButton, drawCardButton, discardCardButton;

    public GameView(Stage stage) {
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
}
