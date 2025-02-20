# War Game Project

This JavaFX application simulates the classic card game "War", where two players compete to win all the cards. The game:

* Uses a deck of 52 standard playing cards.
* Each player gets 26 shuffled cards.
* Players reveal one card per round, and the higher value wins.
* If cards are equal, a "War" occurs, where extra cards are drawn to determine the winner.
* The game continues until one player has all the cards.

How It Works

* Card.java → Represents a single playing card with a face value and suit.

* DeckOfCards.java → Handles deck creation, shuffling, dealing, and tracking deck size.

* War.java → Implements the game logic and user interface using JavaFX.

Features
- Fully automated gameplay
- JavaFX interface with start button
- Deck shuffling and fair card distribution
- Handles "War" scenarios when cards tie
- Game continues until one player wins all cards

How to Play
1. Run the program and click "Start War Game".
2. The game automatically plays rounds until a winner is determined.
3. Alerts show the cards drawn and round results.
4. When a player wins all the cards, the game declares "Player 1/2 won the war!".
