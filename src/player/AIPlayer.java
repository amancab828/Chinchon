package player;

import ai.AIStrategy;

// Jugador de IA
public class AIPlayer extends AbstractPlayer {
    private AIStrategy strategy;

    public AIPlayer(String name, AIStrategy strategy) {
    	super(name);
        this.strategy = strategy;
    }
}
