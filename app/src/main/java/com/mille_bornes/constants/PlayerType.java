package com.mille_bornes.constants;


public enum PlayerType {

    HUMAN("Humain"),
    DUMB_ROBOT("Robot stupide"),
    SMART_ROBOT("Robot intelligent");

    private final String name;

    private PlayerType(final String name) {
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
     * @return the lowercase name of the enum constant.
     */
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
