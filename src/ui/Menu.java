package ui;

/**
 * Clase encargada de mostrar la interfaz principal del juego en consola.
 * Gestiona el menú inicial y la visualización de las reglas del juego.
 *
 * Centraliza la interacción básica con el usuario antes del inicio
 * de la partida.
 */
public class Menu {
	private ConsoleInput console;
	
	public Menu() {
		this.console = ConsoleInput.getInstance();
	}
	
    /**
     * Muestra el menú principal del juego.
     * Permite al usuario elegir entre jugar, consultar reglas o salir.
     */
	public void showMenu() {
		console.writeSquareBlack(" = CHINCHON = ");
        console.writeLine("1. Jugar");
        console.writeLine("2. Reglas");
        console.writeLine("3. Salir");

        console.write("Selecciona una opción: ");
	}
	
    /**
     * Muestra las reglas básicas del juego Chinchón en consola.
     */
	public void showRules() {
        console.writeLine("==== REGLAS DE CHINCHÓN ====");
        console.writeLine("1. CHINCHÓN: Juego de 2-5 jugadores con baraja española (40 cartas).");
        console.writeLine("2. Objetivo: hacer Chinchón o ser el último sin superar el límite de puntos.");
        console.writeLine("3. Turno: roba (mazo o descarte) y descarta 1 carta, manteniendo siempre 7 en mano.");
        console.writeLine("4. Combina cartas: tríos (mismo número) o escaleras (mismo palo consecutivo).");
        console.writeLine("5. Cierra con 6-7 cartas combinadas (7 cartas = -10 puntos).");
        console.writeLine("6. Las cartas sueltas suman puntos (2-7 valor, figuras=10).");
	}
}