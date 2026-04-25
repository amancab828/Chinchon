package ui;

public class Menu {
	private ConsoleInput console;
	
	public Menu() {
		this.console = ConsoleInput.getInstance();
	}
	
	public void showMenu() {
		console.escribirCuadrado(" = CHINCHON = ");
        console.escribirLinea("1. Jugar");
        console.escribirLinea("2. Reglas");
        console.escribirLinea("3. Salir");

        console.escribir("Selecciona una opción: ");
	}
	
	public void showRules() {
        console.escribirLinea("==== REGLAS DE CHINCHÓN ====");
        console.escribirLinea("1. El objetivo del juego es ser el jugador con menos puntos al final de las rondas.");
        console.escribirLinea("2. Cada jugador recibe 7 cartas y en su turno puede robar del mazo o del descarte.");
        console.escribirLinea("3. Luego debe descartar una carta. El juego continúa hasta que un jugador se queda sin cartas.");
        console.escribirLinea("4. Al final de cada ronda, los jugadores suman los puntos de sus cartas. El primero en llegar a 100 puntos pierde.");
	}
}