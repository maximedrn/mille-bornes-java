package com.mille_bornes.core.controller;

import com.mille_bornes.core.model.GameModel;
import com.mille_bornes.core.view.GameView;


public class GameController {

    private final GameModel model;
    private final GameView view;

    public GameController(final GameModel model, final GameView view) {
        this.model = model;
        this.view = view;
        this.setupHandlers();
    }

    private void setupHandlers() {
        view.getNewGameButton().setOnAction(e -> {
            // TODO: Implement
            model.resetGame();
            this.updateView();
        });

        view.getQuitButton().setOnAction(e -> System.exit(0));

        view.getDrawCardButton().setOnAction(e -> {
            // TODO: Implement
            this.updateView();
        });

        view.getDiscardCardButton().setOnAction(e -> {
            // TODO: Implement
            this.updateView();
        });
    }

    private void updateView() {
        
    }
}
