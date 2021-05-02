package monty.hall;

import monty.hall.player.UndeterminedPlayer;
import org.junit.jupiter.api.Test;

public class GameTest {

	@Test
	public void createNewGame(){
		Game game = new Game(1, new UndeterminedPlayer());
	}

	@Test
	public void runGame(){
		Game game = new Game(100, new UndeterminedPlayer());
		game.run();
	}
}