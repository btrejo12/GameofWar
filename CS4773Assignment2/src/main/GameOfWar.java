package main;

public interface GameOfWar {

	static final int MAX_ITERATIONS = 100;
	
	void playRound();
	void resolveRound(Player roundWinner);
	void playGame();
	void resolveWinner();

}
