package ro.contezi;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static ro.contezi.PatternBuilder.string;

import org.junit.Before;
import org.junit.Test;

public class GroupTest {

	private PatternBuilder pattern;
	private PatternGroup helloGroup;

	@Before
	public void setUp() {
		helloGroup = new PatternGroup();
		pattern = string("he").then(string("l").atLeastOnce()).then(string("o")).group(helloGroup).then(string("world"))
				.then(helloGroup);
	}

	@Test
	public void matchesGroupedSearch() throws Exception {
		assertThat(pattern.build().matcher("helloworldhello").matches()).isTrue();
	}

	@Test
	public void matchesGroupedSearchAfter() throws Exception {
		PatternGroup fooGroup = new PatternGroup();
		assertThat(string("f").then(string("o").atLeastOnce()).group(fooGroup).then(string("bar"))
				.then(fooGroup).then(pattern).build().matcher("foobarfoohelloworldhello").matches()).isTrue();
	}

	@Test
	public void doesntMatchDifferentNumberOfLinHello() throws Exception {
		assertThat(pattern.build().matcher("helloworldhellllo").matches()).isFalse();
	}
}
