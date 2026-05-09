package app;

import java.util.Optional;

import games.Configuration;
import games.Game;
import players.Player;
import ui.ConsoleInput;
import ui.Menu;


/**
 * Punto de entrada de la aplicación.
 * Gestiona el menú principal y el flujo inicial del juego.
 */
public class Main {
	
	/**
	 * Muestra el menú principal y gestiona la ejecución del juego.
	 * Permite iniciar partida, ver reglas o salir del programa.
	 */
	public void show() {
    	ConsoleInput console = ConsoleInput.getInstance();
    	Menu menu = new Menu();
		Configuration configuration = new Configuration();
    	int option;
    	Game game;
    	Optional<Player> winner;
    
    	do {
    		menu.showMenu();
    		option = console.readIntInRange(1, 3);

    		switch (option) {
    			case 1 -> {
    				game = configuration.config();
    				console.writeLine("¡Comenzando el juego!");
    				winner = game.startGame();
    				
    				if (winner.isPresent()) {
    					console.writeSquareBlack("Ganador: " + winner.get().getName());
    				} else {
    					console.writeLine("No se ha determinado ganador");
    				}
    			}
    			case 2 -> menu.showRules();
    			case 3 -> console.write("Saliendo...");
				default -> console.write("Opción no válida. Por favor, elige una opción del menú.");
    		}
    	} while (option != 3);
    	
        console.close();
	}
	
	/**
	 * Método principal que inicia la aplicación.
	 *
	 * @param args argumentos de línea de comandos
	 */
	public static void main(String[] args) {
		new Main().show();
	}
}