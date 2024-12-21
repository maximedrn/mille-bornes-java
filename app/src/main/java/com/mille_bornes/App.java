package com.mille_bornes;

import com.mille_bornes.core.controller.GameController;
import com.mille_bornes.core.model.GameModel;
import com.mille_bornes.core.view.GameView;

import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(final Stage primaryStage) {
        final GameModel model = new GameModel();
        final GameView view = new GameView(primaryStage);
        new GameController(model, view);
    }

    public static void main(final String[] args) {
        launch(args);
    }
}
