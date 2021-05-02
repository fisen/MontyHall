package monty.hall.lib;

import java.util.concurrent.ThreadLocalRandom;

public class Randomer {

	private static final int MIN_RANDOM_VALUE = 1;
	private static final int MAX_RANDOM_VALUE = 3;

	public static int randomNumberBetween1and3(){
		return ThreadLocalRandom.current().nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE + 1);
	}
}
