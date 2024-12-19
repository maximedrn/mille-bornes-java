package com.mille_bornes.constants.cards;


public enum CardTypeRemedy implements ICardProperty {
    REPAIRS("Réparations", CardArea.BATTLE_AREA),
    GASOLINE("Essence", CardArea.BATTLE_AREA),
    SPARE_TIRE("Roue de secours", CardArea.BATTLE_AREA),
    END_OF_SPEED_LIMIT("Fin de limite de vitesse", CardArea.SPEED_AREA),
    GREEN_LIGHT("Roulez", CardArea.BATTLE_AREA);

    private final String name;
    private final CardArea cardArea;

    private CardTypeRemedy(final String name, final CardArea cardArea) {
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
