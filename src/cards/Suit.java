package cards;

public enum Suit {
    CLUBS("🌿"),      // Bastos --> Uso el verde
    CUPS("🍷"),       // Copas --> Uso el rojo
    SWORDS("⚔️"),     // Espadas --> Uso el azul/gris
    COINS("🟡");       // Oros --> Uso el amarillo/dorado
    
    private final String symbol;

    // Constructor del enum
    Suit(String symbol) {
        this.symbol = symbol;
    }

    public String getSimbolo() {
        return symbol;
    }
}
