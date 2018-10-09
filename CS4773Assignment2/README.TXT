Design Principles Implemented:
#1) Protected Variations/Open-Closed Principle:
	GameOfWar.java and its subclasses allow for the program to add on any type of variation of war. This allows us to leave the 
	GameOfWar code, and each of its children, alone while we add on another variance of the game separately.
#2) High Cohesion
	Deck.java only had one class variable, an ArrayList of Cards, but all the methods declared within the class had something to do
	with the class variable. 
#3) Single Responsibility Principle
	Both Hand.java and WinPile.java help break up the responsibilities that Player.java originally had.  Player.java had too many things
	going on and since Hand and WinPile were used to keep track of different things and were both able to be used by each variation of
	the game, we went ahead and made them their own class. 
#4) Interface Segregation Principle
	Initially, GameOfWar had a playWar() method that variation 1 or 2 didn't implement. Since 2/3 of our variations didn't implement, we took
	it out of the interface all together and just added the single method to the third variation of the game, per design principles. 
#5) Dependency Inversion / Dependency Injection
	This may or may not count, but it was pretty hard to test with the logger, especially with the time stamps. We thought about making a mock Logger
	but the way we initialized the logger in the global space of our classes, it wasn't allowing us to do so. Instead we initialize the logger in
	the constructor and also pass it in, in case we need to test with a mock logger in the future. 