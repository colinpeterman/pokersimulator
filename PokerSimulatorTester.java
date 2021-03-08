/*
 * This is a class that tests to make sure PokerSimulator.java has all the required methods.
 * IF THIS CLASS DOES NOT COMPILE AND RUN WITH YOUR PokerSimulator.java, THEN YOUR SCORE ON
 * THE ASSIGNMENT WILL BE ZERO.  Please don't underestimate the importance of following specifications.
 * 
 * The output of this tester doesn't matter.  Just make sure Eclipse isn't underlining any of your
 * code in red.  If it is, go fix your code.
 * 
 * DON'T CHANGE THIS FILE.
 */
public class PokerSimulatorTester {

	public static void main(String[] args) {

		try {
			int[] r = PokerSimulator.runSimulations(10);
			int i = PokerSimulator.evaluateOnePokerHand();
			Card[] cards = { new Card(Card.ACE, Card.CLUBS), new Card(5, Card.HEARTS), new Card(3, Card.CLUBS),
					new Card(Card.QUEEN, Card.SPADES), new Card(Card.JACK, Card.DIAMONDS), };

			PokerSimulator.sort(cards);
			String s = PokerSimulator.makeString(cards);
			Card[] h = PokerSimulator.randomSortedHand();

			boolean b;
			b = PokerSimulator.hasFlush(cards);
			b = PokerSimulator.hasFourOfAKind(cards);
			b = PokerSimulator.hasFullHouse(cards);
			b = PokerSimulator.hasOnePair(cards);
			b = PokerSimulator.hasRoyalFlush(cards);
			b = PokerSimulator.hasStraight(cards);
			b = PokerSimulator.hasStraightFlush(cards);
			b = PokerSimulator.hasThreeOfAKind(cards);
			b = PokerSimulator.hasTwoPair(cards);

			PokerSimulator.displayStats(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		} catch (Exception e) {
			System.out.println("An exception was thrown.");
		}
		System.out.println("If you see this message, your program" + " has all the required methods.");
		System.out.println(
				"Note that this doesn't test that your" + " methods do the right thing...only that the methods exist.");

	}

}