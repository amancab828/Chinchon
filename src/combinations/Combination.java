package combinations;

import java.util.Comparator;
import java.util.List;

import cards.Card;
import cards.Suit;

/**
 * Representa una combinación de cartas del juego.
 * Puede ser un SET (cartas del mismo valor), una STRAIGHT (escalera)
 * o un CHINCHON (escalera de 7 cartas del mismo palo).
 *
 * Esta clase encapsula la lógica de validación de cada tipo de combinación.
 */
public class Combination{
	private List<Card> cards;
	private CombinationType type;
	
	/**
	 * Constructor: Crea una nueva combinación de cartas con un tipo específico.
	 *
	 * @param cards lista de cartas que forman la combinación
	 * @param type tipo de combinación (SET, STRAIGHT o CHINCHON)
	 */
	public Combination(List<Card> cards, CombinationType type) {
		this.cards = cards;	
		this.type = type;
	}
	
	// Getters
	public List<Card> getCards() {
		return cards;
	}
	public CombinationType getType() {
		return type;
	}
	
	/**
	 * Comprueba si la combinación es válida según su tipo.
	 *
	 * @return true si la combinación cumple las reglas del juego
	 */
	public boolean isValid() {
		return switch (type) {
			case SET -> isValidSet(cards);
			case STRAIGHT -> isValidStraight(cards);
			case CHINCHON -> isValidChinchon(cards);
		};
	}
	
	/**
	 * Valida un SET (trío o más de cartas con el mismo valor).
	 *
	 * @param cards lista de cartas
	 * @return true si todas las cartas tienen el mismo valor y hay al menos 3
	 */
	private boolean isValidSet(List<Card> cards) {
		int value = cards.get(0).getValue();
		
		return cards.size() >= 3 && cards.stream().
										allMatch(card -> card.getValue() == value);
	}
	
	/**
	 * Valida una escalera (STRAIGHT).
	 * Todas las cartas deben:
	 * - Ser del mismo palo
	 * - Estar en orden consecutivo
	 * - Tener al menos 3 cartas
	 *
	 * @param cards lista de cartas
	 * @return true si forman una escalera válida
	 */
	private boolean isValidStraight(List<Card> cards) {
		Suit suit = cards.get(0).getSuit();
		int numPrevious, numActual;
		boolean valid = true;
		// Ordenamos, creamos otra lista para no modificar el original, por si da algun error
		List<Card> sorted = cards.stream()
							.sorted(Comparator.comparingInt(Card::getValue))
							.toList();
		
		// Una escalera debe tener al menos 3 cartas		
		if (sorted.size() < 3) {
			valid = false; 	
		}
		
		// Todas las cartas deben ser del mismo palo
		if (valid) {
			for (Card c : sorted) {
				if (c.getSuit() != suit) {
					valid = false; 
				}
			}
		}
		
		// Comprobarmos que son una escalera
		if (valid) {
		    for (int i = 1; i < sorted.size(); i++) {
		    	numPrevious = sorted.get(i - 1).getValue();
		    	numActual = sorted.get(i).getValue();

		    	if (!isConsecutive(numPrevious, numActual)) {
		    		valid = false;
		    	}	
		   	}
		}
		
		return valid;
	}
	
	/**
	 * Valida un CHINCHÓN.
	 * Debe ser una escalera de exactamente 7 cartas del mismo palo.
	 *
	 * @param cards lista de cartas
	 * @return true si es un chinchón válido
	 */
	private boolean isValidChinchon(List<Card> cards) {
		Suit suit = cards.get(0).getSuit();
		int numPrevious, numActual;
		boolean valid = true;
		// Ordenamos, creamos otra lista para no modificar el original, por si da algun error
		List<Card> sorted = cards.stream()
							.sorted(Comparator.comparingInt(Card::getValue))
							.toList();
		
		// El chinchon debe ser de 7 cartas		
		if (sorted.size() != 7) {
			valid = false; 	
		}
		
		// Todas las cartas deben ser del mismo palo
		if (valid) {
			for (Card c : sorted) {
				if (c.getSuit() != suit) {
					valid = false; 
				}
			}
		}
		
		// Comprobarmos que son una escalera
		if (valid) {
		    for (int i = 1; i < sorted.size(); i++) {
		    	numPrevious = sorted.get(i - 1).getValue();
		    	numActual = sorted.get(i).getValue();

		    	if (!isConsecutive(numPrevious, numActual)) {
		    		valid = false;
		    	}	
		   	}
		}
		
		return valid;
	}
	
	/**
	 * Comprueba si dos números de cartas son consecutivos en la escalera usando la baraja española.
	 *
	 * @param numPrevious valor anterior
	 * @param numActual valor actual
	 * @return true si son consecutivos o forman salto válido (7 → 10)
	 */
	private boolean isConsecutive(int numPrevious, int numActual) {
	    return ((numActual - numPrevious == 1) || (numPrevious == 7 && numActual == 10));
	}
}
