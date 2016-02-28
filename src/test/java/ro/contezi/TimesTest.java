package ro.contezi;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static ro.contezi.PatternBuilder.string;

import org.junit.Test;

public class TimesTest {
	@Test
	public void matchesAtLeastOnce() throws Exception {
		assertThat(string("a").atLeastOnce().matches("aaa")).isTrue();
	}
	
	@Test
	public void doesntMatchIfMissing() throws Exception {
		assertThat(string("a").atLeastOnce().matches("bbb")).isFalse();
	}
	
	@Test
	public void matchesBetweenTwoAndThreeWithTwo() throws Exception {
		assertThat(string("a").betweenTimes(2,3).matches("aa")).isTrue();
	}
	
	@Test
	public void matchesBetweenTwoAndThreeWithThree() throws Exception {
		assertThat(string("a").betweenTimes(2,3).matches("aaa")).isTrue();
	}
	
	@Test
	public void matchesThreeWithThree() throws Exception {
		assertThat(string("a").times(3).matches("aaa")).isTrue();
	}
	
	@Test
	public void doesntMatchBetweenTwoAndThreeWithOne() throws Exception {
		assertThat(string("a").betweenTimes(2,3).matches("a")).isFalse();
	}
	
	@Test
	public void doesntMatchBetweenTwoAndThreeWithFour() throws Exception {
		assertThat(string("a").betweenTimes(2,3).matches("aaaa")).isFalse();
	}
}
