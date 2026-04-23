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
    boolean isActive();
    // Setters
    void setHand(List<Card> hand);
    void setPoints(int points);
    void setCombinations(List<Combination> combinations);
    
    // Ver mano
    String seeHand();
    
    // Lógica del turno
    void playTurn(Round round);  

    // Añadir carta a la mano
    void receiveCard(Card card);  
    
    // Eliminar carta de la mano
    void discardCard(Card card);  
    
}
