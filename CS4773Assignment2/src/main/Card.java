package main;
public class Card implements Comparable<Card>{
	private int value;
	private String suite;
	private String rank;
	
	/**
	 * Card sets up a new Card object by initializing it's suite, rank, and value. 
	 * With this card class, A > all other cards.
	 * @param suite includes SPADES, HEARTS, DIAMONDS, CLUBS
	 * @param rank includes 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A
	 * @param value includes 1-14 respectively 
	 */
	public Card(String suite, String rank, int value) {
		this.suite = suite.toUpperCase();
		this.rank = rank.toUpperCase();
		this.value = value;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}
	public String toString() {
		return rank + " of " + suite;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public int compareTo(Card other) {
		if( this.value > other.getValue()) {
			return 1;
		} else if (this.value < other.getValue()) {
			return -1;
		} else {
			return 0;
		}
	}
	
}
