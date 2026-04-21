package cards;

import ui.Colors;

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
	
	// Lo hacemos en un array, para que se pueda imprimir línea a línea, y así poder mostrar varias cartas una al lado de otra. 
	// Cuando el jugador decida ver su mano completa
	public String[] seeCard() {
		String color = suit.getColor();
		String[] cardLines = new String[4];
		
		cardLines[0] = color + "┌────┐" + Colors.RESET;
		cardLines[1] = color + String.format("│%-2d%s│", value, suit.getSymbol()) + Colors.RESET;
		cardLines[2] = color + "│    │" + Colors.RESET;
		cardLines[3] = color + "└────┘" + Colors.RESET;
		
		return cardLines;
	}
	
	@Override
	public String toString() {
		return String.format("%d%s", value, suit.getSymbol());
	}	
}
