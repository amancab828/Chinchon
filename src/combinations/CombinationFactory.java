package combinations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cards.Card;

public class CombinationFactory {
    
	// Calcula puntos de la mano
	public int calculatePoints(List<Card> hand, List<Combination> combinations) {

	    Set<Card> used = new HashSet<>();

	    for (Combination c : combinations) {
	        used.addAll(c.getCards());
	    }

	    int points = 0;

	    for (Card card : hand) {
	        if (!used.contains(card)) {
	            points += card.getValue();
	        }
	    }

	    return points;
	}
    
    // Lista de las mejores combinaciones
	public List<Combination> getBestCombinations(List<Card> hand) {

	    List<Combination> all = findCombinations(hand);

	    List<Combination> best = new ArrayList<>();
	    int minPoints = Integer.MAX_VALUE;

	    int n = all.size();

	    // 2^n combinaciones posibles de elegir combinaciones
	    for (int mask = 0; mask < (1 << n); mask++) {

	        List<Combination> current = new ArrayList<>();
	        boolean valid = true;

	        Set<Card> used = new HashSet<>();

	        for (int i = 0; i < n; i++) {

	            if ((mask & (1 << i)) != 0) {

	                Combination c = all.get(i);

	                // comprobar solapamiento
	                for (Card card : c.getCards()) {
	                    if (used.contains(card)) {
	                        valid = false;
	                        break;
	                    }
	                }

	                if (!valid) break;

	                current.add(c);
	                used.addAll(c.getCards());
	            }
	        }

	        if (!valid) continue;

	        int points = calculatePoints(hand, current);

	        if (points < minPoints) {
	            minPoints = points;
	            best = new ArrayList<>(current);
	        }
	    }

	    return best;
	}
	
	private List<Combination> findCombinations(List<Card> hand) {

	    List<Combination> result = new ArrayList<>();

	    for (int size = 3; size <= hand.size(); size++) {
	        generateCombinations(hand, 0, size, new ArrayList<>(), result);
	    }

	    return result;
	}
	
	private void generateCombinations(List<Card> hand, int start, int size, List<Card> current, List<Combination> result) {

		if (current.size() == size) {
			
			for (CombinationType type : CombinationType.values()) {
			
				if (type == CombinationType.CHINCHON && size != 7) continue;
				
				Combination c = new Combination(new ArrayList<>(current), type);
				
				if (c.isValid()) {
					result.add(c);
				}
			}
			return;
		}
		
		for (int i = start; i < hand.size(); i++) {
			current.add(hand.get(i));
			generateCombinations(hand, i + 1, size, current, result);
			current.remove(current.size() - 1);
		}
	}
}