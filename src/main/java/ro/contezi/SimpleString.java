package ro.contezi;

public class SimpleString {

	public String convert(String string) {
		return "\\Q"+string+"\\E";
	}

}
