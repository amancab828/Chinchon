# Diseño del sistema
El proyecto se ha desarrollado siguiendo un enfoque orientado a objetos, con el objetivo de separar claramente las responsabilidades de cada componente del juego.

Se usa una arquitectura modular, en la que las distintas funcionalidades se organizan en diferentes paquetes, clases y métodos. Esta separación permite mejorar la mantenibilidad del código, facilitar su escalabilidad y favorecer una mayor claridad en la estructura general del sistema.

---
# Estructura
La arquitectura del sistema se divide en varios paquetes, cada uno encargado de una responsabilidad específica dentro del dominio del juego. Esta organización modular sigue los principios de separación de responsabilidades y bajo acoplamiento, favoreciendo la mantenibilidad, reutilización y escalabilidad del código.
`src`

`└── app`

`│   └── Main`

`│`

`└── cards`

`│   ├── Card`

`│   ├── Suit (enum)`

`│   └── Deck`

`│`

`└── combinations`

`│   ├── CombinationRule (interface)`

`│   ├── Combination`

`│   └── CombinationType (enum)`

`│`

`└── game`

`│   ├── Game`

`│   └── Round`

`│   └── Configuration`

`│`

`└── player`

`│   ├── Player (interface)`

`│   ├── AbstractPlayer`

`│   │   ├── HumanPlayer`

`│   │   └── AIPlayer`

`│`

`└── ai`

`│   ├── AIStrategy (interface)`

`│   └── Strategy`

`│   ├── (posible) EstrategiaBasica`

`│   └── (posible) EstrategiaChinchon`

`│`

`└── ui`

    `├── ConsoleInput`
    
    `└── Menu`

---
## Paquete cards
* Clase Card --> (Carta)
* Enum Suit --> (Palo)
* Clase Deck --> (Baraja)
---
## Paquete combinations
* Interfaz CombinationRule --> (ReglaCombinacion)
* Clase Combination implements CombinationRule --> (Combinacion)
* Enum CombinationType --> (TipoCombinacion)
---
## Paquete game
* Clase Game --> (Partida)
* Clase Round --> (Ronda)
* Clase Configuration --> (Configuracion)
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
## Paquete ui
* Clase Colors
* Clase ConsoleInput
* Clase Menu
---
## Paquete app
* Clase Main