package com.nicksimpsonx;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the bowling game score calculator
 */
class BowlingGameTests {

	BowlingGame game;

	private static final int GUTTER_GAME = 0;
	private static final int ALL_ONES = 20;
	private static final int SPARE_FIRST_ONE_NEXT_THEN_ZEROES = 12;
	private static final int STRIKE_FIRST_THEN_ONE_AND_ONE_THEN_ZEROES = 14;
	private static final int PERFECT_SCORE = 300;

	@BeforeEach
	void setUpTests() {

		game = new BowlingGame();
	}

	@Test
	void canMakeGame() {

		assertNotNull(game);
	}

	@Test
	void canScoreZeroGame() {

		game.takeScoreCard(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		assertEquals(GUTTER_GAME, game.score());
	}

	@Test
	void canScoreAllOnesRolled() {

		game.takeScoreCard(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
		assertEquals(ALL_ONES, game.score());
	}

	@Test
	void spareFirstFrameOneNextRollScoresTwelve() {

		game.takeScoreCard(5, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		assertEquals(SPARE_FIRST_ONE_NEXT_THEN_ZEROES, game.score());
	}

	@Test
	void strikeFirstFrameOneNextTwoRollsScoresFourteen() {

		game.takeScoreCard(10, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		assertEquals(STRIKE_FIRST_THEN_ONE_AND_ONE_THEN_ZEROES, game.score());
	}

	@Test
	void perfectGameScoresThreeHundred() {

		game.takeScoreCard(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
		assertEquals(PERFECT_SCORE, game.score());
	}

}
