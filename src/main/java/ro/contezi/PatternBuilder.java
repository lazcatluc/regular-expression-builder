package ro.contezi;

import java.util.regex.Pattern;

public class PatternBuilder {
	
	private final StringBuilder pattern;
	
	private PatternBuilder(StringBuilder patternBuilder) {
		this.pattern = patternBuilder;
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
		final PatternBuilder pattern = string(string);
		pattern.paranthesize().append('?');
		return pattern;
	}

	public PatternBuilder anyNumberOfTimes() {
		paranthesize().append('*');
		return this;
	}
	
	public PatternBuilder atLeastOnce() {
		paranthesize().append('+');
		return this;
	}
	
	public PatternBuilder times(int times) {
		paranthesize().append('{').append(times).append('}');
		return this;
	}
	
	public PatternBuilder atLeastTimes(int times) {
		paranthesize().append('{').append(times).append(',').append('}');
		return this;
	}
	
	public PatternBuilder betweenTimes(int atLeast, int atMost) {
		paranthesize().append('{').append(atLeast).append(',').append(atMost).append('}');
		return this;
	}
	
	public PatternBuilder then(PatternBuilder anotherPattern) {
		pattern.append(anotherPattern.pattern);
		return this;
	}
	
	public PatternBuilder then(PatternGroup helloGroup) {
		pattern.append("\\k<").append(helloGroup.getName()).append('>');		
		return this;
	}
	
	public Pattern build() {
		return Pattern.compile(pattern.toString());
	}

	private StringBuilder paranthesize() {
		return pattern.insert(0, "(?:").append(')');		
	}

	public PatternBuilder or(PatternBuilder anotherPattern) {
		paranthesize().append('|').append(anotherPattern.paranthesize());
		return this;
	}

	public PatternBuilder to(char c) {
		pattern.append(c).append(']');
		return this;
	}

	public PatternGroup group() {
		PatternGroup group = new PatternGroup();
		pattern.insert(0, "(?<"+group.getName()+'>').append(')');	
		return group;
	}

}
