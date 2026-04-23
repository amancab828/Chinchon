package games;

import java.util.List;
import cards.Deck;
import combinations.CombinationFactory;
import players.Player;
import ui.ConsoleInput;

public class Round {
	private Game game;
	private Deck deck;
	private List<Player> activePlayers; 
	private List<Player> players; //Para mostrar la puntuación de todos, aunque esten eliminados
	private boolean roundOver; //Los jugadores deben hacer un setter a este para plantarse

	public Round(Game game) {
		this.game = game;
		deck = new Deck(game.getNumberDecks());
		activePlayers = game.getActivePlayers();
		roundOver = false;
	}
	
	public Deck getDeck() {
		return deck;
	}
	public void setRoundOver() {
		roundOver = true;
	}
	
	// Reparto
	private void dealCards() {
		for (Player p : activePlayers) {
			for (int i = 0; i < 7; i++) {
				p.receiveCard(deck.drawCard());
			}			
		}
		
	    // Primera carta boca arriba en el descarte, al descartar la carta va a la pila de descarte, no se pierde
	    deck.discard(deck.drawCard());
	}
	
	// Turno de cada jugador
	private void nextTurn() {
		for (Player p : activePlayers) {
			if (!roundOver && p.isActive()) {
				p.playTurn(this);
			}
		}
	}
	
	// Verificación de fin de ronda
	private boolean checkRoundEnd() {
		return roundOver || game.getChinchonWinner().isPresent();
	}
	
	// Antes de este método hacer CombinationFactory
	private void scoreRound() {
		CombinationFactory factory = new CombinationFactory();
		ConsoleInput console = ConsoleInput.getInstance();
		
		console.escribirLinea("\nFIN DE LA RONDA: PUNTUACIÓN");
		for (Player p : players) {
			// Mostrar puntos de cada uno
		}
	}
	
	// Ejecuta toda la ronda completa
	public void start() {
		dealCards();
		while (!checkRoundEnd()) {
			nextTurn();
		}
		scoreRound();
	}
}
