package ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import static ui.Colors.*;

// Añadir como libreria mejor, o no hace falta??
public class ConsoleInput {
	private static ConsoleInput instance;
    private Scanner keyboard;

    public ConsoleInput(Scanner keyboard) {
        this.keyboard = keyboard;
    }
    
    // Única instancia de ConsoleInput
    public static ConsoleInput getInstance() {
		if (instance == null) {
			instance = new ConsoleInput(new Scanner(System.in));
		}
		return instance;
	}
    
    // Limpiar el teclado
    private void cleanInput() {
        keyboard.nextLine();
    }
    
    // Cerrar el teclado
    public void cerrar() {
    	keyboard.close();
    }
    
    public void escribirLinea(String texto) {
        System.out.println(texto);
    }
    public void escribir(String texto) {
        System.out.print(texto);
    }
    public void escribirLineaRojo(String texto) {
        System.out.printf("%s%s%s\n", RED, texto, RESET);
    }
    public void escribirRojo(String texto) {
        System.out.printf("%s%s%s", RED, texto, RESET);
    }
    
	// Retorna un int introducido por el usuario
	public int readInt() {
		int value = 0;
		boolean error;
	
		do {
			try {
				value = keyboard.nextInt();
				error = false;
			} catch (InputMismatchException e) {
				escribirLineaRojo("¡Error! Eso no es un número entero\n");
				error = true;
			} finally {
				cleanInput();
			}
		} while (error);
	
		return value;
	}
	
	// Retorna un int introducido por el usuario cuyo valor esté en el rango [lowerBound, upperBound], ambos incluidos
	public int readIntInRange(int lowerBound, int upperBound) {
		int value;
		do {
			value = readInt();
			if (value < lowerBound || value > upperBound) {
				escribirLineaRojo(
					    String.format("¡Error! El número debe estar entre %d y %d", lowerBound, upperBound)
					);
			}
		} while (value < lowerBound || value > upperBound);
		return value;
	}
	
	// Retorna una cadena de caracteres introducida por el usuario
	public String readString() {
		return keyboard.nextLine();
	}
	
	// Retorna una cadena que no puede ser vacia
	public String readStringNonEmpty() {
		String input;
		do {
			input = readString().trim();
			if (input.isEmpty()) {
				escribirLineaRojo("¡Error! No puedes dejarlo vacío.");
			}
		} while (input.isEmpty());
		return input;
	}
	
	// Retorna un carácter introducido por el usuario. Si éste introduce más de un carácter, se le vuelve a solicitar
	public char readChar() {
	    String input;

	    do {
	        input = keyboard.nextLine();
	        if (input.length() != 1) {
	        	escribirLineaRojo("¡Error! Debes introducir solo un carácter.");
	        }
	    } while (input.length() != 1);

	    return input.charAt(0);
	}
	
	/* Retorna un booleano a partir de un carácter introducido por el usuario, de manera que si coincide con affirmativeValue 
	(en mayúsculas o minúsculas) retornará true y si coincide con negativeValue (en mayúsculas o minúsculas), retornará false */
	public boolean readBooleanUsingChar (char affirmativeValue, char negativeValue) {
		char c;
		
		do {
			c = readChar();
			c = Character.toLowerCase(c);
			
			if (c != Character.toLowerCase(affirmativeValue) && c != Character.toLowerCase(negativeValue)) {
				escribirLineaRojo(
					    String.format(
					        "¡Error! Introduce un carácter válido.\n\"%c\" para sí o \"%c\" para no: ",
					        affirmativeValue,negativeValue)
				);
			}
		} while (c != Character.toLowerCase(affirmativeValue) && c != Character.toLowerCase(negativeValue));
		
		return c == Character.toLowerCase(affirmativeValue);
	}
}
