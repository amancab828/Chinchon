package players;

import ai.Strategy;

/**
 * Fábrica encargada de crear instancias de jugadores.
 * Implementa el patrón Factory para abstraer la creación
 * de jugadores humanos o controlados por inteligencia artificial.
 *
 * Permite desacoplar la lógica de creación del resto del sistema.
 */
public class PlayerFactory {
    /**
     * Crea un jugador según el tipo indicado.
     *
     * @param name nombre del jugador
     * @param isHuman true si el jugador es humano, false si es IA
     * @return instancia del jugador correspondiente
     */
    public Player createPlayer(String name, boolean isHuman) {
		if (isHuman) {
			return new HumanPlayer(name);
		} else {
			return new AIPlayer("IA_" + name, new Strategy());
		}
    }
}
