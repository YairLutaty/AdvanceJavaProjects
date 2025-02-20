public class Card {
	private final String face;
	private final String suit;

	public Card(String cardFace, String cardSuit) {
		this.face = cardFace;
		this.suit = cardSuit;
	}

	public String toString() {
		return face + " of " + suit;
	}

	// returns the current card identifier
	public int cardVal() {

        String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        for(int i=0;i<faces.length;i++) {
            if(face==faces[i])
                return i+1;
        }
        return 0;
    }
} // End class Card