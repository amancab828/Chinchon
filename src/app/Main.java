package app;

import java.util.Optional;

import games.Configuration;
import games.Game;
import players.Player;
import ui.ConsoleInput;
import ui.Menu;

public class Main {
	
	public void show() {
    	ConsoleInput console = ConsoleInput.getInstance();
    	Menu menu = new Menu();
		Configuration configuration = new Configuration();
    	int option;
    
    	do {
    		menu.showMenu();
    		option = console.readIntInRange(1, 3);

    		switch (option) {
    			case 1 -> {
    				Game game = configuration.config();
    				console.escribirLinea("¡Comenzando el juego!");
    				Optional<Player> winner = game.startGame();
    				if (winner.isPresent()) {
    					console.escribirLinea("Ganador: " + winner.get().getName());
    				} else {
    					console.escribirLinea("No se ha determinado ganador");
    				}
    			}
    			case 2 -> menu.showRules();
    			case 3 -> console.escribir("Saliendo...");
				default -> console.escribir("Opción no válida. Por favor, elige una opción del menú.");
    		}
    	} while (option != 3);
    	
        console.cerrar();
	}
	
	public static void main(String[] args) {
		new Main().show();
	}
}