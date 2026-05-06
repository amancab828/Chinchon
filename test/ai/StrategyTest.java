package ai;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import cards.Card;
import cards.Deck;
import cards.Suit;

class StrategyTest {
	
	// Método auxiliar para crear cartas con ID único
	int nextId = 10000;
	Card c(Suit suit, int value) {
		return new Card(suit, value, nextId++);
	}

    @ParameterizedTest
    @ValueSource(ints = {6, 12, 11})
	void turnDraw_drawDiscard(int value) {
		Strategy strategy = new Strategy();
		Deck deck = new Deck(1);
		Card draw, discardTop;
		List<Card> hand = List.of(
				c(Suit.COINS, 6),
				c(Suit.CUPS, 6),
				c(Suit.SWORDS, 12),
				c(Suit.CLUBS, 12),
				c(Suit.SWORDS, 11),
				c(Suit.CLUBS, 11),
				c(Suit.COINS, 10)
			);
		
		// Creamos la carta para la prueba y la descartamos
		discardTop = c(Suit.CLUBS, value);
		deck.discard(discardTop);

		// La estrategia debería elegir robar del descarte porque mejora la mano
		draw = strategy.turnDraw(deck, hand);

		assertEquals(discardTop, draw);
	}
	
    @ParameterizedTest
    @ValueSource(ints = {10, 12, 11})
	void turnDraw_drawDeck(int value) {
		Strategy strategy = new Strategy();
		Deck deck = new Deck(1);
		Card draw, discardTop;		
		List<Card> hand = List.of(
			c(Suit.COINS, 1),
			c(Suit.CUPS, 2),
			c(Suit.SWORDS, 3),
			c(Suit.CLUBS, 4),
			c(Suit.COINS, 5),
			c(Suit.CUPS, 6),
			c(Suit.SWORDS, 7)
		);
		
		// Creamos la carta para la prueba y la descartamos
		discardTop = c(Suit.CLUBS, value);
		deck.discard(discardTop);

		// La estrategia debería elegir robar del mazo porque no mejora la mano
		draw = strategy.turnDraw(deck, hand);
		
		assertNotEquals(discardTop, draw);
	}
	
    /**
     * Caja blanca, porque estoy forzando la condición:
     * (pts < bestPoints || (pts == bestPoints && card.getValue() > best.getValue())
     * 
     */
    @ParameterizedTest
    @ValueSource(ints = {7, 2, 5}) // Son cartas que no ayudan en la mano de ejemplo
	void turnDiscard_minPoints(int value) {
		Strategy strategy = new Strategy();
		Card discard;
		Card extra = c(Suit.COINS, value);
		List<Card> hand = List.of(
			c(Suit.COINS, 6),
			c(Suit.CUPS, 6),
			c(Suit.CLUBS, 6),
			c(Suit.SWORDS, 10),
			c(Suit.SWORDS, 11),
			c(Suit.SWORDS, 12),
			c(Suit.SWORDS, 1),
			extra
		);
		
		discard = strategy.turnDiscard(new ArrayList<>(hand));
		
		assertEquals(extra, discard);
	}
	
	@Test
	void turnStand_returnsTrue() {
		Strategy strategy = new Strategy();
		
		// Esta mano puede formar un SET de 4s y una escalera 2-3-4-5 (oros)
		List<Card> hand = List.of(
			c(Suit.COINS, 2),
			c(Suit.COINS, 3),
			c(Suit.COINS, 4),
			c(Suit.CUPS, 4),
			c(Suit.SWORDS, 4),
			c(Suit.CLUBS, 4),
			c(Suit.COINS, 5)
		);
		
		assertTrue(strategy.turnStand(hand, 3));
	}
	
	@Test
	void turnStand_returnsFalse() {
		Strategy strategy = new Strategy();
		
		List<Card> hand = List.of(
			c(Suit.COINS, 7),
			c(Suit.CUPS, 12),
			c(Suit.SWORDS, 11),
			c(Suit.CLUBS, 10),
			c(Suit.COINS, 5),
			c(Suit.CUPS, 6),
			c(Suit.SWORDS, 3)
		);
		
		assertFalse(strategy.turnStand(hand, 3));
	}

}
