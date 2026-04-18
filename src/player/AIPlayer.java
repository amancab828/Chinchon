package player;

import ai.AIStrategy;

// Jugador de IA
public class AIPlayer extends AbstractPlayer {
    private AIStrategy strategy;

    public AIPlayer(AIStrategy strategy) {
        this.strategy = strategy;
    }
}
