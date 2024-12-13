package com.mille_bornes.constants;


public enum CardType {
    // Hazards.
    ACCIDENT("Accident"),
    OUT_OF_GAS("Panne d'essence"),
    FLAT_TIRE("Pneu crevé"),
    SPEED_LIMIT("Limite de vitesse"),
    RED_LIGHT("Stop"),
    // Remedies.
    REPAIRS("Réparations"),
    GASOLINE("Essence"),
    SPARE_TIRE("Roue de secours"),
    END_OF_SPEED_LIMIT("Fin de limite de vitesse"),
    GREEN_LIGHT("Roulez"),
    // Safeties.
    DRIVING_ACE("As du volant"),
    EXTRA_TANK("Citerne d'essence"),
    PUNCTURE_PROOF("Increvable"),
    RIGHT_OF_WAY("Véhicule prioritaire"),
    // Distance.
    MILEAGE_25("25 bornes", 25),
    MILEAGE_50("50 bornes", 50),
    MILEAGE_75("75 bornes", 75),
    MILEAGE_100("100 bornes", 100),
    MILEAGE_200("200 bornes", 200),;

    private final String name;
    private final Integer value;

    private CardType(final String name, final Integer value) {
        this.name = name;
        this.value = value;
    }

    private CardType(final String name) {
        this(name, null);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
