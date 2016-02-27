package ro.contezi;

import static org.assertj.core.api.StrictAssertions.assertThat;

import org.junit.Test;

public class SimpleStringTest {
	@Test
	public void convertsSimpleStringToItselfQuoted() throws Exception {
		assertThat(new SimpleString().convert("some string")).isEqualTo("\\Qsome string\\E");
	}
}
