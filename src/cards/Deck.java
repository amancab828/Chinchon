package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ui.ConsoleInput;

/**
 * Representa la baraja española del juego.
 * Gestiona el mazo de cartas y el montón de descartes.
 */
public class Deck {
	private List<Card> cards;
	private List<Card> discardPile; // Para el descarte
	
	/**
	 * Constructor: Crea una baraja española con el número de mazos indicado.
	 * Incluye cartas del 1 al 7 y del 10 al 12 para cada palo.
	 *
	 * @param numDecks número de barajas a utilizar
	 */
	public Deck(int numDecks) {
		cards = new ArrayList<>();
		discardPile = new ArrayList<>();
		int idCounter = 0;
		
		for (int i = 0; i < numDecks; i++) {
			for (Suit suit : Suit.values()) {
				// Baraja española: 1–7 y 10–12 (sin 8 ni 9)
				for (int value = 1; value <= 12; value++) {
					if (value != 8 && value != 9) {
						cards.add(new Card(suit, value, idCounter++));
					}
				}
			}
		}
		
		shuffle();
	}
	
	/**
	 * Mezcla aleatoriamente las cartas del mazo.
	 */
	private void shuffle() {
		Collections.shuffle(cards);
	}
	
	/**
	 * Añade una carta al montón de descartes.
	 *
	 * @param card carta a descartar
	 */
    public void discard(Card card) {
        discardPile.add(card);
    }
    
	/**
	 * Devuelve la última carta del descarte sin retirarla.
	 *
	 *<p>En ningún momento la pila de descarte puede llegar a estar vacia</p>
	 *
	 * @return última carta del descarte
	 */
    public Card seeDiscardPile() {
		return discardPile.get(discardPile.size() - 1);
	}
	
	/**
	 * Roba una carta del mazo principal.
	 * Si el mazo está vacío, se baraja la pila de descarte.
	 *
	 * @return carta robada
	 */
	public Card drawCard() {
		if (cards.isEmpty()) {
			ConsoleInput.getInstance().writeLine("¡La baraja está vacía! Se vuelve a barajar");
			cards.addAll(discardPile);
			discardPile.clear();
			shuffle();
			// Añade la primera carta a la pila de descarta, para que siempre este una carta boca arriba
			discard(cards.remove(cards.size() - 1)); 
		}
		return cards.remove(cards.size() - 1);
	}
	
	/**
	 * Roba la última carta del montón de descartes.
	 *
	 * @return carta del descarte
	 */
	public Card drawDiscardPile() {
		return discardPile.remove(discardPile.size() - 1);
	}
}
