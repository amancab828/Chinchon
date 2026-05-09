package ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import static ui.Colors.*;

/**
 * Clase encargada de gestionar la entrada y salida de datos por consola.
 * Proporciona métodos seguros para leer distintos tipos de datos,
 * validar entradas y mostrar mensajes personalizados.
 *
 * Implementa el patrón Singleton para garantizar una única instancia
 * de gestión de consola durante toda la ejecución del programa.
 */
public class ConsoleInput {
	private static ConsoleInput instance;
    private Scanner keyboard;

    /**
     * Crea una nueva instancia de gestión de consola.
     *
     * @param keyboard objeto Scanner utilizado para la entrada de datos
     */
    public ConsoleInput(Scanner keyboard) {
        this.keyboard = keyboard;
    }
    
    /**
     * Devuelve la única instancia disponible de ConsoleInput.
     *
     * @return instancia única de ConsoleInput
     */
    public static ConsoleInput getInstance() {
		if (instance == null) {
			instance = new ConsoleInput(new Scanner(System.in));
		}
		return instance;
	}
    
    /**
     * Limpia el buffer de entrada del teclado.
     */
    private void cleanInput() {
        keyboard.nextLine();
    }
    
    /**
     * Cierra el recurso Scanner utilizado por consola.
     */
    public void close() {
    	keyboard.close();
    }
    
    /**
     * Muestra una línea de texto en consola.
     *
     * @param text mensaje a mostrar
     */
    public void writeLine(String text) {
        System.out.println(text);
    }
    
    /**
     * Muestra texto en consola sin salto de línea.
     *
     * @param texto mensaje a mostrar
     */
    public void write(String text) {
        System.out.print(text);
    }
    
    /**
     * Muestra una línea de texto en color rojo.
     *
     * @param text mensaje a mostrar
     */
    public void writeLineRed(String text) {
        System.out.printf("%s%s%s\n", RED, text, RESET);
    }
    
    /**
     * Muestra texto en color rojo sin salto de línea.
     *
     * @param text mensaje a mostrar
     */
    public void writeRed(String text) {
        System.out.printf("%s%s%s", RED, text, RESET);
    }
    
    /**
     * Muestra texto en color blanco con fonda blanco y salto de linea
     *
     * @param text mensaje a mostrar
     */
    public void writeLineWhite(String text) {
        System.out.printf("%s%s%s%s\n", RED_BACKGROUND, WHITE, text, RESET);
    }
    
    /**
     * Muestra un mensaje resaltado dentro de un recuadro visual.
     *
     * @param text mensaje a mostrar
     */
    public void writeSquareBlack(String text) {
    	System.out.printf("\n%s%s==============\n", WHITE, BLACK_BACKGROUND);
        System.out.printf("%s\n", text );
        System.out.printf("==============%s\n", RESET);
    }
    
    /**
     * Lee un número entero desde consola validando errores de formato.
     *
     * @return número entero introducido
     */
	public int readInt() {
		int value = 0;
		boolean error;
	
		do {
			try {
				value = keyboard.nextInt();
				error = false;
			} catch (InputMismatchException e) {
				writeLineRed("¡Error! Eso no es un número entero\n");
				error = true;
			} finally {
				cleanInput();
			}
		} while (error);
	
		return value;
	}
	
    /**
     * Lee un número entero dentro de un rango específico.
     *
     * @param lowerBound valor mínimo permitido
     * @param upperBound valor máximo permitido
     * @return número entero válido dentro del rango
     */
	public int readIntInRange(int lowerBound, int upperBound) {
		int value;
		do {
			value = readInt();
			if (value < lowerBound || value > upperBound) {
				writeLineRed(
					    String.format("¡Error! El número debe estar entre %d y %d", lowerBound, upperBound)
					);
			}
		} while (value < lowerBound || value > upperBound);
		return value;
	}
	
	/**
	 * Lee un número entero con la condición de ser mayor que un límite inferior dado.
	 *
	 * @param lowerBound límite inferior exclusivo que debe superar el número introducido
	 * @return un número entero mayor que {@code lowerBound}
	 */
	public int readIntGreaterThan(int lowerBound) {
		int value;
		do {
			value = readInt();
			if (value <= lowerBound) {
				System.err.printf("¡Error! El número debe ser mayor que %d\n", lowerBound);
			}
		} while (value <= lowerBound);
		return value;
	}
	
    /**
     * Lee una cadena de texto desde consola.
     *
     * @return texto introducido
     */
	public String readString() {
		return keyboard.nextLine();
	}
	
    /**
     * Lee una cadena de texto no vacía.
     *
     * @return texto válido
     */
	public String readStringNonEmpty() {
		String input;
		do {
			input = readString().trim();
			if (input.isEmpty()) {
				writeLineRed("¡Error! No puedes dejarlo vacío.");
			}
		} while (input.isEmpty());
		return input;
	}
	
    /**
     * Lee un único carácter desde consola.
     *
     * @return carácter introducido
     */
	public char readChar() {
	    String input;

	    do {
	        input = keyboard.nextLine();
	        if (input.length() != 1) {
	        	writeLineRed("¡Error! Debes introducir solo un carácter.");
	        }
	    } while (input.length() != 1);

	    return input.charAt(0);
	}
	
    /**
     * Interpreta un carácter como valor booleano.
     * Permite definir caracteres personalizados para sí/no.
     *
     * @param affirmativeValue carácter para respuesta afirmativa
     * @param negativeValue carácter para respuesta negativa
     * @return true si la respuesta es afirmativa
     */
	public boolean readBooleanUsingChar (char affirmativeValue, char negativeValue) {
		char c;
		
		do {
			c = readChar();
			c = Character.toLowerCase(c);
			
			if (c != Character.toLowerCase(affirmativeValue) && c != Character.toLowerCase(negativeValue)) {
				writeLineRed(
					    String.format(
					        "¡Error! Introduce un carácter válido.\n\"%c\" para sí o \"%c\" para no: ",
					        affirmativeValue,negativeValue)
				);
			}
		} while (c != Character.toLowerCase(affirmativeValue) && c != Character.toLowerCase(negativeValue));
		
		return c == Character.toLowerCase(affirmativeValue);
	}
}
