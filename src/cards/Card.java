package cards;

public class Card {
	private Suit suit;
	private int value;
	
	//Constructor
	public Card(Suit suit, int value) {
		this.suit = suit;
		this.value = value;
	}
	//Getters
	public Suit getSuit() {
		return suit;
	}
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return String.format("%s %d", suit, value);
	}	
}
