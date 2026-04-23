package players;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import combinations.Combination;
import games.Round;

// Clase padre de los jugadores
public abstract class AbstractPlayer implements Player {
	protected String name;
	protected List<Card> hand;
	protected List<Combination> combinations;
	protected int points;
	protected boolean active; 
	
	// Constructor padre
	public AbstractPlayer(String name) {
		this.name = name;
		points = 0;
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
	public void setCombinations(List<Combination> combinations) {
		this.combinations = combinations;	
	};
	
	// Método para mostrar la mano del jugador, una carta al lado de la otra, usando el método seeCard() de cada carta.
	@Override
	public String seeHand() {
		StringBuilder sb = new StringBuilder();

		// Añadir aqui lo de 1, 2, 3, 4, 5, 6, 7 y 8 para que el jugador sepa que carta es cada una 
		// Puede que el 8 no siempre, porque descarta una carta
	    for (int row = 0; row < 4; row++) {
	        for (Card card : hand) {
	            sb.append(card.seeCard()[row]).append(" ");
	        }
	        sb.append("\n");
	    }
	    
	    return sb.toString();		
	}
	
	// Añade carta a la mano
    @Override
    public void receiveCard(Card card) {
    	hand.add(card);
    };  

    // Elimina carta de la mano
    @Override
    public void discardCard(Card card) {
    	hand.remove(card);
    };  
    
	// Lógica del turno, depend de si el juhador es humano o IA, por eso es abstracta
	@Override
	public abstract void playTurn(Round round);
	
}
