package games;

import java.util.ArrayList;
import java.util.List;

import players.Player;
import players.PlayerFactory;
import ui.ConsoleInput;

/**
 * Clase encargada de configurar una partida del juego.
 * Solicita los parámetros necesarios al usuario (jugadores, puntos máximos, barajas, etc.)
 * y construye el objeto Game listo para ser ejecutado.
 *
 * Esta clase no contiene lógica del juego, únicamente configuración inicial.
 */
public class Configuration {
    private ConsoleInput console;
    
    /**
     * Inicializa la configuración del juego.
     * Obtiene la instancia única de entrada por consola.
     */
    public Configuration() {
		this.console = ConsoleInput.getInstance();
	}
    
    /**
     * Configura todos los parámetros necesarios para iniciar una partida.
     * Solicita datos al usuario y crea los jugadores y la partida.
     *
     * @return objeto Game completamente configurado
     */
	public Game config() {
        int totalPlayers = askNumberOfPlayers();
        List<Player> players = createPlayers(totalPlayers);

        int maxPoints = askMaxPoints();
        int numberOfDecks = askNumberOfDecks();
        //int maxRounds = askMaxRounds();
        
        //return new Game(players, maxPoints, numberOfDecks, maxRounds);
        return new Game(players, maxPoints, numberOfDecks);
	}
	
    /**
     * Solicita al usuario el número de jugadores (entre 2 y 5).
     *
     * @return número de jugadores introducido
     */
    private int askNumberOfPlayers() {
        console.writeLine("Número de jugadores (2-5):");
        return console.readIntInRange(2, 5);
    }

    /**
     * Crea la lista de jugadores para la partida.
     * Utiliza el patrón Factory para instanciar jugadores humanos o IA
     * sin que esta clase conozca sus implementaciones concretas.
     *
     * @param total número total de jugadores a crear
     * @return lista de jugadores configurados
     */
    private List<Player> createPlayers(int total){
    	List<Player> players = new ArrayList<>();
    	PlayerFactory playerFactory = new PlayerFactory();
    	
    	for (int i = 0; i < total; i++) {
			console.writeLine(String.format("¿El jugador %d es humano? (s/n): ", i + 1));
			boolean playerType = console.readBooleanUsingChar('s', 'n');
			
			if (playerType) {
				console.writeLine(String.format("Nombre del jugador %d: ", i + 1));
				String name = console.readString();
				players.add(playerFactory.createPlayer(name, true));
			} else {
				players.add(playerFactory.createPlayer(String.format("%d", i+1), false));
			}
    	}
    	
    	return players;
    }
    
    /**
     * Solicita los puntos máximos de la partida.
     *
     * @return puntuación máxima permitida antes de perder
     */
    private int askMaxPoints() {
        console.writeLine("Puntos máximos para perder:");
        return console.readInt();
    }

    /**
     * Solicita el número de barajas que se usarán en la partida.
     *
     * @return número de barajas (1 o 2)
     */
    private int askNumberOfDecks() {
        console.writeLine("Número de barajas (1-2):");
        return console.readIntInRange(1, 2);
    }

    /*private int askMaxRounds() {
        console.escribirLinea("Rondas máximas (e.g. 10):");
        return console.readInt();
    }*/
}
