package combinations;

import java.util.List;
import cards.Card;

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
		return true;
	}
}
