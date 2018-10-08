package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Deck implements Iterable<Card>{
	
	private ArrayList<Card> deckofCards;
	
	public Deck() {
		String suites[] = { "SPADES", "HEARTS", "DIAMONDS", "CLUBS"};
		String rank[] = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"};
		
		deckofCards = new ArrayList<Card>();
		for(int i = 0; i < suites.length; i++) {
			for(int j =0 ; j < 14; j++) {
				
				Card thisCard = new Card(suites[i], rank[j], j+1);
				deckofCards.add(thisCard);
			}
		}
	}

	public void shuffle() {
		Random randomShuffler = new Random();
		
		for(int i = 0; i < deckofCards.size(); i++) {
			int randomIndex = i + randomShuffler.nextInt(deckofCards.size() - i);
			Card tempCard = deckofCards.get(randomIndex);
			deckofCards.set(randomIndex, deckofCards.get(i));
			deckofCards.set(i, tempCard);
		}
		
	}
	
	public String toString() {
		String deckString=new String();
		for(Card thisCard : deckofCards){
			deckString += thisCard + "\n";
		}
		return deckString;
	}
	
	public void dealDeckEvenly(Player[] thePlayers) {
		while(!deckofCards.isEmpty()) {
			for(int i=0;i<thePlayers.length;i++) {
				if(!deckofCards.isEmpty()) {
					thePlayers[i].getCurrentHand().addtoBottomofHand(deckofCards.get(0));
					deckofCards.remove(0);
				} else {
					break;
				}
			}
		}
	}

	@Override
	public Iterator<Card> iterator() {
		return deckofCards.iterator();
	}
}
