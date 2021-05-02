package monty.hall.host;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HostTest {

	private final Host host = new Host();

	@Test
	public void createHostTest(){
		new Host();
	}

	@Test
	public void correctAnswerIs1or2or3(){
		host.chooseNewBox();
		assertThat(getCorrectBox(host), is(not(0)));
	}

	@Test
	public void getPlayersNewBoxAfterDecisionWithCorrectBoxAlwaysReturnAnEmptyBox(){
		host.chooseNewBox();
		int correctBox = getCorrectBox(host);
		int wrongBox = host.getPlayersNewBoxAfterDecision(true, correctBox);
		assertTrue(IntStream.of(1, 2, 3).filter(i -> i == wrongBox).noneMatch(i -> host.isCorrectAnswer(i)));
	}

	@Test
	public void getPlayersNewBoxAfterDecisionWithWrongBoxAlwaysCorrect(){
		host.chooseNewBox();
		int correctBox = getCorrectBox(host);
		int wrongBox = IntStream.of(1, 2, 3).filter(i -> i != correctBox).findFirst().orElse(0);
		assertThat(wrongBox,is(not(0)));
		int newBox = host.getPlayersNewBoxAfterDecision(true, wrongBox);
		assertTrue(host.isCorrectAnswer(newBox));
		assertTrue(newBox == correctBox);
	}

	@Test
	public void notChangingBoxAlwaysReturnsTheSameBox1(){
		host.chooseNewBox();
		int newBox = host.getPlayersNewBoxAfterDecision(false, 1);
		assertEquals(newBox, 1);
	}

	@Test
	public void notChangingBoxAlwaysReturnsTheSameBox2(){
		host.chooseNewBox();
		int newBox = host.getPlayersNewBoxAfterDecision(false, 2);
		assertEquals(newBox, 2);
	}

	@Test
	public void notChangingBoxAlwaysReturnsTheSameBox3(){
		host.chooseNewBox();
		int newBox = host.getPlayersNewBoxAfterDecision(false, 3);
		assertEquals(newBox, 3);
	}

	@Test
	public void chooseNewBoxSetsNewBoxRandomly(){
		int[] result = new int[3];
		IntStream.range(0, 10000).forEach(i -> {
			host.chooseNewBox();
			result[getCorrectBox(host) - 1] += 1;});
		System.out.println("number 1: " +result[0]);
		System.out.println("number 2: " +result[1]);
		System.out.println("number 3: " +result[2]);
		assertThat(result[0], is(both(greaterThan(2900)).and(lessThan(3800))));
		assertThat(result[1], is(both(greaterThan(2900)).and(lessThan(3800))));
		assertThat(result[2], is(both(greaterThan(2900)).and(lessThan(3800))));
	}

	private int getCorrectBox(Host host){
		return IntStream.of(1,2,3).filter(host::isCorrectAnswer).findFirst().orElse(0);
	}
}
