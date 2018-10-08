package main;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WarVariation2 implements GameOfWar{

	Player player1;
	Player player2;
	
	boolean gameInProgress;
	
	ArrayList<Card> wonCards;
	
	private static Logger logger = LogManager.getLogger(WarVariation2.class);
	
	public WarVariation2() {
		gameInProgress = true;
		
		player1 = new Player("Bob");
		player2 = new Player("Sue");

		
		Deck gameDeck = new Deck();
		wonCards = new ArrayList<Card>();
		gameDeck.shuffle();
		
		gameDeck.dealDeckEvenly(new Player[] {player1, player2});
		
		playGame();
	}
	
	@Override
	public void playRound() {
		if ((player1.getCurrentHand().getCardsLeft()  == 0) || (player2.getCurrentHand().getCardsLeft()  == 0))
			return;
		
		Card firstPlayerCard = player1.playUpCard();
		Card secondPlayerCard = player2.playUpCard();
		
		logger.info(player1 + " plays " + firstPlayerCard + " as up card");
		logger.info(player2 + " plays " + secondPlayerCard + " as up card");
		
		wonCards.add(firstPlayerCard);
		wonCards.add(secondPlayerCard);
		
		int comparison = firstPlayerCard.compareTo(secondPlayerCard);
		if (comparison == 0) {
			logger.info("War!");
			playRound();
		} else if (comparison > 0) {
			resolveRound(player1);
		} else {
			resolveRound(player2);
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
			
			logger.info("Score is " + player1 + " " + player1.getPlayerWinPile().getWinPile().size() + ", " + player2 + " " + player2.getPlayerWinPile().getWinPile().size());
			if ((player1.getCurrentHand().getCardsLeft()  == 0) || (player2.getCurrentHand().getCardsLeft()  == 0)){
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
		if (player1.getScore() > player2.getScore()) {
			logger.info(player1 + " wins!");
		} else if (player1.getScore() < player2.getScore()) {
			logger.info(player2 + " wins!");
		} else {
			logger.info("Tie game!");
		}
		
	}

}
