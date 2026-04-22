Que va a pedir? UML + Patrones???

NO OLVIDAR PREGUNTAR A DIEGO SI QUIERE QUE PONGAMOS EL CONSOLEINPUT COMO LIBRERIA O COMO CLASE ESTARÍA BIEN?????

---
1. Relaciones con el ConsoleInput al usar el patron Singleton. Si solo es una referencia, he puesto línea discontinua, si esta como atributo ya si pongo una relación
2. Preguntar del UML
	* Referencias
	* Composición --> Las partes no pueden existir sin el todo. Cuando el todo desaparece, las partes también.  
		* Round depende del Game, ya que no tiene sentido sin él. Si el Game desaparece, las rondas también.
		* AIPlayer -- Strategy el propio `AIPlayer` crea la `Strategy` y si desaparece el jugador, desaparece esa estrategia
	*  Agregación --> Las partes pueden existir independientemente del todo. 
		* Carta-Baraja, para que exista una carta no obligatoriamente tiene que haber una baraja, porque pueden estar en la mano del jugador. NO DEPENDEN DE LA BARAJA, PUEDEN EXISTIR SIN ESTA
3. Patrones:
	* Singleton en el ConsoleInput
	* Factory en el Configuration. Se usa para crear los jugadores. Configuration no llega a saber que jugador se está creando y delega esta opción a PlayerFactory
	* Se podría hacer otro con el Combination, no?



Hacer Test --> Pruebas de software. Enfocado en caja negra o caja blanca. Y explicarlo en la documentación. No olvidar añadir unos pantallazos de los test