package bossmonster;

import bossmonster.message.ExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
	public static int stringToInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ExceptionMessage.NUMBER_FORMAT);
		}
	}

	public static List<Integer> stringToSplitInt(String src, String delimiter) {
		return Arrays.stream(src.split(delimiter))
				.map(Converter::stringToInt)
				.collect(Collectors.toList());
	}


}
