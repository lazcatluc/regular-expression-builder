package ro.contezi;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static ro.contezi.PatternBuilder.*;

import java.util.regex.Pattern;

import org.junit.Test;

public class SelfStringTest {
	private static final String COMPLEX_STRING = "complex\\string";

	@Test
	public void simpleStringRegExpMatchesSimpleString() throws Exception {
		assertStringIsMatchedToItself("simple string");
	}
	
	@Test
	public void complexStringRegExpMatchesComplexString() throws Exception {
		assertStringIsMatchedToItself(COMPLEX_STRING);
	}
	
	@Test
	public void complexStringIsNotMatchedByDefault() throws Exception {
		assertThat(Pattern.compile(COMPLEX_STRING).matcher(COMPLEX_STRING).matches()).isFalse();
	}
	
	private void assertStringIsMatchedToItself(String simpleString) {
		assertThat(string(simpleString).build().matcher(simpleString).matches()).isTrue();
	}
}
