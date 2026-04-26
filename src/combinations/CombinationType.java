package combinations;

/**
 * Tipos de combinaciones posibles en el juego.
 *
 * SET: conjunto de cartas con el mismo valor.
 * STRAIGHT: escalera de cartas consecutivas del mismo palo.
 * CHINCHON: escalera completa de 7 cartas del mismo palo.
 */
public enum CombinationType {
	SET, //Conjunto de iguales
	STRAIGHT, //Escalera
	CHINCHON
}
