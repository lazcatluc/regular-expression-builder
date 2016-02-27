package ro.contezi;

public class SelfString {

	public String convert(String string) {
		return "\\Q"+string+"\\E";
	}

}
