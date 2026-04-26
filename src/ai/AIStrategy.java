package ai;

import java.util.List;

import cards.Card;
import cards.Deck;

/**
 * Define la estrategia de decisión de un jugador IA durante su turno.
 */
public interface AIStrategy {
	
	/**
	 * Decide de dónde robar (mazo o descarte) y realiza la acción.
	 *
	 * @param deck baraja del juego
	 * @param hand mano actual del jugador
	 * @return carta robada
	 */
	Card turnDraw(Deck deck, List<Card> hand);
	
	/**
	 * Decide qué carta descartar de la mano.
	 *
	 * @param hand mano actual del jugador
	 * @return carta a descartar
	 */
	Card turnDiscard(List<Card> hand);
	
	/**
	 * Decide si el jugador quiere cerrar la ronda.
	 *
	 * @param hand mano actual del jugador
	 * @param turn turno actual
	 * @return true si decide cerrar, false en caso contrario
	 */
	boolean turnStand(List<Card> hand, int turn);
}
