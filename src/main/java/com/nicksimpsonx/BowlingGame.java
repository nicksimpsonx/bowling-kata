package com.nicksimpsonx;

/**
 * Implementation of the bowling score coding kata from coding dojo:<br>
 * https://codingdojo.org/kata/Bowling/<br>
 * I used a TDD approach to create this simple algorithm which calculates the
 * score from a sequence of moves representing a ten pin bowling score card
 * 
 * @implNote The time taken was 45 minutes, the objective was to keep the
 *           implementation as simple as possible and allow the design to be led
 *           by the tests. This approach uses a simple array to score the rolls
 *           with the concept of a frame pointer which allowed me to cater for
 *           spares, strikes and the condition at the end of the game where
 *           extra rolls may be needed to calculate the final score.
 * 
 * @author Nick Simpson
 * @since 1.8 
 * December 2020
 */
public class BowlingGame {

	private static final int FRAMES_IN_A_GAME = 10;
	private static final int ADVANCE_TWO_BALL_FRAME = 2;
	private static final int ADVANCE_STRIKE_FRAME = 1;

	private int[] allRolls = new int[21];

	/**
	 * Accepts a sequence of up to 21 integers which represent a ten pin bowling score
	 * card
	 * @param rolls - a comma separated list of up to 21 integers
	 */
	public void takeScoreCard(int... rolls) {

		allRolls = rolls;
	}

	/**
	 * Calculate the score for this frame
	 * @return Integer - the score for this game
	 */
	public Integer score() {

		int score = 0;
		int position = 0;

		for (int i = 0; i < FRAMES_IN_A_GAME; i++) {

			if (isStrike(allRolls[position])) {

				score += (10 + allRolls[position + 1] + allRolls[position + 2]);
				position += ADVANCE_STRIKE_FRAME;
				
			} else if (isSpare(allRolls[position], allRolls[position + 1])) {

				score += (10 + allRolls[position + 2]);
				position += ADVANCE_TWO_BALL_FRAME;
				
			} else {

				score += (allRolls[position] + allRolls[position + 1]);
				position += ADVANCE_TWO_BALL_FRAME;
				
			}
		}
		
		return score;
	}

	// Strike is when the first roll in a frame scores ten
	private boolean isStrike(int rollOne) {

		return rollOne == 10;
	}

	// Spare is when the two rolls in a frame add up to ten
	private boolean isSpare(int rollOne, int rollTwo) {

		return rollOne + rollTwo == 10;
	}

}
