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
		pattern = string("he").then(string("l").atLeastOnce()).then(string("o"));
		helloGroup = pattern.group();
		pattern.then(string("world")).then(helloGroup);
	}
	
	@Test
	public void matchesGroupedSearch() throws Exception {
		assertThat(pattern.build().matcher("helloworldhello").matches()).isTrue();
	}
	
	@Test
	public void matchesGroupedSearchAfter() throws Exception {
		PatternBuilder foo = string("f").then(string("o").atLeastOnce());
		PatternGroup fooGroup = foo.group();
		PatternBuilder initial = foo.then(string("bar")).then(fooGroup);

		assertThat(initial.then(pattern).build().matcher("foobarfoohelloworldhello").matches()).isTrue();
	}
	
	@Test
	public void doesntMatchDifferentNumberOfLinHello() throws Exception {
		assertThat(pattern.build().matcher("helloworldhellllo").matches()).isFalse();
	}
}
