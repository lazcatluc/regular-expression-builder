package ro.contezi;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static ro.contezi.PatternBuilder.*;

import org.junit.Test;

public class TerminatesTest {
	@Test
	public void startsWithSucceedsWhenWordIsTheFirstInString() throws Exception {
		assertThat(string("abc").thenTerminates().matcher("xabc").find()).isTrue();
	}

	@Test
	public void startsWithFailsWhenWordIsNotTheFirstInString() throws Exception {
		assertThat(startsWith("abc").thenTerminates().matcher("xabcdef").find()).isFalse();
	}
}
