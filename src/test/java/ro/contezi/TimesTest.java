package ro.contezi;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static ro.contezi.PatternBuilder.string;

import org.junit.Test;

public class TimesTest {
	@Test
	public void matchesAtLeastOnce() throws Exception {
		assertThat(string("a").atLeastOnce().build().matcher("aaa").matches()).isTrue();
	}
	
	@Test
	public void doesntMatchIfMissing() throws Exception {
		assertThat(string("a").atLeastOnce().build().matcher("bbb").matches()).isFalse();
	}
	
	@Test
	public void matchesBetweenTwoAndThreeWithTwo() throws Exception {
		assertThat(string("a").betweenTimes(2,3).build().matcher("aa").matches()).isTrue();
	}
	
	@Test
	public void matchesBetweenTwoAndThreeWithThree() throws Exception {
		assertThat(string("a").betweenTimes(2,3).build().matcher("aaa").matches()).isTrue();
	}
	
	@Test
	public void matchesThreeWithThree() throws Exception {
		assertThat(string("a").times(3).build().matcher("aaa").matches()).isTrue();
	}
	
	@Test
	public void doesntMatchBetweenTwoAndThreeWithOne() throws Exception {
		assertThat(string("a").betweenTimes(2,3).build().matcher("a").matches()).isFalse();
	}
	
	@Test
	public void doesntMatchBetweenTwoAndThreeWithFour() throws Exception {
		assertThat(string("a").betweenTimes(2,3).build().matcher("aaaa").matches()).isFalse();
	}
}
