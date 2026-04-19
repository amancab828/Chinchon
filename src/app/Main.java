package app;

import ui.ConsoleInput;
import ui.Menu;
import game.Game;
import game.Configuration;

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
    				console.escribir("¡Comenzando el juego!");
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