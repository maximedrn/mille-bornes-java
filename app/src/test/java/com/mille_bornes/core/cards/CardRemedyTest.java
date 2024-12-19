package com.mille_bornes.core.cards;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mille_bornes.constants.PlayerType;
import com.mille_bornes.core.cards.hazard.CardHazard;
import com.mille_bornes.core.cards.remedy.CardEndOfSpeedLimit;
import com.mille_bornes.core.cards.remedy.CardGasoline;
import com.mille_bornes.core.cards.remedy.CardGreenLight;
import com.mille_bornes.core.cards.remedy.CardRemedy;
import com.mille_bornes.core.cards.remedy.CardRepairs;
import com.mille_bornes.core.cards.remedy.CardSpareTire;
import com.mille_bornes.database.DatabaseUtil;
import com.mille_bornes.database.data.Player;


public class CardRemedyTest {

    private static DatabaseUtil database;

    @BeforeAll
    public static void beforeAll() {
        CardRemedyTest.database = new DatabaseUtil();
    }

    private void testCardRemedy(final CardRemedy remedyCard) {
        CardRemedyTest.database.newRound();
        final Player player = new Player("Player 1", PlayerType.HUMAN);
        CardRemedyTest.database.addPlayer(player);
        CardHazard hazardCard = remedyCard.getHazardCardInstance();
        assertEquals(false, remedyCard.canBeAppliedTo(player));
        CardRemedyTest.database.addCardToPlayerStack(player, hazardCard);
        assertEquals(true, remedyCard.canBeAppliedTo(player));
        CardRemedyTest.database.applyCardToPlayer(player, remedyCard);
    }

    @Test
    public void testCardEndOfSpeedLimit() {
        final CardEndOfSpeedLimit cardEndOfSpeedLimit = new CardEndOfSpeedLimit();
        testCardRemedy(cardEndOfSpeedLimit);
    }

    @Test
    public void testCardGasoline() {
        final CardGasoline cardGasoline = new CardGasoline();
        testCardRemedy(cardGasoline);
    }

    @Test
    public void testCardGreenLight() {
        final CardGreenLight cardGreenLight = new CardGreenLight();
        testCardRemedy(cardGreenLight);
    }

    @Test
    public void testCardRepairs() {
        final CardRepairs cardRepairs = new CardRepairs();
        testCardRemedy(cardRepairs);
    }

    @Test
    public void testCardSpareTire() {
        final CardSpareTire cardSpareTire = new CardSpareTire();
        testCardRemedy(cardSpareTire);
    }
}
