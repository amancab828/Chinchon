package combinations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cards.Card;

/**
 * Factoría encargada de generar, evaluar y seleccionar las mejores combinaciones de cartas.
 * Es la clase más compleja y la IA actual Strategy se centra en en usar esta clase
 *
 * Se encarga de:
 * - Generar todas las combinaciones posibles mediante backtracking
 * - Validar combinaciones según las reglas del juego
 * - Calcular la mejor configuración de cartas minimizando puntos
 */
public class CombinationSolver {
    
	/**
	 * Calcula los puntos de una mano descontando las cartas usadas en combinaciones.
	 *
	 * @param hand mano del jugador
	 * @param combinations combinaciones seleccionadas
	 * @return puntos restantes en la mano
	 */
	public int calculatePoints(List<Card> hand, List<Combination> combinations) {
		int points = 0;
		Set<Card> used;
		
		// Set evita duplicados,de esta manera evitamos cartas duplicadas
	    used = new HashSet<>();
	    for (Combination c : combinations) {
	        used.addAll(c.getCards());
	    }

	    // Recorremos todas las cartas de la mano, si no esta en used, puntua
	    for (Card card : hand) {
	        if (!used.contains(card)) {
	            points += card.getValue();
	        }
	    }

	    return points;
	}
	
	/**
	 * Devuelve la mejor combinación posible de la mano (la que minimiza puntos).
	 *
	 * @param hand mano del jugador
	 * @return lista de combinaciones óptimas
	 */
	public List<Combination> getBestCombinations(List<Card> hand) {
	    List<Combination> all = findCombinations(hand);
	    List<Combination> best = new ArrayList<>();

	    backtrack(all, 0, new ArrayList<>(), new HashSet<>(), hand, best);

	    return best;
	}
	
	/**
	 * Algoritmo de backtracking que selecciona el subconjunto óptimo de combinaciones
	 * sin solapamiento de cartas, minimizando la puntuación final.
	 *
	 * @param all lista de todas las combinaciones posibles generadas
	 * @param index índice actual de exploración en la lista de combinaciones
	 * @param current combinaciones seleccionadas en el estado actual
	 * @param used conjunto de cartas ya utilizadas en combinaciones
	 * @param hand mano original del jugador
	 * @param best mejor conjunto de combinaciones encontrado hasta el momento
	 * @return puntuación mínima obtenida (el return int lo hacemos para la recursividad, lo que queremos obtener es la modificacion de best)
	 */
	private int backtrack(List<Combination> all,
            int index,
            List<Combination> current,
            Set<Card> used,
            List<Card> hand,
            List<Combination> best) {
		
		int result, points, bestPoints, candidate;
		Combination combination;
		boolean duplication;
		
		// Caso base
		if (index == all.size()) {
		
			points = calculatePoints(hand, current);
			
			// Si es la mejor solución o estaba vacio, guardamos
			if (best.isEmpty() || points < calculatePoints(hand, best)) {
			  best.clear();
			  best.addAll(current);
			}
			
			result = points;
		
		} else {
			
			// De momento tenemos esto, vamos a ver si hay alguna combinacion más a añadir
			bestPoints = backtrack(all, index + 1, current, used, hand, best);
			
			// Ahora vemos si la siguiente combinacion no comparte cartas
			combination = all.get(index);
			
			// Comprobamos si hay solapamiento (carta repetida)
			duplication = false;
			for (Card c : combination.getCards()) {
			    if (used.contains(c)) {
			        duplication = true;
			    }
			}
			
			// Si no hay cartas repetidas
			if (!duplication) {
				//Añadimos la combinacion y las cartas usadas
			    current.add(combination);
			    used.addAll(combination.getCards());
			    
			    // Obtenemos una nueva puntuacion
			    candidate = backtrack(all, index + 1, current, used, hand, best);
			    if (candidate < bestPoints) {
			        bestPoints = candidate;
			    }
			
			    // Quitamos esta combinación y estas cartas usadas para probar otra combinacion
			    // Como son direcciones de memoria al siguiente caso recursivo esto le afecta
			    current.remove(current.size() - 1);
			    used.removeAll(combination.getCards());
			}
			
			result = bestPoints;
		}
		
		// Este return la primera vez que llega, no sale del método. Si no que termina la primera recursión
		return result;
	}
	
	/**
	 * Genera todas las combinaciones posibles de cartas de la mano usando el metodo generateCombinations
	 *
	 * @param hand mano del jugador
	 * @return lista de combinaciones generadas
	 */
	private List<Combination> findCombinations(List<Card> hand) {

	    List<Combination> result = new ArrayList<>();

	    // Las combinaciones son como mínimo de 3 cartas
	    for (int size = 3; size <= hand.size(); size++) {
	    	// Vamos añadiendo todas las combinaciones posibles en result
	        generateCombinations(hand, 0, size, new ArrayList<>(), result);
	    }

	    return result;
	}
	
	/**
	 * Genera combinaciones de cartas mediante backtracking+recursividad
	 *
	 *<p>
	 *	- Entre start, size y current se prueban todas las combinaciones
	 *  - Visualización del árbol de exploracion para entender el bucle de backtraking recursivo
	 *  	   []
	 *         ├── [A]
	 *         │   ├── [A,B]
	 *         │   │   ├── [A,B,C]
	 *         │   │   └── [A,B,D]
	 *         │   └── [A,C]
	 *         │       └── [A,C,D]
	 *         └── [B]
	 *             └── [B,C]
	 *  - Cada rama representa una combinación parcial.
	 *  - Cuando una rama alcanza el tamaño deseado, se valida.
	 *  - Después se retrocede (backtracking) para explorar nuevas ramas.
	 *</p>
	 *
	 * @param hand referencia de la mano original del jugador
	 * @param start índice de inicio para evitar repeticiones
	 * @param size tamaño objetivo de la combinación
	 * @param current combinación parcial en construcción
	 * @param result lista donde se almacenan combinaciones válidas siendo el objetivo del metodo (se modifica constantemente)
	 */
	
	private void generateCombinations(List<Card> hand, int start, int size, List<Card> current, List<Combination> result) {

		// Este es el caso base, cuando ya tengo una combinacion del tamaño que quiero
		// Como se llama desde un bucle, se empieza con tamaño 3,4,5,6...
		if (current.size() == size) {
			// Todas los posibles tipos combinaciones
			for (CombinationType type : CombinationType.values()) {
			
				// Esta condicion es para evitar hacer CHINCHON con 3,4,5... cartas
			    if (type != CombinationType.CHINCHON || size == 7) {
			    	// Creamos la combinacion y probamos si es valida
			        Combination c = new Combination(new ArrayList<>(current), type);

			        if (c.isValid()) {
			            result.add(c);
			        }
			    }
			}
		} else {
			// El objetivo de este bucle  es generar todas las combinaciones posibles sin repetirse
			// Nucleo del backtracking
			for (int i = start; i < hand.size(); i++) {
				// Añadimos la carta actual
				current.add(hand.get(i));
				
				// LLamada recursiva, con esta carta añadida
				generateCombinations(hand, i + 1, size, current, result);
				
				// Backtraking, quitamos la ultima carta añadida
				current.remove(current.size() - 1);
			}
			
		}
	}	
}