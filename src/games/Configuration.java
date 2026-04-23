package games;

import java.util.ArrayList;
import java.util.List;

import players.Player;
import players.PlayerFactory;
import ui.ConsoleInput;

public class Configuration {
    private ConsoleInput console;
    
    public Configuration() {
		this.console = ConsoleInput.getInstance();
	}
    
	public Game config() {
        int totalPlayers = askNumberOfPlayers();
        List<Player> players = createPlayers(totalPlayers);

        int maxPoints = askMaxPoints();
        int numberOfDecks = askNumberOfDecks();
        //int maxRounds = askMaxRounds();
        
        //return new Game(players, maxPoints, numberOfDecks, maxRounds);
        return new Game(players, maxPoints, numberOfDecks);
	}
	
    // ---------- MÉTODOS PRIVADOS ----------

    private int askNumberOfPlayers() {
        console.escribirLinea("Número de jugadores (2-5):");
        return console.readIntInRange(2, 5);
    }

	// Aquí se usa el patron Factory para crear los jugadores, preguntando si son humanos o IA
	// Configuration no sabe en ningún momento qué tipo de jugador se está creando, solo delega esa responsabilidad al PlayerFactory
    private List<Player> createPlayers(int total){
    	List<Player> players = new ArrayList<>();
    	PlayerFactory playerFactory = new PlayerFactory();
    	
    	for (int i = 0; i < total; i++) {
			console.escribirLinea(String.format("¿El jugador %d es humano? (s/n): ", i + 1));
			boolean playerType = console.readBooleanUsingChar('s', 'n');
			
			if (playerType) {
				console.escribirLinea(String.format("Nombre del jugador %d: ", i + 1));
				String name = console.readString();
				players.add(playerFactory.createPlayer(name, true));
			} else {
				players.add(playerFactory.createPlayer(String.format("%d", i+1), false));
			}
    	}
    	
    	return players;
    }
    
    private int askMaxPoints() {
        // probar con 0, a ver que pasa
        console.escribirLinea("Puntos máximos para perder:");
        return console.readInt();
    }

    private int askNumberOfDecks() {
        console.escribirLinea("Número de barajas (1-2):");
        return console.readIntInRange(1, 2);
    }

    /*private int askMaxRounds() {
        console.escribirLinea("Rondas máximas (e.g. 10):");
        return console.readInt();
    }*/
}
