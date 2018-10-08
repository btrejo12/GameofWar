package main;

import java.util.ArrayList;
import java.util.Iterator;

public class Hand implements Iterable<Card>{
	private ArrayList<Card> handCards;
	private int cardsLeft;
	
	public Hand() {
		handCards = new ArrayList<Card>();
	}

	public void addtoBottomofHand(Card card) {
		this.handCards.add(card);
	}
	
	public void removeTopCard() {
		this.handCards.remove(0);
	}
	
	public Card getTopCard() {
		return this.handCards.get(0);
	}
	
	public String toString() {
		String handString = new String();
		for(Card c: handCards) {
			handString += c + "\n";
		}
		return handString;
	}
	
	public int getCardsLeft() {
		return this.handCards.size();
	}

	@Override
	public Iterator<Card> iterator() {
		return handCards.iterator();
	}

}
