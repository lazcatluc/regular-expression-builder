package ro.contezi;
import static org.assertj.core.api.StrictAssertions.assertThat;
import static ro.contezi.PatternBuilder.from;
import static ro.contezi.PatternBuilder.string;

import org.junit.Test;

public class OrTest {
	@Test
	public void aOrbMatchesa() throws Exception {
		assertThat(string("a").or(string("b")).matches("a")).isTrue();
	}
	
	@Test
	public void aOrbMatchesb() throws Exception {
		assertThat(string("a").or(string("b")).matches("b")).isTrue();
	}

	@Test
	public void aOrbDoesntMatchesc() throws Exception {
		assertThat(string("a").or(string("b")).matches("c")).isFalse();
	}
	
	@Test
	public void aThroughzMatchesb() throws Exception {
		assertThat(from('a').to('z').matches("b")).isTrue();
	}
	
	@Test
	public void aThroughzOrAThroughZAtLeastOnceMatchesWord() throws Exception {
		assertThat(from('a').to('z').or(from('A').to('Z')).atLeastOnce().matches("Hello")).isTrue();
	}
	
	@Test
	public void aThroughzOrAThroughZAtLeastOnceDoesntMatchTwoWords() throws Exception {
		assertThat(from('a').to('z').or(from('A').to('Z')).atLeastOnce().matches("Hello World")).isFalse();
	}
}