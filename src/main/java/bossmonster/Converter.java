package bossmonster;

public class Converter {
	public static int stringToInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ExceptionMessage.NUMBER_FORMAT);
		}
	}
}
