package ro.contezi;

import java.util.regex.Pattern;

public class PatternBuilder {

	private final String pattern;

	private PatternBuilder(StringBuilder patternBuilder) {
		this.pattern = patternBuilder.toString();
	}

	public static PatternBuilder anyCharacter() {
		return new PatternBuilder(new StringBuilder("."));
	}

	public static PatternBuilder string(String string) {
		return new PatternBuilder(new StringBuilder("\\Q").append(string).append("\\E"));
	}

	public static PatternBuilder from(char start) {
		return new PatternBuilder(new StringBuilder("[").append(start).append('-'));
	}

	public static PatternBuilder maybe(String string) {
		return new PatternBuilder(string(string).paranthesize().append('?'));
	}

	public PatternBuilder anyNumberOfTimes() {
		return new PatternBuilder(paranthesize().append('*'));
	}

	public PatternBuilder atLeastOnce() {
		return new PatternBuilder(paranthesize().append('+'));
	}

	public PatternBuilder times(int times) {
		return new PatternBuilder(paranthesize().append('{').append(times).append('}'));
	}

	public PatternBuilder atLeastTimes(int times) {
		return new PatternBuilder(paranthesize().append('{').append(times).append(',').append('}'));
	}

	public PatternBuilder betweenTimes(int atLeast, int atMost) {
		return new PatternBuilder(
				paranthesize().append('{').append(atLeast).append(',').append(atMost).append('}'));
	}

	public PatternBuilder then(PatternBuilder anotherPattern) {
		return new PatternBuilder(new StringBuilder(pattern).append(anotherPattern.pattern));
	}

	public PatternBuilder then(String groupName) {
		return new PatternBuilder(new StringBuilder(pattern).append("\\k<").append(groupName).append('>'));
	}

	public Pattern build() {
		return Pattern.compile(pattern.toString());
	}

	private StringBuilder paranthesize() {
		return new StringBuilder("(?:").append(pattern).append(')');
	}

	public PatternBuilder or(PatternBuilder anotherPattern) {
		return new PatternBuilder(paranthesize().append('|').append(anotherPattern.paranthesize()));
	}

	public PatternBuilder to(char c) {
		return new PatternBuilder(new StringBuilder(pattern).append(c).append(']'));
	}

	public PatternBuilder group(String groupName) {
		return new PatternBuilder(new StringBuilder("(?<").append(groupName).append('>').append(pattern).append(')'));
	}

}
