import java.util.ArrayList;
import java.util.Collections;

/**
 * A deck of 52 cards, with standard values from ace through king,
 * and suits (clubs, hearts, spades, diamonds).  Contains methods
 * for shuffling and dealing.
 * @author Norm Krumpe
 */



public class PokerDeck {

	private ArrayList<Card> cards;

	/**
	 * Creates an unshuffled deck of 52 cards.
	 */
	public PokerDeck() {
		cards = new ArrayList<Card>();
		reset();
	}

	/**
	 * Shuffles the cards still in the deck
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}

	/**
	 * Returns the next card in the deck, or null if there
	 * are no cards remaining.  After this method the
	 * deck will have one less card than before.
	 * @return the next card in the deck
	 */
	public Card deal() {
		return cards.size() > 0 ? cards.remove(0) : null;
	}

	/**
	 * Returns a String representation of this deck of cards.
	 * @return a space separated list of the remaining cards in the deck
	 */
	public String toString() {
		String result = "";
		for (Card c : cards) {
			result += c + " ";
		}

		return result.trim();
	}

	/**
	 * Gets the number of cards remaining in the deck
	 * @return the number of cards remaining in the deck
	 */
	public int getSize() {
		return cards.size();
	}

	/**
	 * Returns whether the deck is empty (containing no cards).
	 * @return true of the deck has no cards remaining, and false
	 * otherwise
	 */
	public boolean isEmpty() {
		return getSize() == 0;
	}

	/**
	 * Removes all the current cards from the deck, and
	 * refills it with 52 new cards, unshuffled, beginning
	 * with ace through king of clubs, then repeating with
	 * hearts, spades, and diamonds.
	 */
	public void reset() {
		cards.clear();
		for (int i = 0; i < 52; i++) {
			cards.add(new Card(i % 13 + 1, i / 13));
		}
	}
}
