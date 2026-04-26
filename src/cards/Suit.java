package cards;

import ui.Colors;

/**
 * Representa los palos de la baraja española.
 * Cada palo tiene un símbolo, una letra identificativa y un color para la representación en consola.
 */
public enum Suit {
    CLUBS("🌿", 'B', Colors.GREEN),      // Bastos --> Uso el verde --> 🌿
    CUPS("🍷", 'C', Colors.RED),         // Copas --> Uso el rojo --> 🍷
    SWORDS("⚔", 'E', Colors.BLUE),      // Espadas --> Uso el azul --> ⚔
    COINS("🟡", 'O', Colors.YELLOW);     // Oros --> Uso el amarillo --> 🟡
    
    private final String symbol;
    private final char letter;
    private final String color;

    /**
     * Constructor: Crea un palo con su símbolo, letra y color asociado.
     *
     * @param symbol representación visual del palo
     * @param letter letra identificativa del palo
     * @param color color usado en consola
     */
    Suit(String symbol, char letter, String color) {
        this.symbol = symbol;
        this.color = color;
        this.letter = letter;
    }

    public String getSymbol() {
        return symbol;
    }
    public String getColor() {
		return color;
	}
    public char getLetter() {
    	return letter;
    }
}
