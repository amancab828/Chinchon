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
### Clase `Combination`
- Pertenece al paquete `combinations`
- Ver código

### Enum `CombinationType`
- Pertenece al paquete `combinations`
- Ver código

---

## Paquete `games`

### Clase `Game`
- Pertenece al paquete `games`
- Ver código

### Clase `Round`
- Pertenece al paquete `games`
- Ver código

### Clase `Configuration`
- Pertenece al paquete `games`
- Ver código

---

## Paquete `players`

### Interfaz `Player`
- Pertenece al paquete `players`
- Ver código

### Clase `AbstractPlayer`
- Pertenece al paquete `players`
- Ver código

### Clase `HumanPlayer`
- Pertenece al paquete `players`
- Ver código

### Clase `AIPlayer`
- Pertenece al paquete `players`
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
- Aquí se usa el patrón Singleton, para garantizar que la clase tenga una única instancia y proporcionar acceso global
- Ver código

### Clase `Menu`
- Pertenece al paquete `ui`
- Ver código

---

## Paquete `app`

### Clase `Main`
- Pertenece al paquete `app`
- Ver código