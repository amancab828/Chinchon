package games;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import cards.Deck;
import combinations.Combination;
import combinations.CombinationFactory;
import players.Player;
import ui.ConsoleInput;

public class Round {
	private Game game;
	private Deck deck;
	private List<Player> activePlayers; 
	private List<Player> players; //Para mostrar la puntuación de todos, aunque esten eliminados
	private boolean roundOver; //Los jugadores deben hacer un setter a este para plantarse
	private CombinationFactory factory = new CombinationFactory();
	private ConsoleInput console = ConsoleInput.getInstance();
	
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
	
	private void showCardstoDraw() {
		StringBuilder sb = new StringBuilder();
		Card card = deck.seeDiscardPile();
	    for (int row = 0; row < 5; row++) {
	        sb.append(String.format("%s  %s", card.seeHiddenCard()[row], card.seeCard()[row]));
	        sb.append("\n");
	    }
	    ConsoleInput.getInstance().escribirLinea(sb.toString());
	}
	
	// Turno de cada jugador
	private void nextTurn() {
		for (Player p : activePlayers) {
			if (!roundOver && p.isActive()) {
				console.escribirCuadrado(String.format("TURNO DE: %s", p.getName()));
				showCardstoDraw();
				p.playTurn(this);
			}
		}
	}
	
	// Verificación de fin de ronda
	private boolean checkRoundEnd() {
		return roundOver || game.getChinchonWinner().isPresent();
	}
	
	private void scoreRound() {
		List<Card> hand;
		List<Combination> combinations;
		int points;
		
		console.escribirLinea("\nFIN DE LA RONDA: PUNTUACIÓN");
		for (Player p : players) {
			hand = p.getHand();
			combinations = factory.getBestCombinations(hand);
			points = factory.calculatePoints(hand, combinations);
			p.setPoints(p.getPoints()+points);
			console.escribirLinea(String.format("%s: Puntos de esta ronda: %d Puntos totales: %d", p.getName(), points, p.getPoints()));
			p.setHand(new ArrayList<>());
			p.setTurn(1);
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
