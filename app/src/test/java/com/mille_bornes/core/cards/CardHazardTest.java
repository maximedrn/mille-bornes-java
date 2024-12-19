package com.mille_bornes.core.cards;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mille_bornes.constants.PlayerType;
import com.mille_bornes.core.cards.hazard.CardAccident;
import com.mille_bornes.core.cards.hazard.CardFlatTire;
import com.mille_bornes.core.cards.hazard.CardHazard;
import com.mille_bornes.core.cards.hazard.CardOutOfGas;
import com.mille_bornes.core.cards.hazard.CardRedLight;
import com.mille_bornes.core.cards.hazard.CardSpeedLimit;
import com.mille_bornes.core.cards.safety.CardSafety;
import com.mille_bornes.database.DatabaseUtil;
import com.mille_bornes.database.data.Player;


public class CardHazardTest {

    private static DatabaseUtil database;

    @BeforeAll
    public static void beforeAll() {
        CardHazardTest.database = new DatabaseUtil();
    }

    private void testCardHazard(final CardHazard hazardCard) {
        CardHazardTest.database.newRound();
        final Player player = new Player("Player 1", PlayerType.HUMAN);
        CardHazardTest.database.addPlayer(player);
        CardSafety safetyCard = hazardCard.getCounterCardInstance();
        assertEquals(true, hazardCard.canBeAppliedTo(player));
        CardHazardTest.database.addCardToPlayerStack(player, safetyCard);
        assertEquals(false, hazardCard.canBeAppliedTo(player));
        CardHazardTest.database.applyCardToPlayer(player, hazardCard);
    }

    @Test
    public void testCardAccident() {
        final CardAccident cardAccident = new CardAccident();
        testCardHazard(cardAccident);
    }

    @Test
    public void testCardFlatTire() {
        final CardFlatTire cardFlatTire = new CardFlatTire();
        testCardHazard(cardFlatTire);
    }

    @Test
    public void testCardOutOfGas() {
        final CardOutOfGas cardOutOfGas = new CardOutOfGas();
        testCardHazard(cardOutOfGas);
    }

    @Test
    public void testCardRedLight() {
        final CardRedLight cardRedLight = new CardRedLight();
        testCardHazard(cardRedLight);
    }

    @Test
    public void testCardSpeedLimit() {
        final CardSpeedLimit cardSpeedLimit = new CardSpeedLimit();
        testCardHazard(cardSpeedLimit);
    }
}
