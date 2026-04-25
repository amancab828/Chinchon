package cards;

import ui.Colors;

public enum Suit {
    CLUBS("🌿", 'B', Colors.GREEN),      // Bastos --> Uso el verde --> 🌿
    CUPS("🍷", 'C', Colors.RED),         // Copas --> Uso el rojo --> 🍷
    SWORDS("⚔", 'E', Colors.BLUE),      // Espadas --> Uso el azul/gris --> ⚔
    COINS("🟡", 'O', Colors.YELLOW);     // Oros --> Uso el amarillo/dorado --> 🟡
    
    private final String symbol;
    private final char letter;
    private final String color;

    // Constructor del enum
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
