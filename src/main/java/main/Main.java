package main;

import monty.hall.Game;
import monty.hall.player.DeterminedPlayer;
import monty.hall.player.UndeterminedPlayer;

public class Main {
	private static final int NUMBER_OF_ITERATIONS = 10000;

	public static void main(String[] args){
		Game game2 = new Game(NUMBER_OF_ITERATIONS, new UndeterminedPlayer());
		Game game1 = new Game(NUMBER_OF_ITERATIONS, new DeterminedPlayer());
		game1.run();
		game2.run();
	}
}
