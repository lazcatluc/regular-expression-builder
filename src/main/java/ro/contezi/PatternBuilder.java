package ro.contezi;

import java.util.regex.Pattern;

@FunctionalInterface
public interface PatternBuilder {
	String build();
	
	default Pattern buildPattern() {
		return Pattern.compile(build());
	}
}
