package test;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import main.Card;
import main.Deck;
import main.GameOfWar;
import main.Player;
import main.WarVariation1;
import main.WarVariation2;
import main.WarVariation3;
import main.WinPile;

class WarTest extends TestCase{
	@Test
	void ValidateDeck() {
		Card c = new Card("HEARTS", "ONE", 1);
		
		Deck testDeck = new Deck();
		testDeck.setUpTestDeck();
		
		Assert.assertEquals(c.getValue(), testDeck.getDeckofCards().get(2).getValue());
	}
	
	@Test
	void ValidateAddingToHand() {
		Player player1 = new Player("Bob");

		player1.getCurrentHand().addtoBottomofHand(new Card("SPADES", "TWO", 2));
		
		Card a = new Card("SPADES", "TWO", 2);

		
		Assert.assertEquals(a.getValue(), player1.getCurrentHand().getHandCards().get(0).getValue());
	}
	
	@Test
	void ValidateDeckDeal() {
		// Overriding equals() seems like too much for an assignment, so we test card values. 
		Player player1 = new Player("Bob");
		Player player2 = new Player("Sue");
		
		Deck testDeck = new Deck();
		testDeck.setUpTestDeck();
		testDeck.dealDeckEvenly(new Player[] {player1, player2});

		
		Assert.assertEquals(1,player1.getCurrentHand().getHandCards().get(1).getValue());
	}
	
	@Test
	void TestAddToWinPile() {
		Card a = new Card("HEARTS", "FIVE", 5);
		Card b = new Card("SPADES", "KING", 13);
		
		Player player1 = new Player("Bob");
		WinPile wp = player1.getPlayerWinPile();
		wp.addToPile(a);
		wp.addToPile(b);
		
		ArrayList<Card> testPile = new ArrayList<Card>();
		testPile.add(a);
		testPile.add(b);
		
		Assert.assertTrue(testPile.equals(wp.getWinPile()));
	}
	
	@Test
	void TestScoringZero() {
		Card a = new Card("HEARTS", "FIVE", 5);
		Card b = new Card("SPADES", "KING", 13);
		
		Player player1 = new Player("Bob");
		assertEquals(0, player1.getPlayerWinPile().getPlayerScore());
	}
	@Test
	void TestScoringTwo() {
		Card a = new Card("HEARTS", "FIVE", 5);
		Card b = new Card("SPADES", "KING", 13);
		
		Player player1 = new Player("Bob");
		WinPile wp = player1.getPlayerWinPile();
		wp.addToPile(a);
		wp.addToPile(b);
		
		assertEquals(2, player1.getPlayerWinPile().getPlayerScore());
	}
	@Test
	void TestWinPileScore() {
		Card a = new Card("HEARTS", "FIVE", 5);
		
		Player player1 = new Player("Bob");
		WinPile wp = player1.getPlayerWinPile();
		wp.addToPile(a);
		wp.addToPile(a);
		wp.addToPile(a);
		wp.addToPile(a);
		
		assertEquals(4, player1.getPlayerWinPile().getPlayerScore());
	}
	@Test
	void TestPlayer2Variation1() {
		//Player 2 should win with fixed deck, since its hard to test with logger timestamp
		Player player1 = new Player("Bob");
		Player player2 = new Player("Sue");
		
		Deck newDeck = new Deck();
		newDeck.setUpTestDeck();
		
		GameOfWar gameOne = new WarVariation1(player1, player2, newDeck, LogManager.getLogger( WarVariation1.class ));
		gameOne.playGame();
		
		assertEquals(4, player2.getScore());
	}
	@Test
	void TestPlayer2Variation2() {
		//Player 2 should win with fixed deck, since its hard to test with logger timestamp
		Player player1 = new Player("Bob");
		Player player2 = new Player("Sue");
		
		Deck newDeck = new Deck();
		newDeck.setUpTestDeck();
		
		GameOfWar gameTwo = new WarVariation2(player1, player2, newDeck, LogManager.getLogger( WarVariation2.class ));
		gameTwo.playGame();
		
		assertEquals(4, player2.getPlayerWinPile().getPlayerScore());
	}
	@Test
	void TestPlayer2Variation3() {
		//Player 2 should win with fixed deck, since its hard to test with logger timestamp
		Player player1 = new Player("Bob");
		Player player2 = new Player("Sue");
		Player player3 = new Player("lowkeysnc");
		
		Deck newDeck = new Deck();
		newDeck.setUpTestDeck();
		
		GameOfWar gameThree = new WarVariation3(player1, player2, player3, newDeck, LogManager.getLogger( WarVariation3.class ));
		gameThree.playGame();
		
		assertEquals(3, player2.getPlayerWinPile().getPlayerScore());
	}
}
