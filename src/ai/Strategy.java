package ai;

import java.util.List;
import cards.Card;

// Estrategia para la IA
public class Strategy implements AIStrategy {
	@Override
	public boolean shouldDrawFromDiscard(Card topDiscardCard, List<Card> hand) {
		return false;
	}

	@Override
	public Card chooseDiscard(List<Card> hand) {
		return null;
	}
}
