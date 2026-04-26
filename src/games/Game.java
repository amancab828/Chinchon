package games;

import java.util.List;
import java.util.Optional;
import players.Player;

/**
 * Clase principal que representa la partida del juego Chinchón.
 * Controla el flujo general del juego, las rondas, los jugadores
 * y determina el final de la partida.
 *
 * Se encarga de gestionar la lógica global del juego sin entrar
 * en detalles internos de cada ronda o jugador.
 */
public class Game {
	private List<Player> players; // Lista de jugadores
	private int maxPoints; // Puntos máximos para perder
	private int numberDecks; // Número de barajas a usar
	/*private int maxRounds; // Número máximo de rondas*/
	private Optional<Player> chinchonWinner; // Ganador del juego
	
    /**
     * Constructor: Crea una nueva partida con los parámetros de configuración indicados.
     *
     * @param players lista de jugadores que participarán en la partida
     * @param maxPoints puntos máximos permitidos antes de quedar eliminado
     * @param numberDecks número de barajas utilizadas en el juego
     */
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
	
    /**
     * Ejecuta una ronda completa del juego.
     * Crea una instancia de Round y la inicia.
     */
	private void playRound() {
		Round round = new Round(this);
		round.start();
	}
	
    /**
     * Determina el ganador final de la partida.
     * Prioriza el ganador por chinchón si existe,
     * si no, el último jugador en pie.
     *
     * @return jugador ganador envuelto en Optional
     */
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
	
    /**
     * Inicia la partida completa del juego.
     * Gestiona el ciclo de rondas hasta que se cumple la condición de fin.
     *
     * @return jugador ganador de la partida, si existe
     */
	public Optional<Player> startGame() {
		while (!isGameOver()) {
			playRound();
		}
		return determineWinner();
	}
}
