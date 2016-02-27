package ro.contezi;

import static org.assertj.core.api.Assertions.assertThat;
import static ro.contezi.PatternBuilder.*;

import org.junit.Test;

public class ChainingTest {
	@Test
	public void aThenbMatchesab() throws Exception {
		assertThat(string("a").then(string("b")).build().matcher("ab").matches()).isTrue();
	}
}
