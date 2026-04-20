package game;

import java.util.List;
import cards.Card;
import cards.Deck;
import player.Player;

public class Round {
	private Game game; // Referencia al juego para acceder a jugadores y baraja
	private List<Card> discardPile; // Montón de descarte
	private Card topCard; // Carta superior del montón de descarte

	public Round(Game game) {
		// Usar getter de Game para obtener jugadores y baraja
		this.game = game;
		this.discardPile = null; 
		this.topCard = null; 
	}
	
	// Reparto
	private void dealCards() {
		
	}
	// Turno de cada jugador
	private void nextTurn() {
		
	}
	// Verificación de fin de ronda
	private boolean checkRoundEnd() {
		return false;
	}
	
	// Ejecuta toda la ronda completa
	public void start() {
		dealCards();
		while (!checkRoundEnd()) {
			nextTurn();
		}
	}
}
