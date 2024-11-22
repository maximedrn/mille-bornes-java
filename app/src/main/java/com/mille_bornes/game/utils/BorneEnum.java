package com.mille_bornes.game.utils;

public enum BorneEnum {
    BORNE_25(25),
    BORNE_50(50),
    BORNE_75(75),
    BORNE_100(100),
    BORNE_200(200);

    private int value;

    BorneEnum(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public String toString(){
        return value + "bornes";
    }
}
