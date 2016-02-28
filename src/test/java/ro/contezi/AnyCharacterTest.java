package ro.contezi;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static ro.contezi.PatternBuilder.*;

import org.junit.Test;

public class AnyCharacterTest {
	@Test
	public void matchesX() throws Exception {
		assertThat(anyCharacter().matches("X")).isTrue();
	}
}
