package com.mille_bornes.constants.cards;

public enum CardTypeDistance implements ICardProperty {

    MILEAGE_25("25 bornes", 25),
    MILEAGE_50("50 bornes", 50),
    MILEAGE_75("75 bornes", 75),
    MILEAGE_100("100 bornes", 100),
    MILEAGE_200("200 bornes", 200);

    private final String name;
    private final Integer value;

    private CardTypeDistance(final String name, final Integer value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public CardArea getCardArea() {
        return CardArea.DISTANCE_AREA;
    }
}
