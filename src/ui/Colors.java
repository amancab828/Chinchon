package ui;

/**
 * Clase utilitaria que define constantes de colores ANSI
 * para personalizar la salida visual en consola.
 *
 * Permite aplicar colores al texto y fondos dentro
 * de la interfaz de usuario del juego.
 */
public class Colors {
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String WHITE = "\u001B[37m";
	public static final String BLACK_BACKGROUND = "\u001B[40m";
	public static final String RED_BACKGROUND = "\u001B[41m";
	public static final String RESET = "\u001B[0m"; //Restablece el color del texto y del fondo al valor predeterminado en la consola
}
