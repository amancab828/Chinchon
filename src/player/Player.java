package player;

import java.util.List;

import cards.Card;
import game.Round;

// Interfaz de jugador
public interface Player {
	// Getters
	int getPoints();
    String getName();
    List<Card> getHand();  
    // Setters
    void setHand(List<Card> hand);
    void setPoints(int points);
    
    // Lógica del turno
    void playTurn(Round round);  

    // Añadir carta a la mano
    void receiveCard(Card card);  
    
    // Eliminar carta de la mano
    void discardCard(Card card);  

    // Indica si puede cerrar ronda
    boolean canClose();  
}
