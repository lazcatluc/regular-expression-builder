package ro.contezi;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static ro.contezi.PatternBuilder.startsWith;

import org.junit.Test;

public class StartsWtihTest {
	@Test
	public void startsWithSucceedsWhenWordIsTheFirstInString() throws Exception {
		assertThat(startsWith("abc").matcher("abcdef").find()).isTrue();
	}

	@Test
	public void startsWithFailsWhenWordIsNotTheFirstInString() throws Exception {
		assertThat(startsWith("abc").matcher("xabcdef").find()).isFalse();
	}
}

