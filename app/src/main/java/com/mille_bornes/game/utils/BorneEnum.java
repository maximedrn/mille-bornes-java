package com.mille_bornes.game.utils;

/**
 * Enum representing the different types of bornes in the Mille Bornes game.
 */
public enum BorneEnum {
    /**
     * Represents a 25 borne.
     */
    BORNE_25(25),
    
    /**
     * Represents a 50 borne.
     */
    BORNE_50(50),
    
    /**
     * Represents a 75 borne.
     */
    BORNE_75(75),
    
    /**
     * Represents a 100 borne.
     */
    BORNE_100(100),
    
    /**
     * Represents a 200 borne.
     */
    BORNE_200(200);

    private int value;

    /**
     * Constructor for BorneEnum.
     *
     * @param value the value of the borne
     */
    BorneEnum(int value){
        this.value = value;
    }

    /**
     * Gets the value of the borne.
     *
     * @return the value of the borne
     */
    public int getValue(){
        return value;
    }

    /**
     * Returns a string representation of the borne.
     *
     * @return a string indicating the value of the borne followed by "bornes"
     */
    public String toString(){
        return value + " bornes";
    }
}