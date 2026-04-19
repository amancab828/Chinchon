package ai;

import java.util.List;
import cards.Card;

// Estrategia de IA
public interface AIStrategy {
	boolean shouldDrawFromDiscard(Card topDiscardCard, List<Card> hand);
	Card chooseDiscard(List<Card> hand);
}
