package players;

import java.util.List;

import cards.Card;
import combinations.Combination;
import games.Round;

// Interfaz de jugador
public interface Player {
	
	// Getters
	List<Combination> getCombinations(); 
	List<Card> getHand();  
	int getPoints();
    String getName();
    boolean getHasClosed();
    // Setters
    void setHand(List<Card> hand);
    void setPoints(int points);
    void setCombinations(List<Combination> combinations);
    
    // Lógica del turno
    void playTurn(Round round);  

    // Añadir carta a la mano
    void receiveCard(Card card);  
    
    // Eliminar carta de la mano
    void discardCard(Card card);  

    // Indica si puede cerrar ronda
    boolean canClose();
    
    // Metodo para formar una combinación con cartas de la mano
    void formCombination(List<Card> cards); 
    
    // Calcula basados en las combinaciones
    int calculateScore();  
}
