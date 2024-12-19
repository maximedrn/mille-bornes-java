package com.mille_bornes.core.cards;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mille_bornes.constants.PlayerType;
import com.mille_bornes.constants.cards.CardTypeHazard;
import com.mille_bornes.core.cards.distance.CardDistance;
import com.mille_bornes.core.cards.distance.CardDistance100;
import com.mille_bornes.core.cards.distance.CardDistance200;
import com.mille_bornes.core.cards.distance.CardDistance25;
import com.mille_bornes.core.cards.distance.CardDistance50;
import com.mille_bornes.core.cards.distance.CardDistance75;
import com.mille_bornes.core.cards.hazard.CardSpeedLimit;
import com.mille_bornes.database.DatabaseUtil;
import com.mille_bornes.database.data.Card;
import com.mille_bornes.database.data.Player;


public class CardDistanceTest {

    private static DatabaseUtil database;

    @BeforeAll
    public static void beforeAll() {
        CardDistanceTest.database = new DatabaseUtil();
    }

    private void testCardDistance(final CardDistance distanceCard) {
        CardDistanceTest.database.newRound();
        final Player player = new Player("Player 1", PlayerType.HUMAN);
        CardDistanceTest.database.addPlayer(player);
        final Boolean canBeApplied = distanceCard.getValue() <= 50;
        CardTypeHazard hazardCard = CardTypeHazard.SPEED_LIMIT;
        if (canBeApplied) hazardCard = CardTypeHazard.NULL;
        assertEquals(hazardCard, distanceCard.getHazardCard());
        assertEquals(true, distanceCard.canBeAppliedTo(player));
        final Card speedLimitCard = new CardSpeedLimit();
        CardDistanceTest.database.addCardToPlayerStack(player, speedLimitCard);
        assertEquals(canBeApplied, distanceCard.canBeAppliedTo(player));
        CardDistanceTest.database.applyCardToPlayer(player, distanceCard);
        assertEquals(distanceCard.getValue(), player.getScore());
    }

    @Test
    public void testCardDistance25() {
        final CardDistance25 distanceCard = new CardDistance25();
        testCardDistance(distanceCard);
    }

    @Test
    public void testCardDistance50() {
        final CardDistance50 distanceCard = new CardDistance50();
        testCardDistance(distanceCard);
    }

    @Test
    public void testCardDistance75() {
        final CardDistance75 distanceCard = new CardDistance75();
        testCardDistance(distanceCard);
    }

    @Test
    public void testCardDistance100() {
        final CardDistance100 distanceCard = new CardDistance100();
        testCardDistance(distanceCard);
    }

    @Test
    public void testCardDistance200() {
        final CardDistance200 distanceCard = new CardDistance200();
        testCardDistance(distanceCard);
    }
}
