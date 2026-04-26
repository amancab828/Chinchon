package players;

import java.util.List;

import cards.Card;
import combinations.Combination;
import games.Round;

/**
 * Interfaz que define el comportamiento básico de cualquier jugador del juego.
 * Establece los métodos necesarios para gestionar mano, puntuación,
 * combinaciones, turnos y acciones durante una ronda.
 *
 * Todas las implementaciones de jugadores, ya sean humanos o IA,
 * deben cumplir este contrato.
 */
public interface Player {
	
	// Getters
	List<Combination> getCombinations(); 
	List<Card> getHand();  
	int getPoints();
	int getTurn();
    String getName();
    boolean isActive();
    // Setters
    void setHand(List<Card> hand);
    void setPoints(int points);
    void setTurn(int turn);
    void setCombinations(List<Combination> combinations);
    
    /**
     * Genera una representación visual de la mano del jugador.
     *
     * @return mano mostrada en formato visual
     */
    String seeHand();
    
    /**
     * Ejecuta la lógica del turno del jugador durante una ronda.
     *
     * @param round ronda actual
     */
    void playTurn(Round round);  

    /**
     * Añade una carta a la mano del jugador.
     *
     * @param card carta recibida
     */
    void receiveCard(Card card);  
    
    /**
     * Elimina una carta de la mano del jugador.
     *
     * @param card carta descartada
     */
    void discardCard(Card card);  
    
}
