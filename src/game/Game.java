package game;

import java.util.List;

import cards.Deck;
import player.Player;

public class Game {
	private List<Player> players; // Lista de jugadores
	private int maxPoints; // Puntos máximos para perder
	private int numberDecks; // Número de barajas a usar
	private int maxRounds; // Número máximo de rondas
	private int numberRounds; // Número de rondas jugadas
	
	public Game(List<Player> players, int maxPoints, int numberDecks, int maxRounds) {
		this.players = players;
		this.maxPoints = maxPoints;
		this.numberDecks = numberDecks;
		this.maxRounds = maxRounds;
		this.numberRounds = 0;
	}
	
	// Getters
	public List<Player> getPlayers() {
		return players;
	}
	public int getMaxPoints() {
		return maxPoints;
	}
	public int getNumberDecks() {
		return numberDecks;
	}
	public int getMaxRounds() {
		return maxRounds;
	}
	public int getNumberRounds() {
		return numberRounds;
	}
	
	// Lógica para determinar si el juego ha terminado
	private boolean isGameOver() {
		return false;
	}
	
	// Lógica para jugar una ronda
	private void playRound() {
		// Revisar este this
		Round round = new Round(this);
		round.start();
		numberRounds++;
	}
	
	// Lógica para determinar el ganador al finalizar el juego
	private Player determineWinner() {
		Player winner = null;

		return winner;
	}
	
	// Lógica del juego
	public Player startGame() {
		while (!isGameOver()) {
			playRound();
		}
		return determineWinner();
	}
}
