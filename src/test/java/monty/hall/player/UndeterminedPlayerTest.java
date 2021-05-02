package monty.hall.player;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.*;

class UndeterminedPlayerTest {
	private final UndeterminedPlayer undeterminedPlayer = new UndeterminedPlayer();


	@Test
	void wantsToChangeBox() {
		assertTrue(undeterminedPlayer.wantsToChangeBox());
	}

	@Test
	void getPrettyName() {
		assertThat(undeterminedPlayer.getPrettyName(),is(equalTo("Undetermined player")));
	}

	@Test
	void chooseBoxIsBetweeen1and3() {
		undeterminedPlayer.chooseNewBox();
		assertThat(undeterminedPlayer.getBox(),is(is(both(greaterThan(0)).and(lessThan(4)))));
	}
}