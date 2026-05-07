package combinations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import cards.Card;
import cards.Suit;

class CombinationSolverTest {
	
	// Método auxiliar para crear cartas con ID único
	int nextId = 10000;
	Card c(Suit suit, int value) {
		return new Card(suit, value, nextId++);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 5, 10})
	void calculatePoints_onlyCardsNotUsed(int value) {
		CombinationSolver solver = new CombinationSolver();
		
		Card a = c(Suit.COINS, 4);
		Card b = c(Suit.CUPS, 4);
		Card d = c(Suit.SWORDS, 4);
		Card extra = c(Suit.CLUBS, value);
		
		List<Card> hand = List.of(a, b, d, extra);
		List<Combination> best = solver.getBestCombinations(hand);
		
		assertEquals(value, solver.calculatePoints(hand, best));
	}
	
	@Test
	void getBestCombinations_checkSetStraight() {
		CombinationSolver solver = new CombinationSolver();
		
		// SET de 6s + escalera 10-11-12 (espadas) => 0 puntos
		List<Card> hand = List.of(
			c(Suit.COINS, 6),
			c(Suit.CUPS, 6),
			c(Suit.CLUBS, 6),
			c(Suit.SWORDS, 10),
			c(Suit.SWORDS, 11),
			c(Suit.SWORDS, 12)
		);
		
		List<Combination> best = solver.getBestCombinations(hand);
		
		assertEquals(0, solver.calculatePoints(hand, best));
	}
	
	@Test
	void getBestCombinations_checkStraight() {
		CombinationSolver solver = new CombinationSolver();
		// Regla especial baraja española: 7 -> 10 es consecutivo
		List<Card> hand = List.of(
			c(Suit.COINS, 5),
			c(Suit.COINS, 6),
			c(Suit.COINS, 7),
			c(Suit.COINS, 10),
			c(Suit.COINS, 11)
		);
		
		List<Combination> best = solver.getBestCombinations(hand);
		
		assertEquals(0, solver.calculatePoints(hand, best));
	}
	
	@Test
	void getBestCombinations_checkChinchon() {
		CombinationSolver solver = new CombinationSolver();
		
		List<Card> hand = List.of(
			c(Suit.CUPS, 1),
			c(Suit.CUPS, 2),
			c(Suit.CUPS, 3),
			c(Suit.CUPS, 4),
			c(Suit.CUPS, 5),
			c(Suit.CUPS, 6),
			c(Suit.CUPS, 7)
		);
		
		List<Combination> best = solver.getBestCombinations(hand);
		
		assertEquals(0, solver.calculatePoints(hand, best));
	}

}
