package ro.contezi;

public final class RegularExpressions {
	private RegularExpressions() {
		
	}
	
	public static PatternBuilder anyCharacter() {
		return () -> ".";
	}
	
	public static PatternBuilder string(String string) {
		return () -> "\\Q"+string+"\\E";
	}
	
	public static PatternBuilder anyNumberOfTimes(PatternBuilder patternBuilder) {
		return () -> "(" + patternBuilder.build() + ")*";
	}
}
