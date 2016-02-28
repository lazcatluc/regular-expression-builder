package ro.contezi;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static ro.contezi.PatternBuilder.string;

import org.junit.Before;
import org.junit.Test;

public class GroupTest {

	private PatternBuilder pattern;	

	@Before
	public void setUp() {
		pattern = string("he").then(string("l").atLeastOnce()).then(string("o")).group("hello").then(string("world"))
				.thenGroup("hello");
	}

	@Test
	public void matchesGroupedSearch() throws Exception {
		assertThat(pattern.build().matcher("helloworldhello").matches()).isTrue();
	}

	@Test
	public void matchesGroupedSearchAfter() throws Exception {		
		assertThat(string("f").then(string("o").atLeastOnce()).group("foo").then(string("bar"))
				.thenGroup("foo").then(pattern).build().matcher("foobarfoohelloworldhello").matches()).isTrue();
	}

	@Test
	public void doesntMatchDifferentNumberOfLinHello() throws Exception {
		assertThat(pattern.build().matcher("helloworldhellllo").matches()).isFalse();
	}
}
