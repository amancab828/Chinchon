package players;

import ai.AIStrategy;
import games.Round;

// Jugador de IA
public class AIPlayer extends AbstractPlayer {
    private AIStrategy strategy;

    public AIPlayer(String name, AIStrategy strategy) {
    	super(name);
        this.strategy = strategy;
    }

    // Lógica del turno de la IA, que se delega a la estrategia definida
	@Override
	public void playTurn(Round round) {
		
	}
}
