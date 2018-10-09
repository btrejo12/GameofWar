package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Launch {

	public static void main(String[] args) {
			
			playVariationOne();
	}
	
	public static void playVariationOne() {
		Player player1 = new Player("Bob");
		Player player2 = new Player("Sue");
		
		Deck deck = new Deck();
		deck.setUpStandardDeck();
		deck.shuffle();
		GameOfWar game1 = new WarVariation1(player1, player2, deck, LogManager.getLogger(WarVariation1.class));
		game1.playGame();
	}
	public static void playVariationTwo() {
		Player player1 = new Player("Bob");
		Player player2 = new Player("Sue");
		
		Deck deck = new Deck();
		deck.setUpStandardDeck();
		deck.shuffle();
		GameOfWar game2 = new WarVariation2(player1, player2, deck, LogManager.getLogger(WarVariation2.class));
		game2.playGame();
	}
	public static void playVariationThree() {
		Player player1 = new Player("Bob");
		Player player2 = new Player("Sue");
		Player player3 = new Player("lowkeysnc");
		
		Deck deck = new Deck();
		deck.setUpStandardDeck();
		deck.shuffle();
		GameOfWar game3 = new WarVariation3(player1, player2, player3, deck, LogManager.getLogger(WarVariation1.class));
		game3.playGame();
	}

}
