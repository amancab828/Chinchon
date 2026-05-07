# Test / Pruebas
En este proyecto se han desarrollado **pruebas unitarias utilizando JUnit 5** con el objetivo de verificar el correcto funcionamiento de la lógica principal del juego de Chinchón.

Estas pruebas garantizan la fiabilidad del sistema, facilitan el mantenimiento del código y permiten comprobar que futuras modificaciones no afecten al comportamiento esperado.

Las pruebas se centran principalmente en las clases y métodos con una lógica más compleja.

---
### Enfoque
En este proyecto se han aplicado principalmente pruebas de **caja negra**, basadas en el comportamiento esperado del sistema sin tener en cuenta cómo está implementado el código.

También se han utilizado algunos principios de **caja blanca**, ya que en ciertos casos se comprueban ramas del código y situaciones concretas, aunque no es el enfoque principal.

---
### Herramienta utilizada
Las pruebas se han desarrollado utilizando:
- **JUnit 5 (Jupiter)**
Esta librería permite crear y ejecutar pruebas unitarias, incluyendo tests parametrizados y el uso de aserciones como `assertEquals` o `assertThrows` para comprobar resultados.

---
## Estructura de los test
### StrategyTest
* Pertenece al paquete ai, y se centra en hacer pruebas a los métodos más complejos de Strategy
	* turnDraw_drawDiscard → Comprueba que se roba la carta de descarte cuando ayuda a minimizar puntos.
	* turnDraw_drawDeck → Comprueba que se roba de la baraja cuando la carta del descarte no es útil.
	* turnDiscard_minPoints → Verifica que se descarte la carta de menor puntuación cuando ninguna ayuda en la mano.
	* turnStand_returnsTrue → Comprueba que el jugador se planta cuando puede hacerlo.
	* turnStand_returnsFalse → Comprueba que la estrategia de la IA no se planta cuando no debe hacerlo.
* [Ver código](../test/ai/strategyTest.java)

---
### CombinationSolverTest
* Pertenece al paquete combinations, y se centra en hacer pruebas a los métodos más complejos de CombinationSolver
	* calculatePoints_onlyCardsNotUsed → Comprueba el cálculo de puntos cuando existen cartas sin utilizar.
	* getBestCombinations_checkSetStraight → Verifica la detección de tríos y escaleras.
	* getBestCombinations_checkStraight → Comprueba el salto especial de la baraja española (7 → 10).
	* getBestCombinations_checkChinchon → Verifica que se detecte correctamente un Chinchón.
* [Ver código](../test/combinations/CombinationSolverTest.java)

---
### GameTest
* Pertenece al paquete games, y se centra en hacer pruebas a los métodos más complejos de Game
	* getActivePlayers_excludePlayers → Comprueba que los jugadores eliminados dejan de estar activos.
	* startGame_notWinner → Verifica una partida sin ganador.
	* startGame_afterChinchon → Verifica una partida con ganador tras realizar un Chinchón.
* [Ver código](../test/games/gameTest.java)

---
## Mejora a futuro
Como mejora futura, sería recomendable realizar pruebas más independientes y específicas para cada método.  
  
Por ejemplo, actualmente al probar `turnDraw()` también se utiliza internamente `pointsOf()`. Lo ideal sería crear pruebas separadas para ambos métodos, reduciendo así la dependencia entre tests y mejorando el aislamiento de las pruebas unitarias.

