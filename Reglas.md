
---
# Baraja española

* 1 baraja --> 40 cartas
Si es configurable entre 1 y 2, cuando se termina la baraja, se vuelve a barajar
* Palos: oros, copas, espadas y bastos
* Valores: 1-7, 10, 11, 12
--- 
# Jugadores
* De 2 a 5 jugadores
* Pueden ser: 
	- Humanos
	- Máquina (IA)
* Se configura al empezar una partida, cuantas IA hay y cuantos jugadores reales
---
# Partida
* Al principio de la partida se define cuantas rondas son en total, y cual es el límite de puntos máximo para eliminar a un jugador
* La ronda termina cuando: 
	* Un jugador se planta, para cerrar debe tener de 6 a 7 cartas combinadas
* La partida termina cuando: 
	* Un jugador hace Chinchón 
	* Solo queda un jugador porque el resto se han pasado de puntos
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

# Desarrollo de ronda
1. **<u>Reparto</u>**
	* Cada jugador recibe 7 cartas
	* Se coloca:
		Un mazo boca abajo
		Una carta boca arriba (descarte)

2. **<u>Turno de jugador</u>**
	* En su turno, el jugador, roba una carta
		Del mazo
		O del montón de descarte
	* Decide qué carta descartar. En el caso del jugador humano, el juego le dirá cuál es la mejor opción.
	* Siempre debe terminar con 7 cartas

3. **<u>Cierre de ronda</u>**
	* Tiene de 6 a 7 cartas combinadas. 
		El jugador que cierre con 7 cartas combinadas, se le restan 10 puntos. 
		En el caso de que sean 6 cartas combinadas, la carta suelta tiene que valer entre 1 y 5
	    No puede cerrar si se pasa del límite de puntos
	* Cuando un jugador cierra, es después de robar y antes de descartar, es decir, al cerrar ya se está descartando.