package com.mille_bornes.constants.cards;


public enum CardType implements ICardProperty {

    ACCIDENT(CardTypeHazard.ACCIDENT),
    OUT_OF_GAS(CardTypeHazard.OUT_OF_GAS),
    FLAT_TIRE(CardTypeHazard.FLAT_TIRE),
    SPEED_LIMIT(CardTypeHazard.SPEED_LIMIT),
    RED_LIGHT(CardTypeHazard.RED_LIGHT),
    REPAIRS(CardTypeRemedy.REPAIRS),
    GASOLINE(CardTypeRemedy.GASOLINE),
    SPARE_TIRE(CardTypeRemedy.SPARE_TIRE),
    END_OF_SPEED_LIMIT(CardTypeRemedy.END_OF_SPEED_LIMIT),
    GREEN_LIGHT(CardTypeRemedy.GREEN_LIGHT),
    DRIVING_ACE(CardTypeSafety.DRIVING_ACE),
    EXTRA_TANK(CardTypeSafety.EXTRA_TANK),
    PUNCTURE_PROOF(CardTypeSafety.PUNCTURE_PROOF),
    RIGHT_OF_WAY(CardTypeSafety.RIGHT_OF_WAY),
    MILEAGE_25(CardTypeDistance.MILEAGE_25),
    MILEAGE_50(CardTypeDistance.MILEAGE_50),
    MILEAGE_75(CardTypeDistance.MILEAGE_75),
    MILEAGE_100(CardTypeDistance.MILEAGE_100),
    MILEAGE_200(CardTypeDistance.MILEAGE_200),
    NULL(CardTypeHazard.NULL);

    private final ICardProperty property;

    private CardType(final ICardProperty property) {
        this.property = property;
    }

    @Override
    public String getName() {
        return this.property.getName();
    }

    @Override
    public Integer getValue() {
        return this.property.getValue();
    }

    @Override
    public CardArea getCardArea() {
        return this.property.getCardArea();
    }

    public ICardProperty getInstance() {
        return this.property;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
