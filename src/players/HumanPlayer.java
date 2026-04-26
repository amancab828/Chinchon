package players;

import java.util.List;

import cards.Card;
import cards.Deck;
import combinations.Combination;
import combinations.CombinationSolver;
import games.Round;
import ui.ConsoleInput;

/**
 * Representa un jugador humano dentro de la partida.
 * Gestiona la interacción directa con el usuario mediante consola,
 * permitiendo tomar decisiones manuales durante su turno.
 *
 * Hereda la funcionalidad común de AbstractPlayer.
 */
public class HumanPlayer extends AbstractPlayer {
	
	ConsoleInput console = ConsoleInput.getInstance();
	
	public HumanPlayer(String name) {
		super(name);
	}

    /**
     * Gestiona la fase de robo del turno del jugador.
     * Permite elegir entre robar del mazo o del descarte.
     *
     * @param deck baraja actual de la ronda
     * @return carta robada
     */
	private Card turnDraw(Deck deck) {
		Card drawCard = null;
		int option;
		console.writeLine(String.format("==== Mano de %s ====", name));
		console.writeLine(seeHand());
		console.writeLine("¿De dónde quieres robar? 1) Mazo  2) Descarte");
		option = console.readIntInRange(1, 2);
		switch (option) {
			case 1 -> drawCard = deck.drawCard();
			case 2 -> drawCard = deck.drawDiscardPile();
			default -> console.write("Opción no válida.");
		}
		
		console.writeLine(String.format("Has robado: %s", drawCard.toString()));
		return drawCard;
	}
	
    /**
     * Gestiona la fase de descarte del turno.
     * Permite seleccionar una carta de la mano para descartar.
     *
     * @param deck baraja actual de la ronda
     */
	private void turnDiscard(Deck deck) {
		int drawOption;
		Card discardCard = null;

		console.writeLine("Tu mano (8 cartas):");
		console.writeLine(seeHand());
		console.write("Elige carta a descartar (1-8): ");
		
		drawOption = console.readIntInRange(1, 8);
		discardCard = hand.get(drawOption - 1);

		// Añadir la carta al descarte
		deck.discard(discardCard);
		// Eliminar la carta de la mano
		discardCard(discardCard);
		
		console.writeLine(String.format("Has descartado: %s", discardCard.toString()));
	}
	
    /**
     * Pregunta al jugador si desea plantarse y cerrar la ronda.
     * Verifica que cumpla las condiciones necesarias:
     * - Tener 5 puntos o menos
     * - No estar en el primer turno
     *
     * @return true si el jugador puede plantarse
     */
	private boolean turnStand() {
		CombinationSolver factory = new CombinationSolver();
		List<Combination> combinations;
		boolean stand;
		console.write("¿Quieres plantarte/cerrar la ronda? (s/n): ");
		// Calcular puntos de la mano y ver si puede plantarse
		stand = console.readBooleanUsingChar('s', 'n');
		
		if (stand) {
			combinations = factory.getBestCombinations(hand);
			if (factory.calculatePoints(hand, combinations) > 5) {
				console.writeLine("Tienes que puntuar 5 puntos o menos para poder plantarte");
				stand = false;
			}
			if (getTurn() == 1) {
				console.writeLine("No te puede plantar en el primer turno");
				stand = false;
			}
		}
		
		setTurn(getTurn()+1);
		
		return stand;
	}
	
    /**
     * Ejecuta el turno completo del jugador humano.
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
		if (turnStand()) {
			round.setRoundOver();
		}
	}
}
