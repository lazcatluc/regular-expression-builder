package ro.contezi;

import static org.assertj.core.api.Assertions.assertThat;
import static ro.contezi.PatternBuilder.*;

import org.junit.Test;

public class MaybeTest {
	@Test
	public void maybeABMatchesEmpty() throws Exception {
		assertThat(maybe("AB").matches("")).isTrue();
	}
	
	@Test
	public void maybeABMatchesAB() throws Exception {
		assertThat(maybe("AB").matches("AB")).isTrue();
	}
	
	@Test
	public void maybeABDoesntMatchAC() throws Exception {
		assertThat(maybe("AB").matches("AC")).isFalse();
	}
}
