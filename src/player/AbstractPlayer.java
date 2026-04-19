package player;

import java.util.List;

import cards.Card;
import game.Round;

// Clase padre de los jugadores
public abstract class AbstractPlayer implements Player {
	protected String name;
	protected List<Card> hand;
	protected int points;
	
	// Constructor padre
	public AbstractPlayer(String name) {
		this.name = name;
		points = 0;
	}
	
	// Getters
	@Override
	public String getName() {
		return name;
	}
    @Override
    public List<Card> getHand(){
    	return null;
    };
    @Override
    public int getPoints() {
		return 0;
	};

	// Setters
	@Override
	public void setHand(List<Card> hand) {
		this.hand = hand;
	};
	@Override
	public void setPoints(int points) {
		this.points = points;
	};
	
	// Añade carta a la mano
    @Override
    public void receiveCard(Card card) {
    	
    };  

    // Elimina carta de la mano
    @Override
    public void discardCard(Card card) {
    	
    };  
    
    // Indica si puede cerrar ronda
	@Override
	public boolean canClose() {
		return false;
	}
    
	// Lógica del turno 
	@Override
	public void playTurn(Round round) {
		
	}    
}
