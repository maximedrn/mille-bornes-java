package com.mille_bornes.constants.cards;


public enum CardTypeHazard implements ICardProperty {

    ACCIDENT("Accident", CardArea.BATTLE_AREA),
    OUT_OF_GAS("Panne d'essence", CardArea.BATTLE_AREA),
    FLAT_TIRE("Pneu crevé", CardArea.BATTLE_AREA),
    SPEED_LIMIT("Limite de vitesse", CardArea.SPEED_AREA),
    RED_LIGHT("Stop", CardArea.BATTLE_AREA),
    NULL("", CardArea.NULL);

    private final String name;
    private final CardArea cardArea;

    private CardTypeHazard(final String name, final CardArea cardArea) {
        this.name = name;
        this.cardArea = cardArea;
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
        return this.cardArea;
    }
}
