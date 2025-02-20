import java.security.SecureRandom;
import java.util.ArrayList;

public class DeckOfCards {
    private ArrayList<Card> deck;
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final int NUMBER_OF_CARDS = 52;


    public DeckOfCards() {
        deck = new ArrayList<Card>();
        String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        // populate deck with Card objects
        for (int count = 0; count < NUMBER_OF_CARDS; count++)
            deck.add( new Card(faces[count % 13], suits[count / 13]));
    }

    // shuffle deck of Cards with one-pass algorithm
    public void shuffle() {
        // for each Card, pick another random Card (0-51) and swap them
        for(int first = 0; first < deck.size(); first++) {
            // select a random number between 0 and 51
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
            // swap current Card with randomly selected Card
            Card temp = deck.get(first);
            deck.set(first,deck.get(second));
            deck.set(second,temp);
        }
    }

    // This function is dealing one Card from the top of the deck
    public Card dealCard() {
        // determine whether Cards remain to be dealt
        if (!deck.isEmpty())
            return deck.remove(0); // return card on top of the array currently
        else {
        	return null; // return null to indicate that all Cards were dealt
        }
    }

    // This function clears the current deck
    public void clearDeck() {
        deck.clear();
    }
    
    // This function adds a card to the current deck at the "bottom" of the deck
    public void addCard(Card card) {
        deck.add(card);
    }
    
    // This function returns the size of current deck
    public int SizeOfDeck () {
        return deck.size();
    }

    // This function return if current deck is empty or not.
    public boolean isempty () {
        return deck.size() == 0;
    }
} // End of class DeckOfCards