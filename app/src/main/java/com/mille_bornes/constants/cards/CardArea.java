package com.mille_bornes.constants.cards;


public enum CardArea {

    SPEED_AREA("Pile de vitesse"),
    BATTLE_AREA("Pile de bataille"),
    DISTANCE_AREA("Pile de distance"),
    SAFETY_AREA("Pile de sécurité"),
    NULL("");

    private final String name;

    private CardArea(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
