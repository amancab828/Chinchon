package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ui.ConsoleInput;

// Baraja
public class Deck {
	private List<Card> cards;
	private List<Card> discardPile; // Para el descarte
	
	// Constructor: crea la baraja española
	public Deck(int numDecks) {
		cards = new ArrayList<>();
		discardPile = new ArrayList<>();
		
		for (int i = 0; i < numDecks; i++) {
			for (Suit suit : Suit.values()) {
				// Baraja española: 1–7 y 10–12 (sin 8 ni 9)
				for (int value = 1; value <= 12; value++) {
					if (value != 8 && value != 9) {
						cards.add(new Card(suit, value));
					}
				}
			}
		}
		
		shuffle();
	}
	
	// Barajar
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	// Descartar una carta, para añadirla al descarte
    public void discard(Card card) {
        discardPile.add(card);
    }
	
	// Robar una carta del montón
	public Card drawCard() {
		if (cards.isEmpty()) {
			ConsoleInput.getInstance().escribirLinea("¡La baraja está vacía! Se vuelve a barajar");
			cards.addAll(discardPile);
			discardPile.clear();
			shuffle();
			
			// Mirar si esto mejor hacerlo desde partida
			// Añadir la última carta del monton al descarte para que haya una boca arriba
			discard(cards.remove(cards.size() - 1)); 
		}
		return cards.remove(cards.size() - 1);
	}
	
	// Robar una carta del descarte
	public Card drawDiscardPile() {
		return discardPile.remove(discardPile.size() - 1);
	}
}
