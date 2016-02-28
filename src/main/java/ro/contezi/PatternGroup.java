package ro.contezi;

import java.util.concurrent.atomic.AtomicLong;

public class PatternGroup {
	private static AtomicLong position = new AtomicLong(0);
	
	private final String name;
	
	public PatternGroup() {
		name = "PatternGroup"+position.incrementAndGet();
	}
	
	public String getName() { 
		return name;
	}
}
