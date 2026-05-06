package players;

import ai.AIStrategy;
import cards.Card;
import cards.Deck;
import games.Round;
import ui.ConsoleInput;
import combinations.CombinationSolver;

/**
 * Representa un jugador controlado por inteligencia artificial.
 * Utiliza una estrategia de decisión para determinar sus acciones
 * durante el turno de forma automática.
 *
 * Hereda la funcionalidad común de AbstractPlayer y delega
 * la toma de decisiones en una implementación de AIStrategy.
 */
public class AIPlayer extends AbstractPlayer {
    private AIStrategy strategy;
    ConsoleInput console = ConsoleInput.getInstance();
    CombinationSolver factory = new CombinationSolver();

    /**
     * Crea un jugador IA con un nombre y estrategia definidos.
     *
     * @param name nombre del jugador
     * @param strategy estrategia utilizada para tomar decisiones
     */
    public AIPlayer(String name, AIStrategy strategy) {
    	super(name);
        this.strategy = strategy;
    }

    /**
     * Gestiona la fase de robo del turno de la IA.
     * La decisión se delega en la estrategia configurada.
     *
     * @param deck baraja actual de la ronda
     * @return carta robada
     */
	private Card turnDraw(Deck deck) {
		Card drawCard;
		console.writeLine(String.format("==== Mano de %s ====", name));
		console.writeLine(seeHand());

        drawCard = strategy.turnDraw(deck, hand);
		
		console.writeLine(String.format("%s roba: %s", name, drawCard.toString()));
		return drawCard;
	}
	
    /**
     * Gestiona la fase de descarte del turno de la IA.
     * La estrategia decide qué carta descartar.
     *
     * @param deck baraja actual de la ronda
     */
	private void turnDiscard(Deck deck) {
		Card discardCard;
		console.writeLine("Mano de la IA (8 cartas):");
		console.writeLine(seeHand());
		
		discardCard = strategy.turnDiscard(hand);

		// Añadir la carta al descarte
		deck.discard(discardCard);
		// Eliminar la carta de la mano
		discardCard(discardCard);
		
		console.writeLine(String.format("La IA descarta: %s", discardCard.toString()));
	}
	
    /**
     * Determina si la IA decide plantarse y cerrar la ronda.
     * Verifica el cumplimiento de las reglas antes de confirmar la acción.
     *
     * @return true si la IA puede plantarse
     */
	private boolean turnStand(Round round) {
		int points;
        boolean stand = strategy.turnStand(hand, getTurn());

        // Validación de reglas
        if (stand) {
            points = factory.calculatePoints(hand, factory.getBestCombinations(hand));
            if (points > 5) {
            	stand = false;
            }
            if (getTurn() == 1) {
            	stand = false;
            }
        }

		if (round.hasChinchon(hand)) {
		    round.winnerByChinchon(this);
		}
		
        setTurn(getTurn() + 1);
        return stand;
	}
	
    /**
     * Ejecuta el turno completo del jugador IA.
     * Incluye:
     * - Robo de carta
     * - Descarte
     * - Posibilidad de plantarse
     *
     * @param round ronda actual del juego
     */
    /** {@inheritDoc} */
	@Override
	public void playTurn(Round round) {
		receiveCard(turnDraw(round.getDeck()));
		turnDiscard(round.getDeck());
		if (turnStand(round)) {
            console.writeLine(String.format("%s cierra la ronda.", name));
			round.setRoundOver();
		}
	}
}
