package games;

import java.util.List;
import java.util.Optional;
import players.Player;

public class Game {
	private List<Player> players; // Lista de jugadores
	private int maxPoints; // Puntos máximos para perder
	private int numberDecks; // Número de barajas a usar
	/*private int maxRounds; // Número máximo de rondas*/
	private Optional<Player> chinchonWinner; // Ganador del juego
	
	public Game(List<Player> players, int maxPoints, int numberDecks) {
		this.players = players;
		this.maxPoints = maxPoints;
		this.numberDecks = numberDecks;
		chinchonWinner = Optional.empty();
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
	/*public int getMaxRounds() {
		return maxRounds;
	}*/
	public Optional<Player> getChinchonWinner() {
		return chinchonWinner;
	}
	public void setChinchonWinner(Player winner) {
		// uso ofNullable por si winner es null, para evitar NullPointerException
		this.chinchonWinner = Optional.ofNullable(winner);
	}
	
	// Jugadores que no han perdido aún (puntos < maxPoints)
	public List<Player> getActivePlayers() {
		return players.stream()
				.filter(p -> p.getPoints() < maxPoints)
				.toList();
	}
		
	// Lógica para determinar si el juego ha terminado
	private boolean isGameOver() {
		boolean gameFinished = getActivePlayers().size() <= 1; 
		if (chinchonWinner.isPresent()) {
			gameFinished = true;
		}
		return gameFinished;
	}
	
	// Lógica para jugar una ronda
	private void playRound() {
		Round round = new Round(this);
		round.start();
	}
	
	// Lógica para determinar el ganador al finalizar el juego
	private Optional<Player> determineWinner() {
		Optional<Player> winner = Optional.empty();
		List<Player> activePlayers = getActivePlayers();
		
		if (chinchonWinner.isPresent()) {
			winner = chinchonWinner;
		} else if (activePlayers.size() == 1) {
			winner = Optional.of(activePlayers.get(0));
		} 
		
		return winner;
	}
	
	// Lógica del juego
	public Optional<Player> startGame() {
		while (!isGameOver()) {
			playRound();
		}
		return determineWinner();
	}
}
