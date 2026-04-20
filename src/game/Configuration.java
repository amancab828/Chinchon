package game;

import java.util.ArrayList;
import java.util.List;

import ai.Strategy;
import player.AIPlayer;
import player.HumanPlayer;
import player.Player;
import ui.ConsoleInput;

public class Configuration {
    private ConsoleInput console;
    
    public Configuration() {
		this.console = ConsoleInput.getInstance();
	}
    
	public Game config() {
        int totalPlayers = askNumberOfPlayers();
        int humansPlayers = askNumberOfHumans(totalPlayers);
        List<Player> players = createPlayers(totalPlayers, humansPlayers);

        int maxPoints = askMaxPoints();
        int numberOfDecks = askNumberOfDecks();
        int maxRounds = askMaxRounds();
        
        return new Game(players, maxPoints, numberOfDecks, maxRounds);
	}
	
    // ---------- MÉTODOS PRIVADOS ----------

    private int askNumberOfPlayers() {
        console.escribirLinea("Número de jugadores (2-5):");
        return console.readIntInRange(2, 5);
    }

    private int askNumberOfHumans(int totalPlayers) {
        int numberHuman;
        console.escribirLinea(String.format("Número de jugadores humanos (0-%d): ", totalPlayers));
        numberHuman = console.readIntInRange(0, totalPlayers);
        console.escribirLinea(String.format("Números de IA: %d", totalPlayers - numberHuman));
        return numberHuman;
    }
    
    // Creo que es mejor preguntar es IA o no, y luego el nombre
    private List<Player> createPlayers(int total, int humans) {
        List<Player> players = new ArrayList<>();
        int ai = total - humans;

        // HUMANOS
        for (int i = 0; i < humans; i++) {
            console.escribirLinea(String.format("Nombre del jugador %d: ", i + 1));
            String name = console.readString();
            players.add(new HumanPlayer(name));
        }

        // IA
        for (int i = 0; i < ai; i++) {
            players.add(new AIPlayer("IA_" + (i + 1), new Strategy()));
        }

        return players;
    }
    
    private int askMaxPoints() {
        console.escribirLinea("Puntos máximos para perder (e.g. 100):");
        return console.readInt();
    }

    private int askNumberOfDecks() {
        console.escribirLinea("Número de barajas (1-2):");
        return console.readIntInRange(1, 2);
    }

    private int askMaxRounds() {
        console.escribirLinea("Rondas máximas (e.g. 10):");
        return console.readInt();
    }
}
