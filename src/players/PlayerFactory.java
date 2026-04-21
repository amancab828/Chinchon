package players;
import ai.Strategy;

public class PlayerFactory {
    public Player createPlayer(String name, boolean isHuman) {
		if (isHuman) {
			return new HumanPlayer(name);
		} else {
			return new AIPlayer("IA_" + name, new Strategy());
		}
    }
}
