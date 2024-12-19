package com.mille_bornes.constants;


public enum GameStatus {

    IN_PROGRESS("En cours"),
    FINISHED("Terminé");

    private final String name;

    private GameStatus(final String name) {
        this.name = name;
    }

    /**
     * Get the name of the enum constant.
     * @return the name of the enum constant.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the raw name of the enum constant for the database.
     * @return the name of the enum constant.
     */
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
