package games;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import cards.Deck;
import combinations.Combination;
import combinations.CombinationSolver;
import players.Player;
import ui.ConsoleInput;

/**
 * Clase que representa una ronda dentro de la partida del juego Chinchón.
 * Se encarga de gestionar el reparto de cartas, el turno de los jugadores,
 * la finalización de la ronda y el cálculo de puntuaciones.
 *
 * Esta clase controla el flujo interno de una única ronda sin gestionar
 * el estado global de la partida.
 */
public class Round {
	private Game game;
	private Deck deck;
	private List<Player> activePlayers; 
	private List<Player> players; //Para mostrar la puntuación de todos, aunque esten eliminados
	private boolean roundOver; //Los jugadores deben hacer un setter a este para plantarse
	private ConsoleInput console = ConsoleInput.getInstance();
	
    /**
     * Constructor: Crea una nueva ronda asociada a una partida.
     * Inicializa la baraja, los jugadores activos y el estado de la ronda.
     *
     * @param game partida principal a la que pertenece la ronda
     */
	public Round(Game game) {
		this.game = game;
		deck = new Deck(game.getNumberDecks());
		players = game.getPlayers();
		activePlayers = game.getActivePlayers();
		roundOver = false;
	}
	
	public Deck getDeck() {
		return deck;
	}
	public void setRoundOver() {
		roundOver = true;
	}
	
    /**
     * Reparte las cartas iniciales a los jugadores activos.
     * Cada jugador recibe 7 cartas y se coloca una carta en el descarte.
     */
	private void dealCards() {
		for (Player p : activePlayers) {
			for (int i = 0; i < 7; i++) {
				p.receiveCard(deck.drawCard());
			}			
		}
		
	    // Primera carta boca arriba en el descarte, al descartar la carta va a la pila de descarte, no se pierde
	    deck.discard(deck.drawCard());
	}
	
    /**
     * Muestra la carta disponible en la pila de descarte.
     * Se imprime en formato visual en consola.
     */
	private void showCardstoDraw() {
		StringBuilder sb = new StringBuilder();
		Card card = deck.seeDiscardPile();
	    for (int row = 0; row < 5; row++) {
	        sb.append(String.format("%s  %s", card.seeHiddenCard()[row], card.seeCard()[row]));
	        sb.append("\n");
	    }
	    ConsoleInput.getInstance().writeLine(sb.toString());
	}
	
    /**
     * Gestiona el turno de cada jugador activo.
     * Permite que cada jugador realice su jugada si la ronda no ha terminado.
     */
	private void nextTurn() {
		for (Player p : activePlayers) {
			if (!roundOver && p.isActive()) {
				console.writeSquareBlack(String.format("TURNO DE: %s", p.getName()));
				showCardstoDraw();
				p.playTurn(this);
			}
		}
	}
	
	// Verificación de fin de ronda
	private boolean checkRoundEnd() {
		return roundOver || game.getChinchonWinner().isPresent();
	}
	
    /**
     * Calcula y actualiza la puntuación de todos los jugadores al finalizar la ronda.
     * Evalúa la mejor combinación de cada mano y suma los puntos obtenidos.
     * Reinicia la mano de cada jugador para la siguiente ronda.
     */
	private void scoreRound() {
		List<Card> hand;
		List<Combination> combinations;
		int points;
		CombinationSolver factory = new CombinationSolver();
		
		console.writeLineRed("\nFIN DE LA RONDA: PUNTUACIÓN");
		for (Player p : players) {
			hand = p.getHand();
			combinations = factory.getBestCombinations(hand);
			points = factory.calculatePoints(hand, combinations);
			p.setPoints(p.getPoints()+points);
			console.writeLineRed(String.format("%s: Puntos de esta ronda: %d Puntos totales: %d", p.getName(), points, p.getPoints()));
			p.setHand(new ArrayList<>());
			p.setTurn(1);
		}
	}
	
    /**
     * Inicia la ejecución completa de la ronda.
     * Controla el reparto de cartas, los turnos y el cálculo final de puntos.
     */
	public void start() {
		dealCards();
		while (!checkRoundEnd()) {
			nextTurn();
		}
		scoreRound();
	}
}
