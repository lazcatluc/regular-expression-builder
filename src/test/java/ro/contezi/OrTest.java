package ro.contezi;
import static org.assertj.core.api.StrictAssertions.assertThat;
import static ro.contezi.PatternBuilder.from;
import static ro.contezi.PatternBuilder.string;

import org.junit.Test;

public class OrTest {
	@Test
	public void aOrbMatchesa() throws Exception {
		assertThat(string("a").or(string("b")).build().matcher("a").matches()).isTrue();
	}
	
	@Test
	public void aOrbMatchesb() throws Exception {
		assertThat(string("a").or(string("b")).build().matcher("b").matches()).isTrue();
	}

	@Test
	public void aOrbDoesntMatchesc() throws Exception {
		assertThat(string("a").or(string("b")).build().matcher("c").matches()).isFalse();
	}
	
	@Test
	public void aThroughzMatchesb() throws Exception {
		assertThat(from('a').to('z').build().matcher("b").matches()).isTrue();
	}
	
	@Test
	public void aThroughzOrAThroughZAtLeastOnceMatchesWord() throws Exception {
		assertThat(from('a').to('z').or(from('A').to('Z')).atLeastOnce().build().matcher("Hello").matches()).isTrue();
	}
	
	@Test
	public void aThroughzOrAThroughZAtLeastDoesntMatchTwoWords() throws Exception {
		assertThat(from('a').to('z').or(from('A').to('Z')).atLeastOnce().build().matcher("Hello World").matches()).isFalse();
	}
}