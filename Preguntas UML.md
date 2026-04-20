NO OLVIDAR PREGUNTAR A DIEGO SI QUIERE QUE PONGAMOS EL CONSOLEINPUT COMO LIBRERIA O COMO CLASE ESTARÍA BIEN?????
1. Relaciones con el ConsoleInput al usar el patron Singleton
2. No acabo de ver si hay alguna:
	* Composición --> Las partes no pueden existir sin el todo. Cuando el todo desaparece, las partes también.
		---
		Tengo también como composición AIStrategy y AIPlayer, ya que si AIPlayer desaparece, su estrategia también
	* Agregación --> Las partes pueden existir independientemente del todo.
		---
		Tengo una agregación de carta y baraja, ya que las cartas pueden existir fuera de la baraja (en la mano del jugador)
	    ---
		No se si game o configuration, seria una agregación, porque tiene Player, Rounds, Deck...  --> No sería una composición porque al terminar Game, se siguen manteniendo los jugadores, barajas y tal (Se pregunta si se quiere echar otro Game)
3. Configuration tiene relación/referencia `----Use---->` con Player, aunque también cree HumanPlayer y IAPLAYER, con poner la relación con la interfaz padre serviría, no?

 