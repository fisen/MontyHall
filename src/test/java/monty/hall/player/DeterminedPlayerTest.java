package monty.hall.player;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.*;

class DeterminedPlayerTest {
	private final DeterminedPlayer determinedPlayer = new DeterminedPlayer();

	@Test
	void wantsToChangeBox() {
		assertFalse(determinedPlayer.wantsToChangeBox());
	}

	@Test
	void getPrettyName() {
		assertThat(determinedPlayer.getPrettyName(),is(equalTo("Determined player")));
	}

	@Test
	void chooseBoxIsBetweeen1and3() {
		determinedPlayer.chooseNewBox();
		assertThat(determinedPlayer.getBox(),is(is(both(greaterThan(0)).and(lessThan(4)))));
	}
}