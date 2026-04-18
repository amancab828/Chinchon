# Diseño del sistema
El proyecto se ha desarrollado siguiendo un enfoque orientado a objetos, con el objetivo de separar claramente las responsabilidades de cada componente del juego.

Se usa una arquitectura modular, en la que las distintas funcionalidades se organizan en diferentes paquetes, clases y métodos. Esta separación permite mejorar la mantenibilidad del código, facilitar su escalabilidad y favorecer una mayor claridad en la estructura general del sistema.

---
# Estructura
---
## Paquete cards
* Clase Card --> (Carta)
* Enum Suit --> (Palo)
* Clase Deck --> (Baraja)
---
## Paquete combinations
* Interfaz CombinationRule --> (ReglaCombinacion)
* Clase Combination --> (Combinacion)
* Enum CombinationType --> (TipoCombinacion)
---
## Paquete game
* Clase Game --> (Partida)
* Clase Round --> (Ronda)
---
## Paquete player
* Interfaz Player (Jugador)
* Clase AbstractPlayer implements Player --> (JugadorAbstracto)
* Clase HumanPlayer extends AbstractPlayer --> (JugadorHumano)
* Clase AIPlayer extends AbstractPlayer --> (JugadorIA)
---
## Paquete ai
* Interfaz AIStrategy --> (EstrategiaIA)
* Clase Strategy implements AIStrategy --> (Estrategia) 
	-- Se usa como atributo en JugadorIA y es quien decide lo que hace

> Si tengo tiempo se podría añadir o alguna otra: 
>    -  Clase EstrategiaBasica    
>    -  Clase EstrategiaChinchon

---
## Paquete utils
* Clase CombinationManager --> (GestorCombinaciones)
* Clase ScoreCalculator --> (CalculadoraPuntos)
* Clase MoveValidator --> (ValidarJugada)
---
## Paquete ui
* Clase ConsoleInput
* Clase Menu
---
## Paquete main
* Clase Main