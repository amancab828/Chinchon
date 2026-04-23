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
		// Ver carta oculta, hacemos el dibujo aqui mismo
			  /*┌────┐
				|░░░░|
				|░░░░|
				└────┘*/
		// Y en el otro lado la carta visible, metodo de deck
		console.escribirLinea("¿De dónde quieres robar? 1) Mazo  2) Descarte");
		
		
		console.escribirLinea("Has robado: tal");
		return deck.drawCard();
	}
	
	// TURNO DE DESCARTAR
	private void turnDiscard(Deck deck) {
		// 1-2-3-4-5-6-7-8
		console.escribirLinea("Tu mano (8 cartas):");
		console.escribirLinea(seeHand());
		//elegi una carta a robar
		int drawOption = console.readIntInRange(1, 8);
	}
	
	// PREGUNTAMOS SI SE PLANTA
	private boolean turnStand() {
		boolean stand = true;
		// Preguntar al usuario
		console.readBooleanUsingChar('s', 'n');
		// PUES LO MISMO NO PUEDES EH 
		
		return stand;
	}
	
	// Lógica del turno del jugador humano
	// Es necesario usar el ConsoleInput
	@Override
	public void playTurn(Round round) {
		console.escribirLinea(seeHand());
		turnDraw(round.getDeck());
		turnDiscard(round.getDeck());
		if (turnStand()) {
			round.setRoundOver();
		}
	}
}
