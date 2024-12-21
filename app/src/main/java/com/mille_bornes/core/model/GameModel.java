package com.mille_bornes.core.model;

import com.mille_bornes.database.DatabaseUtil;


public class GameModel {

    private final DatabaseUtil databaseUtil;
    private String message;

    public GameModel() {
        this.databaseUtil = new DatabaseUtil();
    }

    public void resetGame() {
        this.databaseUtil.endGame();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
