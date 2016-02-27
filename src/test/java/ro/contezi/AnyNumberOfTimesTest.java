package ro.contezi;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static ro.contezi.RegularExpressions.anyNumberOfTimes;
import static ro.contezi.RegularExpressions.string;

import org.junit.Test;

public class AnyNumberOfTimesTest {
	private static final String FOO_BAR_BAZ = "foo\\bar.baz";

	@Test
	public void matchesNoTimes() throws Exception {
		assertMatchesInput("");
	}
	
	@Test
	public void matchesOnce() throws Exception {
		assertMatchesInput(FOO_BAR_BAZ);
	}
	
	@Test
	public void matchesThreeTimes() throws Exception {
		assertMatchesInput(FOO_BAR_BAZ+FOO_BAR_BAZ+FOO_BAR_BAZ);
	}
	
	@Test
	public void doesntMatchDifferentInput() throws Exception {
		assertThat(anyNumberOfTimes(string(FOO_BAR_BAZ)).buildPattern().matcher("foo\\bar-baz").matches()).isFalse();
	}
	
	private void assertMatchesInput(final String input) {
		assertThat(anyNumberOfTimes(string(FOO_BAR_BAZ)).buildPattern().matcher(input).matches()).isTrue();
	}
}
