package main;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WarVariation3 implements GameOfWar{

	Player player1;
	Player player2;
	Player player3;
	
	boolean gameInProgress;
	
	ArrayList<Card> wonCards;
	
	private static Logger logger = LogManager.getLogger(WarVariation3.class);
	
	public WarVariation3() {
		gameInProgress = true;
		
		player1 = new Player("Bob");
		player2 = new Player("Sue");
		player3 = new Player("lowkeysnc");

		Deck gameDeck = new Deck();
		wonCards = new ArrayList<Card>();
		gameDeck.shuffle();
		
		gameDeck.dealDeckEvenly(new Player[] {player1, player2, player3});
		
		playGame();
	}
	@Override
	public void playRound() {
		Card firstPlayerCard = player1.playUpCard();
		Card secondPlayerCard = player2.playUpCard();
		Card thirdPlayerCard = player3.playUpCard();
		
		logger.info(player1 + " plays " + firstPlayerCard + " as up card");
		logger.info(player2 + " plays " + secondPlayerCard + " as up card");
		logger.info(player3 + " plays " + thirdPlayerCard + " as up card");
		
		wonCards.add(firstPlayerCard);
		wonCards.add(secondPlayerCard);
		wonCards.add(thirdPlayerCard);
		
		findMax(firstPlayerCard, secondPlayerCard, thirdPlayerCard);
	}

	public void findMax(Card first, Card second, Card third) {
		if(first.getValue() > second.getValue()) {
			if(first.getValue() > third.getValue())			// 1
				resolveRound(player1);
			else if(third.getValue() > first.getValue())	// 3
				resolveRound(player3);
			else
				playWar(new Player[] {player1, player3});	//1,3
			
		} else if (first.getValue() < second.getValue()) {
			if(second.getValue() > third.getValue())		// 2
				resolveRound(player2);
			else if (third.getValue() > second.getValue())	// 3
				resolveRound(player3);
			else
				playWar(new Player[] {player2, player3});	// 2,3 	
		} else {
			if (third.getValue() > first.getValue())		// 3
				resolveRound(player3);
			else if (third.getValue() == first.getValue())	//1,2,3
				playWar(new Player[] {player1, player2, player3});	
		}
		
	}
	
	public void playWar(Player[] players) {
		logger.info("War!");
		Card first;
		Card second;
		Card third;
		
		if ((player1.getCurrentHand().getCardsLeft()  == 0) || (player2.getCurrentHand().getCardsLeft()  == 0) ||
				(player3.getCurrentHand().getCardsLeft() == 0)){
			return;
		}
		
		if (players.length == 2) {
			first = players[0].playUpCard();
			second = players[1].playUpCard();
			
			wonCards.add(first);
			wonCards.add(second);
			
			logger.info(players[0] + " plays " + first + " as up card");
			logger.info(players[1] + " plays " + second + " as up card");
			
			if (first.getValue() > second.getValue() ) {
				resolveRound(players[0]);
			} else if (second.getValue() > first.getValue()) {
				resolveRound(players[1]);
			} else {
				playWar(new Player[] {players[0], players[1]});
			}
		} else {
			first = player1.playUpCard();
			second = player2.playUpCard();
			third = player3.playUpCard();
			
			wonCards.add(first);
			wonCards.add(second);
			wonCards.add(third);
			
			logger.info(players[0] + " plays " + first + " as up card");
			logger.info(players[1] + " plays " + second + " as up card");
			logger.info(players[2] + " plays " + third + " as up card");
			findMax(first, second, third);
		}
		
	}
	@Override
	public void resolveRound(Player roundWinner) {
		logger.info(roundWinner + " wins the round");
		for(Card c: wonCards) {
			roundWinner.getPlayerWinPile().addToPile(c);
		}
		wonCards.clear();
	}

	@Override
	public void playGame() {
		int counter = 0;
		while(gameInProgress) {
			playRound();
			
			logger.info("Score is " + player1 + " " + player1.getPlayerWinPile().getWinPile().size() 
					+ ", " + player2 + " " + player2.getPlayerWinPile().getWinPile().size()
					+ ", " + player3 + " " + player3.getPlayerWinPile().getWinPile().size());
			if ((player1.getCurrentHand().getCardsLeft()  == 0) || (player2.getCurrentHand().getCardsLeft()  == 0) ||
					(player3.getCurrentHand().getCardsLeft() == 0)){
				gameInProgress = false;
			}
			if (counter >= MAX_ITERATIONS) {
				break;
			}
			counter++;
		}
		resolveWinner();
	}
	
	public void resolveWinner() {
		player1.updateScore();
		player2.updateScore();
		player3.updateScore();
		if (player1.getScore() > player2.getScore()) {
			if(player1.getScore() > player3.getScore()) {	
				logger.info(player1 + " wins!");
			} else if (player3.getScore() > player1.getScore()) {
				logger.info(player3 + " wins!");
			} else {
				logger.info("Tie game!");
			}
		} else if (player1.getScore() < player2.getScore()) {
			if(player2.getScore() > player3.getScore()) {
			logger.info(player2 + " wins!");
			} else if (player3.getScore() > player2.getScore()) {
				logger.info(player3 + " wins!");
			} else {
				logger.info("Tie game!");
			}
		} else {
			if(player3.getScore() > player1.getScore()) {
				logger.info(player3 + " wins!");
			} else{
				logger.info("Tie game!");
			}
		}
		
	}

}
