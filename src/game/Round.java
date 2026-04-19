package game;

import java.util.List;
import cards.Card;
import cards.Deck;
import player.Player;

public class Round {
	private List<Player> players; 
	private Deck deck; // Baraja de cartas
	private List<Card> discardPile; // Montón de descarte
	private Card topCard; // Carta superior del montón de descarte

	public Round(List<Player> players, Deck deck) {
		this.players = players;
		this.deck = deck;
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
