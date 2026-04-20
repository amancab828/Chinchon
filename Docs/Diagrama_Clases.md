# Diagrama de Clases

El diagrama de clases representa la estructura del sistema, mostrando las relaciones entre clases y la organización de los principales componentes del juego.  
También se detallan los atributos y métodos más significativos, lo que permite comprender el comportamiento de cada clase y su interacción dentro del sistema.

---

## Paquete `cards`

### Clase `Card`
- Pertenece al paquete `cards`
- Ver código

### Enum `Suit`
- Pertenece al paquete `cards`
- Ver código

### Clase `Deck`
- Pertenece al paquete `cards`
- Ver código

---

## Paquete `combinations`

### Interfaz `CombinationRule`
- Pertenece al paquete `combinations`
- Ver código

### Clase `Combination`
- Pertenece al paquete `combinations`
- Ver código

### Enum `CombinationType`
- Pertenece al paquete `combinations`
- Ver código

---

## Paquete `game`

### Clase `Game`
- Pertenece al paquete `game`
- Ver código

### Clase `Round`
- Pertenece al paquete `game`
- Ver código

### Clase `Configuration`
- Pertenece al paquete `game`
- Ver código

---

## Paquete `player`

### Interfaz `Player`
- Pertenece al paquete `player`
- Ver código

### Clase `AbstractPlayer`
- Pertenece al paquete `player`
- Ver código

### Clase `HumanPlayer`
- Pertenece al paquete `player`
- Ver código

### Clase `AIPlayer`
- Pertenece al paquete `player`
- Ver código

---

## Paquete `ai`

### Interfaz `AIStrategy`
- Pertenece al paquete `ai`
- Ver código

### Clase `Strategy`
- Pertenece al paquete `ai`
- Se usa como atributo en `AIPlayer` y decide el comportamiento
- Ver código

>  **Posibles mejoras futuras**
> - Clase `EstrategiaBasica`
> - Clase `EstrategiaChinchon`

---

## Paquete `ui`

### Clase `Colors`
- Pertenece al paquete `ui`
- Ver código

### Clase `ConsoleInput`
- Pertenece al paquete `ui`
- Ver código

### Clase `Menu`
- Pertenece al paquete `ui`
- Ver código

---

## Paquete `app`

### Clase `Main`
- Pertenece al paquete `app`
- Ver código