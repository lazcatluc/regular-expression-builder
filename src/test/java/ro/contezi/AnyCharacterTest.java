package ro.contezi;

import static org.assertj.core.api.StrictAssertions.assertThat;

import org.junit.Test;

public class AnyCharacterTest {
	@Test
	public void matchesX() throws Exception {
		assertThat(RegularExpressions.anyCharacter().buildPattern().matcher("X").matches()).isTrue();
	}
}
