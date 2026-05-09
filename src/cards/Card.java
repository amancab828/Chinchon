package cards;

import java.util.Objects;

import ui.Colors;

/**
 * Representa una carta de la baraja española.
 * Contiene un palo (suit) y un valor numérico.
 */
public class Card {
	private Suit suit;
	private int value;
	private int id; //Para detectar cartas repetidas, no comparo con suit y value por si hay dos barajas
	
	/**
	 * Constructor: Crea una nueva carta con un palo, un valor y un valor de identificación único.
	 *
	 * @param suit palo de la carta
	 * @param value valor numérico de la carta
	 * @param id identificador único de la carta (para detectar duplicados)
	 */
	public Card(Suit suit, int value, int id) {
		this.suit = suit;
		this.value = value;
		this.id = id;
	}
	
	//Getters
	public Suit getSuit() {
		return suit;
	}
	public int getValue() {
		return value;
	}
	
	/**
	 * Devuelve la representación visual de la carta en formato ASCII con color.
	 * <p>
	 * 	  Lo hacemos en un array, para que se pueda imprimir línea a línea, y así poder mostrar varias cartas una al lado de otra.
	 * 	  Cuando el jugador decida ver su mano completa
	 * </p>
	 * @return array de líneas que forman la carta
	 */
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
	
	/**
	 * Devuelve la representación de una carta oculta (sin revelar valor).
	 *
	 * @return array de líneas de la carta oculta
	 */
	public String[] seeHiddenCard() {
		String[] cardLines = new String[5];
		
		cardLines[0] = "┌────┐";
		cardLines[1] = "│░░░░│";
		cardLines[2] = "│░░░░│";
		cardLines[3] = "└────┘"; 
		cardLines[4] = "   ░   ";
		
		return cardLines;
	}
	
	
	@Override
	public String toString() {
		return String.format("%d%s", value, suit.getSymbol());
	}

	/**
	 * Dos cartas se consideran iguales si tienen el mismo id único.
	 * Esto permite distinguir cartas aunque tengan mismo valor y palo (ej: múltiples barajas).
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return id == other.id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(id));
	}
}
