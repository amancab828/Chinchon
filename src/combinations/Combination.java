package combinations;

import java.util.Comparator;
import java.util.List;

import cards.Card;
import cards.Suit;

public class Combination{
	private List<Card> cards;
	private CombinationType type;
	
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
	
	// Validación de la combinación según su tipo
	public boolean isValid() {
		return switch (type) {
			case SET -> isValidSet(cards);
			case STRAIGHT -> isValidStraight(cards);
			case CHINCHON -> isValidChinchon(cards);
		};
	}
	
	private boolean isValidSet(List<Card> cards) {
		int value = cards.get(0).getValue();
		
		return cards.size() >= 3 && cards.stream().
										allMatch(card -> card.getValue() == value);
	}
	
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
		
		// Para no recorrer de manera tonta y para Todas las cartas deben ser del mismo palo
		if (valid) {
			for (Card c : sorted) {
				if (c.getSuit() != suit) {
					valid = false; 
				}
			}
		}
		
		// Para no recorrer de manera tonta y Comprobarmos que son una escalera
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
		
		// Para no recorrer de manera tonta y para Todas las cartas deben ser del mismo palo
		if (valid) {
			for (Card c : sorted) {
				if (c.getSuit() != suit) {
					valid = false; 
				}
			}
		}
		
		// Para no recorrer de manera tonta y Comprobarmos que son una escalera
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
	
	private boolean isConsecutive(int numPrevious, int numActual) {
	    return ((numActual - numPrevious == 1) || (numPrevious == 7 && numActual == 10));
	}
}
