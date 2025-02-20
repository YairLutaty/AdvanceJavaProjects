import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is implementing the game of WAR rules using
 * Classes "DeckOfCards" and "Card" 
 */
public class War extends Application {
    public static void main(String[] args) {
        launch(args);
    }// End of main function.

    @Override
    public void start(Stage primaryStage) {
        // Initializing the UI using JAVAFX tools
    	Button b = new Button("Start War Game");
        b.setOnAction(e -> warGame());

        StackPane root = new StackPane(b);
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("War Card Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }// End of start function.

    // This function implements the "warGame" structure and steps of play.
	public void warGame() {
    	DeckOfCards deckOne = new DeckOfCards();
		DeckOfCards deckTwo = new DeckOfCards();
		DeckOfCards tmpDeck = new DeckOfCards();
		String message;
		deckOne.clearDeck(); //Clearing the decks
		deckTwo.clearDeck();
		tmpDeck.shuffle();
		seperateDecks(deckOne , deckTwo , tmpDeck); //Assuring the 2 decks are equally distributed 
		tmpDeck.clearDeck(); // Clearing the temp deck before future use.
		
		
		while(!deckOne.isempty() && !deckTwo.isempty()) {
			// Each loop we'll draw 2 cards - one of each deck and compare them ("round of game").
			Card oneC = deckOne.dealCard();
			Card twoC = deckTwo.dealCard();
			
			if(oneC.cardVal() > twoC.cardVal()) { // Player 1 card's is of higher value
				addToDeck(tmpDeck , oneC, twoC);
				addFromTmp(tmpDeck,deckOne);
				message = "Player 1 card is " + oneC +"\nPlayer 2 card is :" + twoC +"\nPlayer 1 won this round" ;
		        showAlert(message);
		        continue;
			}
			else if (oneC.cardVal() < twoC.cardVal()) {// Player 2 card's is of higher value
				addToDeck(tmpDeck , oneC, twoC);
				addFromTmp(tmpDeck,deckTwo);
				message = "Player 1 card is " + oneC +"\nPlayer 2 card is :" + twoC +"\nPlayer 2 won this round" ;
		        showAlert(message);
		        continue;
			}
			else { // No card is of higher value meaning they equal - we have reached war.
				message = "Player 1 card is " + oneC +"\nPlayer 2 card is :" + twoC +"\nThis is WAR!";
		        showAlert(message);
		        
		        for (int i = 0 ; i<2 ; i++) {
		        	// Drawing 3 cards each for the temp deck to later on give it to the winner in this war altogether 
		        	oneC = deckOne.dealCard();
		        	twoC = deckTwo.dealCard();
		        	addToDeck(tmpDeck , oneC , twoC);
		        }// End of for loop.
		        if(oneC.cardVal() > twoC.cardVal()) {//Player 1 third card was of higher value.
					addFromTmp(tmpDeck,deckOne);
		        	message = "Player 1 card is " + oneC +"\nPlayer 2 card is :" + twoC +"\nPlayer 1 won this war";
			        showAlert(message);
		        }
		        else if(oneC.cardVal() < twoC.cardVal()) {//Player 2 third card was of higher value.
					addFromTmp(tmpDeck,deckOne);
		        	message = "Player 1 card is " + oneC +"\nPlayer 2 card is :" + twoC +"\nPlayer 2 won this war";
			        showAlert(message);
		        }
		        else { //If result in war , the decision to whom the cards will go be based on the following cards drawn.
		        	message = "Player 1 card is " + oneC +"\nPlayer 2 card is :" + twoC +"\nThis war was tied,cards moves to next round!";
			        showAlert(message);
		        }
			}
		}// End of while loop.
    	// Only after exiting the loop we reach this point - therefore deckOne or deckTwo are empty.
        if(deckOne.isempty()) {// Deck of player 2 is empty so he loses.
        	message = "PLAYER 2 WON THE WAR!";
            showAlert(message);
        }
        else {// Deck of player 1 is empty so he loses.
        	message = "PLAYER 1 WON THE WAR!";
            showAlert(message);
        }
    }// End of warGame function.

    // This function receives a string and it returns it to the user using the pre-initialized JAVAFX tools.
    public void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }// End of showAlert function
    
    
    // This function assuring the fair and equal distribution of the original 52 cards deck to 2 equal 26 cards decks.
    public static void seperateDecks(DeckOfCards one , DeckOfCards two , DeckOfCards leader) {
		for (int cur = 0 ; cur < 52 ; cur++) {
			// Simulating the distribution of cards to 2 players in "one at a time" distribution
			if (cur%2 == 1) { 
				one.addCard(leader.dealCard());
			}
			else {
				two.addCard(leader.dealCard());
			}
		}// End of for loop

	} // End of seperateDecks function
    
    // This function adding two given cards to a given deck at her bottom
    public static void addToDeck(DeckOfCards deck , Card c1 , Card c2) {
    	deck.addCard(c1);
    	deck.addCard(c2);
    }// End of addToDeck function
    
    // This function is adding to a chosen deck all available cards from temp deck - and eventually clearing it for future fair use.
    public static void addFromTmp(DeckOfCards transferFrom , DeckOfCards transferTo) {
    	while(!transferFrom.isempty()) {
    		Card tmp = transferFrom.dealCard();
    		transferTo.addCard(tmp);
    	}// End of while loop.
    	transferFrom.clearDeck(); // Clearing the temp deck for future iterations
    }// End of addFromTmp function.
}//End of class War
