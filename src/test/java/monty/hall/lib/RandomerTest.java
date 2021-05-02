package monty.hall.lib;

import monty.hall.host.Host;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;


public class RandomerTest {
	@Test
	public void randomNumberBetween1and3isRandom(){
		Host host = new Host();
		int[] result = new int[3];
		host.chooseNewBox();
		IntStream.range(0, 10000).forEach(i -> result[Randomer.randomNumberBetween1and3()-1] += 1);
		System.out.println("number 1: " +result[0]);
		System.out.println("number 2: " +result[1]);
		System.out.println("number 3: " +result[2]);
		assertThat(result[0], is(both(greaterThan(2900)).and(lessThan(3800))));
		assertThat(result[1], is(both(greaterThan(2900)).and(lessThan(3800))));
		assertThat(result[2], is(both(greaterThan(2900)).and(lessThan(3800))));
	}
}