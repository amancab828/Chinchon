package players;

import java.util.List;

import cards.Card;
import combinations.Combination;
import games.Round;

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
    public List<Card> getHand(){
    	/* ┌────┐
    	   │ 7♠ │
    	   │    │
    	   └────┘ */
    	return null;
    };
    @Override
    public List<Combination> getCombinations() {
		return null;
	};
	@Override
	public String getName() {
		return name;
	}
    @Override
    public int getPoints() {
		return 0;
	};
	@Override
	public boolean getHasClosed() {
		return false;
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
	@Override
	public void setCombinations(List<Combination> combinations) {
		
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
	
    // Metodo para formar una combinación con cartas de la mano
	@Override
    public void formCombination(List<Card> cards) {
		
	}; 
    
    // Calcula basados en las combinaciones
	@Override
    public int calculateScore() {
    	return 0;
    };  
}
