package players;

import cards.Card;
import cards.Deck;
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
		console.escribirLinea("Tus cartas:");
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
		console.escribir("¿Quieres plantarte/cerrar la ronda? (s/n): ");
		// Calcular puntos de la mano y ver si puede plantarse
		return console.readBooleanUsingChar('s', 'n');
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
