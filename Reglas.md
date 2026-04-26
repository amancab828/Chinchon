
---
# Baraja española

- Se juega con **1-2 baraja española (40 cartas)**
- Cuando el mazo se acaba, se baraja el descarte y se reutiliza
- Cartas incluidas:
    - **Palos**: oros 🪙, copas 🍷, espadas ⚔️, bastos 🪵
    - **Valores**: 1–7, 10, 11, 12 (no hay 8 ni 9)
--- 
# Jugadores
* De 2 a 5 jugadores
* Pueden ser: 
	- Humanos
	- Máquina (IA)
* Configuración inicial:
	- Número de jugadores
	- Cuántos son humanos y cuántos IA
---
# Objetivo del juego

- **Ganar la partida**:
    - Haciendo **Chinchón**
    - O siendo el **último jugador que no supera el límite de puntos**
- **Evitar** acumular puntos, ya que:
    - Al final de cada ronda se suman puntos
    - Si superas el límite → eliminado
---
# Combinaciones válidas
* **<u>Iguales</u>**
Mínimo 3 cartas del mismo número
`Ejemplo: 3🪙 3🍷 3⚔️`

* **<u>Escalera</u>**
Mínimo 3 cartas consecutivas del mismo palo
`Ejemplo: 5🍷 6🍷 7🍷`

* **<u>Chinchón</u>
NO PUEDES CERRAR EN EL PRIMER TURNO
7 cartas consecutivas del mismo palo
`Ejemplo: 4🪙 – 5🪙 – 6🪙 – 7🪙 – 10🪙 – 11🪙 – 12🪙`

# Desarrollo de la ronda

## 1️. Reparto

- Cada jugador recibe **7 cartas**
- Se colocan:
    - 🂠 Mazo boca abajo
    - 🂡 Una carta boca arriba (descarte)

---
## 2️. Turno del jugador
En su turno:
1. **Roba una carta**:
    - Del mazo
    - O del descarte
2. **Evalúa su mano**:
    - Intenta formar combinaciones
3. **Descarta una carta**:
    - Siempre debe quedarse con **7 cartas**

---
## 3️. Cierre de ronda

Un jugador puede **cerrar** si:
- Tiene **6 o 7 cartas combinadas**

### Casos:
**7 cartas combinadas**
- Mano perfecta
- **-10 puntos (bonus)**

 **6 cartas combinadas + 1 carta suelta**
- La carta suelta debe valer **entre 1 y 5**

 No puede cerrar si:
- Supera el límite de puntos tras el conteo

 Importante:
- Se cierra **después de robar y antes de descartar**
- La carta que descartas es la que “cierra”

---
# Puntuación

- Las cartas **NO combinadas suman puntos**:
    - As (1) → 1 punto
    - 2–7 → valor numérico
    - 10, 11, 12 → 10 puntos