package games;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import ai.Strategy;
import players.AIPlayer;
import players.Player;

class GameTest {

	@Test
	void getActivePlayers_excludePlayers() {
		List<Player> actives;
		AIPlayer active = new AIPlayer("AI1", new Strategy());
		AIPlayer eliminate = new AIPlayer("AI2", new Strategy());
		
		Game game = new Game(List.of(active, eliminate), 100, 1);
		
		eliminate.setPoints(100);
		actives = game.getActivePlayers();

		assertEquals(1, actives.size());
	}

	@Test
	void startGame_notWinner() {
		AIPlayer p1 = new AIPlayer("AI1", new Strategy());
		AIPlayer p2 = new AIPlayer("AI2", new Strategy());
		Game game = new Game(List.of(p1, p2), 50, 1);
		
		p1.setPoints(50);
		p2.setPoints(50);

		assertTrue(game.startGame().isEmpty());
	}

	@Test
	void startGame_afterChinchon() {
		AIPlayer p1 = new AIPlayer("AI1", new Strategy());
		AIPlayer p2 = new AIPlayer("AI2", new Strategy());
		Game game = new Game(List.of(p1, p2), 50, 1);
		Optional<Player> winner;
		
		game.setChinchonWinner(p1);
		winner = game.startGame();

		assertEquals(Optional.of(p1), winner);
	}
}
