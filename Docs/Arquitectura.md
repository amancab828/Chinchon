# Diseño del sistema
El proyecto se ha desarrollado siguiendo un enfoque orientado a objetos, con el objetivo de separar claramente las responsabilidades de cada componente del juego.

Se usa una arquitectura modular, en la que las distintas funcionalidades se organizan en diferentes paquetes, clases y métodos. Esta separación permite mejorar la mantenibilidad del código, facilitar su escalabilidad y favorecer una mayor claridad en la estructura general del sistema.

---
# Estructura del Proyecto  
  
La arquitectura del sistema se divide en varios paquetes, cada uno encargado de una responsabilidad específica dentro del dominio del juego.  
Esta organización sigue principios como:  
  
- Separación de responsabilidades  
- Bajo acoplamiento  
- Alta cohesión  
  
Lo que favorece la mantenibilidad, reutilización y escalabilidad del código.  
  
### Estructura de directorios
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

`│   ├── Combination`

`│   └── CombinationType (enum)`

`│`

`└── games`

`│   ├── Game`

`│   └── Round`

`│   └── Configuration`

`│`

`└── players`

`│   ├── Player (interface)`

`│   ├── PlayerFactory`

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

---

# Descripción de Paquetes

## Paquete `cards`
Encargado de representar los elementos básicos de la baraja.

- **Clase `Card`** → Representa una carta  
- **Enum `Suit`** → Representa el palo  
- **Clase `Deck`** → Representa la baraja  

---

## Paquete `combinations`
Gestiona la lógica de combinaciones de cartas.

- **Interfaz `CombinationRule`** → Define las reglas de combinación  
- **Clase `Combination`** *(implementa `CombinationRule`)* → Representa una combinación  
- **Enum `CombinationType`** → Define los tipos de combinación  

---

## Paquete `games`
Controla la lógica principal del juego.

- **Clase `Game`** → Representa la partida  
- **Clase `Round`** → Representa una ronda  
- **Clase `Configuration`** → Gestiona la configuración del juego  

---

## Paquete `players`
Define los distintos tipos de jugadores.

- **Interfaz `Player`** → Define el comportamiento de un jugador  
- **Clase `AbstractPlayer`** *(implementa `Player`)* → Base común de jugadores  
- Clase `PlayerFactory` → Se implementa el Patrón Factory
- **Clase `HumanPlayer`** *(hereda de `AbstractPlayer`)* → Jugador humano  
- **Clase `AIPlayer`** *(hereda de `AbstractPlayer`)* → Jugador controlado por IA  

---

## Paquete `ai`
Gestiona la lógica de inteligencia artificial.

- **Interfaz `AIStrategy`** → Define estrategias de decisión  
- **Clase `Strategy`** *(implementa `AIStrategy`)* → Implementación base de estrategia  

 Esta clase se utiliza como atributo en `AIPlayer` y es la encargada de decidir el comportamiento del jugador IA.

>  **Mejoras futuras**
> - `EstrategiaBasica`  
> - `EstrategiaChinchon`  

---

## Paquete `ui`
Encargado de la interacción con el usuario.

- **Clase `Colors`** → Gestión de colores en consola  
- **Clase `ConsoleInput`** → Entrada de datos  
- **Clase `Menu`** → Menú del juego  

---

## Paquete `app`
Punto de entrada de la aplicación.

- **Clase `Main`** → Método principal que inicia el programa  