package com.mille_bornes.constants.cards;

public enum CardTypeSafety implements ICardProperty {

    DRIVING_ACE("As du volant"),
    EXTRA_TANK("Citerne d'essence"),
    PUNCTURE_PROOF("Increvable"),
    RIGHT_OF_WAY("Véhicule prioritaire");

    private final String name;

    private CardTypeSafety(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getValue() {
        return null;
    }

    @Override
    public CardArea getCardArea() {
        return CardArea.SAFETY_AREA;
    }
}
