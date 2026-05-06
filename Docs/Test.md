# Test / Pruebas
En este proyecto se han desarrollado **pruebas unitarias utilizando JUnit 5** con el objetivo de verificar el correcto funcionamiento de la lógica principal del juego de Chinchón.

Estas pruebas garantizan la fiabilidad del sistema, facilitan el mantenimiento del código y permiten comprobar que futuras modificaciones no afecten al comportamiento esperado.

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
	* turnDraw_drawDiscard →
	* turnDraw_drawDeck →
	* turnDiscard_minPoints →
	* turnStand_returnsTrue →
	* turnStand_returnsFalse →
* [Ver código](../test/ai/strategyTest.java)

---
### CombinationSolverTest
* Pertenece al paquete combinations, y se centra en hacer pruebas a los métodos más complejos de CombinationSolver
	* calculatePoints_onlyCardsNotUsed →
	* getBestCombinations_checkSetStraight →
	* getBestCombinations_checkStraight →
	* getBestCombinations_checkChinchon →
* [Ver código](../test/combinations/CombinationSolverTest.java)

---
### GameTest
* Pertenece al paquete games, y se centra en hacer pruebas a los métodos más complejos de Game
	* getActivePlayers_excludePlayers →
	* startGame_notWinner →
	* startGame_afterChinchon →
* [Ver código](../test/games/gameTest.java)



