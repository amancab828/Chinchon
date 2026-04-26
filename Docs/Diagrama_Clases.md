# Diagrama de Clases

El diagrama de clases representa la estructura del sistema, mostrando las relaciones entre clases y la organización de los principales componentes del juego.  
También se detallan los atributos y métodos más significativos, lo que permite comprender el comportamiento de cada clase y su interacción dentro del sistema.

---

## Paquete `cards`

### Clase `Card`
- Clase que representa, palo y valor numérico. 
- Incluye métodos para su visualización por consola
- Necesita implementar los métodos de hashCode() y equals () para poder distinguir las cartas de las distintas barajas (atributo id:int)
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
- Se encarga de la validación de cada tipo de combinación
- [Ver código](../src/combinations/Combination.java)
### Clase `CombinationSolver`
- Es la clase encargada de generar, evaluar y seleccionar las mejores combinaciones de cartas
- Es la clase más compleja
- [Ver código](../src/combinations/CombinationSolver.java)
### Enum `CombinationType`
- Representa los tres tipos de combinaciones que hay en el juego
- [Ver código](../src/combinations/CombinationType.java)

---

## Paquete `games`

### Clase `Game`
- Representa una partida del juego Chinchón por completo, controla el flujo, rondas, jugadores...
- [Ver código](../src/games/Game.java)

### Clase `Round`
- Es una ronda dentro de una partida
- Se encarga de gestionar el reparto de cartas, turnos...
- [Ver código](../src/games/Round.java)

### Clase `Configuration`
- Encargada de configurar la partida, pidiendo los datos al usuario. 
- Usa el patron Factory, no sabiendo si crea un humano o IA, delega esta responsabilidad
- [Ver código](../src/games/Configuration.java)

---

## Paquete `players`

### Interfaz `Player`
- Interfaz que deben cumplir todos los jugadores IA o humanos
- [Ver código](../src/players/Players.java)

### Clase `AbstractPlayer`
- Clase padre, con métodos comunes y abstracta
- Implementa la interfaz Player
- [Ver código](../src/players/AbstractPlayer.java)

### Clase `HumanPlayer`
- Hereda de AbstractPlayer
- Representa a un humano
- [Ver código](../src/players/HumanPlayer.java)

### Clase `AIPlayer`
- Hereda de AbstractPlayer
- Representa a una IA, esta usa Strategy para tomar las decisiones
- [Ver código](../src/players/AIPlayer.java)

### Clase PlayerFactory
- Fábrica encargada de crear instancias de jugadores
- Implementa el patrón Factory para abstraer la creación
- [Ver código](../src/players/PlayerFactory.java)

---

## Paquete `ai`

### Interfaz `AIStrategy`
- Pertenece al paquete `ai`
- Define los métodos necesarios para cualquier estrategia de IA
- [Ver código](../src/ai/AIStrategy.java)

### Clase `Strategy`
- Pertenece al paquete `ai`
- Implementa la interfaz AIStrategy
- Se usa como atributo en `AIPlayer` y decide el comportamiento
- [Ver código](../src/ai/Strategy.java)

>  **Posibles mejoras futuras**
> - Clase `HardStrategy`

---

## Paquete `ui`

### Clase `Colors`
- Define constantes con los colores ANSI
- [Ver código](../src/ui/Colors.java)

### Clase `ConsoleInput`
- Se encarga de gestionar la entrada y salida por consola
- Se implementa el patrón Singleton, para asegurar una única instancia
- [Ver código](../src/ui/ConsoleInput.java)

### Clase `Menu`
- Encargada de mostrar la interfaz principal del juego en consola
- [Ver código](../src/ui/Menu.java)

---

## Paquete `app`

### Clase `Main`
- Clase principal que inicia la aplicación y controla el flujo del menú del juego
- [Ver código](../src/app/Main.java)