# Diagrama de Clases

El diagrama de clases representa la estructura del sistema, mostrando las relaciones entre clases y la organización de los principales componentes del juego.  
También se detallan los atributos y métodos más significativos, lo que permite comprender el comportamiento de cada clase y su interacción dentro del sistema.

---

## Paquete `cards`

### Clase `Card`
- Clase que representa, palo y valor numérico. 
- Incluye métodos para su visualización por consola
- [Ver código](../src/cards/card.java)

### Enum `Suit`
- Este enum, contiene los 4 palos y dos atributos:
	- Contiene el símbolo (🌿,🍷,⚔️, 🟡)
	- Contiene el color
- [Ver código](../src/cards/suit.java)

### Clase `Deck`
- Representa la baraja del juego, encargada de gestionar el conjunto de cartas disponibles y el montón de descarte.
- Permite crear una o varias barajas españolas, barajarlas, robar cartas y gestionar el flujo de cartas entre la baraja y el descarte.
- Además, controla la regeneración de la baraja cuando esta se queda sin cartas.
- [Ver código](../src/cards/deck.java)

---

## Paquete `combinations`
### Clase `Combination`
- Pertenece al paquete `combinations`
- [Ver código](../src/combinations/Combination.java)

### Enum `CombinationType`
- Pertenece al paquete `combinations`
- [Ver código](../src/combinations/CombinationType.java)

---

## Paquete `games`

### Clase `Game`
- Pertenece al paquete `games`
- [Ver código](../src/games/Game.java)

### Clase `Round`
- Pertenece al paquete `games`
- [Ver código](../src/games/Round.java)

### Clase `Configuration`
- Pertenece al paquete `games`
- [Ver código](../src/games/Configuration.java)

---

## Paquete `players`

### Interfaz `Player`
- Pertenece al paquete `players`
- [Ver código](../src/players/Players.java)

### Clase `AbstractPlayer`
- Pertenece al paquete `players`
- [Ver código](../src/players/AbstractPlayer.java)

### Clase `HumanPlayer`
- Pertenece al paquete `players`
- [Ver código](../src/players/HumanPlayer.java)

### Clase `AIPlayer`
- Pertenece al paquete `players`
- [Ver código](../src/players/AIPlayer.java)

### Clase PlayerFactory
- Pertenece al paquete `players`
- Se usa el patrón Factory
- [Ver código](../src/players/PlayerFactory.java)

---

## Paquete `ai`

### Interfaz `AIStrategy`
- Pertenece al paquete `ai`
- [Ver código](../src/ai/AIStrategy.java)

### Clase `Strategy`
- Pertenece al paquete `ai`
- Se usa como atributo en `AIPlayer` y decide el comportamiento
- [Ver código](../src/ai/Strategy.java)

>  **Posibles mejoras futuras**
> - Clase `EstrategiaBasica`
> - Clase `EstrategiaChinchon`

---

## Paquete `ui`

### Clase `Colors`
- Pertenece al paquete `ui`
- [Ver código](../src/ui/Colors.java)

### Clase `ConsoleInput`
- Pertenece al paquete `ui`
- Aquí se usa el patrón Singleton, para garantizar que la clase tenga una única instancia y proporcionar acceso global
- [Ver código](../src/ui/ConsoleInput.java)

### Clase `Menu`
- Pertenece al paquete `ui`
- [Ver código](../src/ui/Menu.java)

---

## Paquete `app`

### Clase `Main`
- Pertenece al paquete `app`
- [Ver código](../src/app/Main.java)