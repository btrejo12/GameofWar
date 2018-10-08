package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import main.Card;
import main.Deck;
import main.GameOfWar;
import main.Hand;
import main.Player;
import main.WarVariation1;
import main.WarVariation2;
import main.WarVariation3;
import main.WinPile;

class WarTest {
	Deck testDeck;

	Hand testHand1;
	Hand testhand2;
	
	Player player1;
	Player player2;
	
	@Ignore
	void setUp() {
		//testDeck = new Deck();
		
		Card a = new Card("HEARTS", "FIVE", 5);
		Card b = new Card("SPADES", "KING", 13);
		Card c = new Card("CLUBS", "TEN", 10);
		
		//player1 = new Player("Bob");
		//player2 = new Player("Sue");
	}

	@Ignore
	void ValidateDeck() {
		System.out.println(testDeck);
		testDeck.shuffle();
		System.out.println("\n");
		System.out.print(testDeck);
	}
	@Ignore
	void ValidateBottomofHand() {
		try {
	
			Card c = new Card("CLUBS", "TEN", 10);
		Hand thisHand = new Hand();
		thisHand.addtoBottomofHand(c);
		System.out.print(thisHand);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Ignore
	void ValidateHandGetter() {
		Player player1 = new Player("Bob");
		Player player2 = new Player("Sue");
		Deck testDeck = new Deck();
		testDeck.dealDeckEvenly(new Player[] {player1, player2});
		System.out.println(player1.getCurrentHand());

	}
	@Ignore
	void ValidatePlayersHandAccessors() {
		Player player1 = new Player("Bob");
		Player player2 = new Player("Sue");
		Deck testDeck = new Deck();
		//testDeck.shuffle();
		
		testDeck.dealDeckEvenly(new Player[] {player1, player2});
		
		System.out.println(player1 + "'s hand:\n" + player1.getCurrentHand());
		System.out.println(player2 + "'s hand:\n" + player2.getCurrentHand());		
	}
	
	@Ignore
	void TestVariation1() {
		System.out.println("\n\n**** WAR VARIATION 1 ***\n\n");
		GameOfWar game1 = new WarVariation1();
	}
	
	@Ignore
	void TestAddToWinPile() {
		Card a = new Card("HEARTS", "FIVE", 5);
		Card b = new Card("SPADES", "KING", 13);
		
		Player player1 = new Player("Bob");
		WinPile wp = player1.getPlayerWinPile();
		wp.addToPile(a);
		wp.addToPile(b);		
	}
	
	@Ignore
	void TestScoringTwo() {
		Card a = new Card("HEARTS", "FIVE", 5);
		Card b = new Card("SPADES", "KING", 13);
		
		Player player1 = new Player("Bob");
		WinPile wp = player1.getPlayerWinPile();
		wp.addToPile(a);
		wp.addToPile(b);
		
		assertEquals(2, player1.getPlayerWinPile().getPlayerScore());
	}
	
	@Ignore
	void TestScoringFour() {
		Card a = new Card("HEARTS", "FIVE", 5);
		Card b = new Card("SPADES", "KING", 13);
		
		Player player1 = new Player("Bob");
		WinPile wp = player1.getPlayerWinPile();
		wp.addToPile(a);
		wp.addToPile(b);
		wp.addToPile(a);
		wp.addToPile(b);
		
		assertEquals(4, player1.getPlayerWinPile().getPlayerScore());
	}
	
	@Ignore
	void TestVariation2() {
		System.out.println("\n\n**** WAR VARIATION 2 ***\n\n");
		GameOfWar game2 = new WarVariation2();
	}
	
	@Test
	void TestVariation3() {
		System.out.println("\n\n**** WAR VARIATION 3 ***\n\n");
		GameOfWar game3 = new WarVariation3();
	}

}
