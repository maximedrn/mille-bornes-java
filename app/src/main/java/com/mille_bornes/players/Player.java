package com.mille_bornes.players;

public abstract class Player {
    private String name;
    private int globalScore;
    private int gameScore;

    public Player(String name){
        this.name = name;
        globalScore = 0;
        gameScore = 0;
    }

    public String getName(){
        return name;
    }

    public int getGlobalScore(){
        return globalScore;
    }

    public void setGlobalScore(int score){
        globalScore = score;
    }

    public int getGameScore(){
        return globalScore;
    }

    public void setGameScore(int score){
        globalScore = score;
    }

    public Card getCard(int);
}
