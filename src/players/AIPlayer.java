package players;

import ai.AIStrategy;
import cards.Card;
import cards.Deck;
import games.Round;
import ui.ConsoleInput;
import combinations.CombinationFactory;

// Jugador de IA
public class AIPlayer extends AbstractPlayer {
    private AIStrategy strategy;
    private ConsoleInput console = ConsoleInput.getInstance();
    private final CombinationFactory factory = new CombinationFactory();

    public AIPlayer(String name, AIStrategy strategy) {
    	super(name);
        this.strategy = strategy;
    }

	// TURNO DE ROBAR
	private Card turnDraw(Deck deck) {
		Card drawCard;
		console.escribirLinea(String.format("==== Mano de %s ====", name));
		console.escribirLinea(seeHand());

        drawCard = strategy.turnDraw(deck, hand);
		
		console.escribirLinea(String.format("%s roba: %s", name, drawCard.toString()));
		return drawCard;
	}
	
	// TURNO DE DESCARTAR
	private void turnDiscard(Deck deck) {
		Card discardCard;
		console.escribirLinea("Mano de la IA (8 cartas):");
		console.escribirLinea(seeHand());
		
		discardCard = strategy.turnDiscard(hand);

		// Añadir la carta al descarte
		deck.discard(discardCard);
		// Eliminar la carta de la mano
		discardCard(discardCard);
		
		console.escribirLinea(String.format("La IA descarta: %s", discardCard.toString()));
	}
	
	// PREGUNTAMOS SI SE PLANTA
	private boolean turnStand() {
		int points;
        boolean stand = strategy.turnStand(hand, getTurn());

        // Validación de reglas
        if (stand) {
            points = factory.calculatePoints(hand, factory.getBestCombinations(hand));
            if (points > 5) {
            	stand = false;
            }
            if (getTurn() == 1) {
            	stand = false;
            }
        }

        setTurn(getTurn() + 1);
        return stand;
	}
	
	// Lógica del turno del jugador humano
	@Override
	public void playTurn(Round round) {
		receiveCard(turnDraw(round.getDeck()));
		turnDiscard(round.getDeck());
		if (turnStand()) {
            console.escribirLinea(String.format("%s cierra la ronda.", name));
			round.setRoundOver();
		}
	}
}
