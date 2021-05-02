package monty.hall;

import monty.hall.host.Host;
import monty.hall.player.Player;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Game {

	private final int numberOfGames;
	private int result = 0;
	private final Host host;
	private final Player player;

	public Game(int numberOfGames, Player player) {
		assert(numberOfGames>99):"Number of Games has to be larger than 99";
		this.numberOfGames = numberOfGames;
		this.host = new Host();
		this.player = player;
	}

	public void run(){
		int a = 0;
		while (a < numberOfGames){
			host.chooseNewBox();
			player.chooseNewBox();
			int playersBox = host.getPlayersNewBoxAfterDecision(player.wantsToChangeBox(), player.getBox());
			result = host.isCorrectAnswer(playersBox) ? result + 1 : result;
			a++;
		}
		System.out.printf("%ss has correct %s%% of the time.%n", player.getPrettyName(), resultInPercent(result));
	}

	private BigDecimal resultInPercent(int result){
		return new BigDecimal(result).divide(new BigDecimal(numberOfGames/100), RoundingMode.DOWN);
	}

}
