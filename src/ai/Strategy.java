package ai;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import cards.Deck;
import combinations.CombinationSolver;

/**
 * Implementación básica de la estrategia de decisión de la IA.
 * Selecciona acciones en función de la minimización de puntos en mano.
 */
public class Strategy implements AIStrategy {
	private final CombinationSolver factory = new CombinationSolver();
	
	/** {@inheritDoc}*/
	@Override
	public Card turnDraw(Deck deck, List<Card> hand) {
		Card topDiscard = deck.seeDiscardPile();
		Card cardDraw;
		List<Card> handWithDiscard;
		int currentPoints, pointsWithDiscard;
		boolean decision;

		// Simula "robar del descarte": añadir y luego descartar la mejor carta posible.
		handWithDiscard = new ArrayList<>(hand);
		handWithDiscard.add(topDiscard);
		
		// Comparamos si teniamos más puntos antes o ahora para saber si compensa
		currentPoints = pointsOf(hand);
		pointsWithDiscard = bestPointsAfterDiscard(handWithDiscard);

		// Tomamos la decisión
		decision = pointsWithDiscard < currentPoints;
		if (decision) {
			cardDraw = deck.drawDiscardPile();
		} else {
			cardDraw =  deck.drawCard();
		}
		return cardDraw;
	}

	/** {@inheritDoc}*/
	@Override
	public Card turnDiscard(List<Card> hand) {
		Card best = hand.get(0);
		List<Card> after; //Para no modificar la original
		int bestPoints = Integer.MAX_VALUE; // Valor máximo para ir comparando
		int pts;

		for (Card card : hand) {
			after = new ArrayList<>(hand);
			after.remove(card);
			pts = pointsOf(after);

			// Si empatan, preferimos tirar la carta de mayor valor.
			if (pts < bestPoints || (pts == bestPoints && card.getValue() > best.getValue())) {
				bestPoints = pts;
				best = card;
			}
		}

		return best;
	}
	
	/** {@inheritDoc}*/
	@Override
	public boolean turnStand(List<Card> hand, int turn) {
		// La validez real (<=5 y no primer turno) se comprueba fuera.
		int pts = pointsOf(hand);
		boolean stand = false;
		
		if (pts<=5) {
			stand = true;
		}
		
		return stand;
	}

	// Para evitar repetir código, usando el método calculatePoints de CombinationFactory
	private int pointsOf(List<Card> hand) {
		return factory.calculatePoints(hand, factory.getBestCombinations(hand));
	}

	/**
	 * Calcula la mejor puntuación posible tras descartar una carta.
	 * Con el objetivo de saber que carta descartar de una mano de 8 cartas
	 *
	 * @param handWith8 mano con una carta adicional
	 * @return mínima puntuación alcanzable
	 */
	private int bestPointsAfterDiscard(List<Card> handWith8) {
		int best = Integer.MAX_VALUE; // Valor máximo para ir comparando
		List<Card> after;
		
		// Vamos probando descartando cada una de las cartas para coger la mejor puntuación posible
		for (Card discard : handWith8) {
			after = new ArrayList<>(handWith8);
			after.remove(discard);
			best = Math.min(best, pointsOf(after));
		}
		
		return best;
	}
}
