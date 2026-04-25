package players;

import java.util.List;

import cards.Card;
import cards.Deck;
import combinations.Combination;
import combinations.CombinationFactory;
import games.Round;
import ui.ConsoleInput;

// Jugador humano
public class HumanPlayer extends AbstractPlayer {
	
	ConsoleInput console = ConsoleInput.getInstance();
	
	public HumanPlayer(String name) {
		super(name);
	}

	// TURNO DE ROBAR
	private Card turnDraw(Deck deck) {
		Card drawCard = null;
		int option;
		console.escribirLinea(String.format("==== Mano de %s ====", name));
		console.escribirLinea(seeHand());
		console.escribirLinea("¿De dónde quieres robar? 1) Mazo  2) Descarte");
		option = console.readIntInRange(1, 2);
		switch (option) {
			case 1 -> drawCard = deck.drawCard();
			case 2 -> drawCard = deck.drawDiscardPile();
			default -> console.escribir("Opción no válida.");
		}
		
		console.escribirLinea(String.format("Has robado: %s", drawCard.toString()));
		return drawCard;
	}
	
	// TURNO DE DESCARTAR
	private void turnDiscard(Deck deck) {
		int drawOption;
		Card discardCard = null;

		console.escribirLinea("Tu mano (8 cartas):");
		console.escribirLinea(seeHand());
		console.escribir("Elige carta a descartar (1-8): ");
		
		drawOption = console.readIntInRange(1, 8);
		discardCard = hand.get(drawOption - 1);

		// Añadir la carta al descarte
		deck.discard(discardCard);
		// Eliminar la carta de la mano
		discardCard(discardCard);
		
		console.escribirLinea(String.format("Has descartado: %s", discardCard.toString()));
	}
	
	// PREGUNTAMOS SI SE PLANTA
	private boolean turnStand() {
		CombinationFactory factory = new CombinationFactory();
		List<Combination> combinations;
		boolean stand;
		console.escribir("¿Quieres plantarte/cerrar la ronda? (s/n): ");
		// Calcular puntos de la mano y ver si puede plantarse
		stand = console.readBooleanUsingChar('s', 'n');
		
		if (stand) {
			combinations = factory.getBestCombinations(hand);
			if (factory.calculatePoints(hand, combinations) > 5) {
				console.escribirLinea("Tienes que puntuar 5 puntos o menos para poder plantarte");
				stand = false;
			}
			if (getTurn() == 1) {
				console.escribirLinea("No te puede plantar en el primer turno");
				stand = false;
			}
		}
		
		setTurn(getTurn()+1);
		
		return stand;
	}
	
	// Lógica del turno del jugador humano
	@Override
	public void playTurn(Round round) {
		receiveCard(turnDraw(round.getDeck()));
		turnDiscard(round.getDeck());
		if (turnStand()) {
			round.setRoundOver();
		}
	}
}
