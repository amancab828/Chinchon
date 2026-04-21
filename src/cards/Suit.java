package cards;

import ui.Colors;

public enum Suit {
    CLUBS("🌿", Colors.GREEN),      // Bastos --> Uso el verde
    CUPS("🍷", Colors.RED),         // Copas --> Uso el rojo
    SWORDS("⚔️", Colors.BLUE),      // Espadas --> Uso el azul/gris
    COINS("🟡", Colors.YELLOW);     // Oros --> Uso el amarillo/dorado
    
    private final String symbol;
    private final String color;

    // Constructor del enum
    Suit(String symbol, String color) {
        this.symbol = symbol;
        this.color = color;
    }

    public String getSymbol() {
        return symbol;
    }
    public String getColor() {
		return color;
	}
}
