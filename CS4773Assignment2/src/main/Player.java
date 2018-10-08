package main;

public class Player {
	public Hand currentHand;
	private int score;
	private String name;
	public WinPile playerWinPile;
	
	public Player(String name) {
		this.name = name;
		this.score = 0;
		currentHand = new Hand();
		playerWinPile = new WinPile();
	}
	
	public void updateScore() {
		score += playerWinPile.getPlayerScore();
	}
	
	public void updateHand() {
		this.playerWinPile.refillPlayerHand(this.currentHand);
	}
	
	public Hand getCurrentHand() {
		return this.currentHand;
	}
	
	public String toString() {
		return this.name;
	}
	
	public Card playUpCard() {
		Card topCard = currentHand.getTopCard();
		currentHand.removeTopCard();
		return topCard;
	}
	
	public WinPile getPlayerWinPile() {
		return this.playerWinPile;
	}
	
	public int getScore() {
		return this.score;
	}

}
