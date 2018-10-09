package main;

import java.util.ArrayList;
import java.util.Iterator;

public class WinPile implements Iterable<Card>{
	ArrayList<Card> winPile;
	
	public WinPile() {
		winPile = new ArrayList<Card>();
	}
	
	public int getPlayerScore(){
		//Get the points for this win pile
		return this.winPile.size();
	}
	
	public void refillPlayerHand(Hand playerHand) {
		for(Card c : winPile) {
			playerHand.addtoBottomofHand(c);

		}
		this.winPile.clear();
	}
	
	public void addToPile(Card card) {
		this.winPile.add(card);
	}
	
	public ArrayList<Card> getWinPile(){
		return this.winPile;
	}

	@Override
	public Iterator<Card> iterator() {
		return winPile.iterator();
	}
	
	public String toString() {
		String winPileString = new String();
		for(Card c: this.winPile) {
			winPileString += c + "\n";
		}
		return winPileString;
	}

	public void setWinPile(ArrayList<Card> winPile) {
		this.winPile = winPile;
	}

}
