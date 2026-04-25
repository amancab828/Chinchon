package ai;

import java.util.List;

import cards.Card;
import cards.Deck;

// Estrategia de IA
public interface AIStrategy {
	// Decide de dónde robar (mazo o descarte) y roba
	Card turnDraw(Deck deck, List<Card> hand);
	// Decide qué carta descartar
	Card turnDiscard(List<Card> hand);
	// Decide si quiere cerrar (la validez se comprueba fuera)
	boolean turnStand(List<Card> hand, int turn);
}
