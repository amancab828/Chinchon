package players;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import combinations.Combination;
import games.Round;

/**
 * Clase abstracta que representa la base común de todos los jugadores del juego.
 * Define atributos y comportamientos compartidos entre jugadores humanos e IA,
 * incluyendo gestión de mano, puntuación, combinaciones y turnos.
 *
 * Implementa la interfaz Player y sirve como plantilla para sus subclases.
 */
public abstract class AbstractPlayer implements Player {
	protected String name;
	protected List<Card> hand;
	protected List<Combination> combinations;
	protected int points;
	protected boolean active; 
	protected int turn;
	
	// Constructor padre
	public AbstractPlayer(String name) {
		this.name = name;
		points = 0;
		turn = 1;
		hand = new ArrayList<>();
		combinations = new ArrayList<>();
		active = true;
	}
	
	// Getters
	@Override
	public String getName() {
		return name;
	}
	@Override
	public int getTurn() {
		return turn;
	}
	@Override
    public List<Card> getHand(){
    	return hand;
    };
    @Override
    public List<Combination> getCombinations() {
		return combinations;
	};
    @Override
    public int getPoints() {
		return points;
	};
	@Override
	public boolean isActive() {
		return active;
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
	public void setTurn(int turn) {
		this.turn = turn;
	};
	@Override
	public void setCombinations(List<Combination> combinations) {
		this.combinations = combinations;	
	};
	
	/** {@inheritDoc}*/
	@Override
	public String seeHand() {
		StringBuilder sb = new StringBuilder();

		// Los número arriba de las cartas
		for (int i = 0; i < hand.size(); i++) {
			sb.append(String.format(" %d.     ", i+1));
		}
		sb.append("\n");
		
		// Las cartas una tras otra
	    for (int row = 0; row < 5; row++) {
	        for (Card card : hand) {
	        	sb.append(String.format("%s  ", card.seeCard()[row]));
	        }
	        sb.append("\n");
	    }
	    
	    return sb.toString();		
	}
	
	/** {@inheritDoc}*/
    @Override
    public void receiveCard(Card card) {
    	hand.add(card);
    };  

	/** {@inheritDoc}*/
    @Override
    public void discardCard(Card card) {
    	hand.remove(card);
    };  
    
	/** {@inheritDoc}*/
	@Override
	public abstract void playTurn(Round round);
	
}
