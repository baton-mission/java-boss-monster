package bossmonster.util.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    private Converter() {
    }

    public static List<String> splitToList(String separator, String value) {
        return Arrays.asList(value.split(separator));
    }
    public static List<Integer> convertToInteger(List<String> values) {
        return values.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<Integer> splitToIntegerList(String separator, String value) {
        return convertToInteger(splitToList(separator, value));
    }

    public static int convertToInt(String value) {
        return Integer.parseInt(value);
    }

    public static String splitValue(String separator, int index, String value) {
        return splitToList(separator, value).get(index);
    }
}
