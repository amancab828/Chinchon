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
		String[] cardLines = new String[5];
		
		cardLines[0] = String.format("%s┌────┐%s", color, Colors.RESET);
		cardLines[1] = String.format("%s│%-2d %s│%s", color, value, suit.getLetter(), Colors.RESET);
		cardLines[2] = String.format("%s│    │%s", color, Colors.RESET);
		cardLines[3] = String.format("%s└────┘%s", color, Colors.RESET);
		cardLines[4] = String.format("%s %s   %s", color, suit.getSymbol(), Colors.RESET); 
		
		return cardLines;
	}
	
	public String[] seeHiddenCard() {
		String[] cardLines = new String[5];
		
		cardLines[0] = "┌────┐";
		cardLines[1] = "│░░░░│";
		cardLines[2] = "│░░░░│";
		cardLines[3] = "└────┘"; 
		cardLines[4] = "   ░   ";
		
		return cardLines;
	}
	
	
	// Salida simple
	@Override
	public String toString() {
		return String.format("%d%s", value, suit.getSymbol());
	}	
}
