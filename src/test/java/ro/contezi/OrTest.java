package ro.contezi;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static ro.contezi.PatternBuilder.*;

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
	public void aOrbDoesntMatchc() throws Exception {
		assertThat(string("a").or(string("b")).build().matcher("c").matches()).isFalse();
	}
}