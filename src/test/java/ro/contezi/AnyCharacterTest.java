package ro.contezi;

import static org.assertj.core.api.StrictAssertions.assertThat;

import java.util.regex.Pattern;

import org.junit.Test;

public class AnyCharacterTest {
	@Test
	public void matchesX() throws Exception {
		assertThat(Pattern.compile(new AnyCharacter().build()).matcher("X").matches()).isTrue();
	}
}
