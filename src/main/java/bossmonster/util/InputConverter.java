package bossmonster.util;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

public final class InputConverter {

    private static final String COMMA_DELIMITER = ",";

    public static int convertBossHp(String rawBossHp) {
        return parseToInt(rawBossHp);
    }

    private static int parseToInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> convertPlayerHpAndMp(String rawPlayerHpAndMp) {
        return splitToInt(COMMA_DELIMITER, rawPlayerHpAndMp);
    }

    private static List<Integer> splitToInt(String format, String input) {
        return Stream.of(input.split(format))
                .map(Integer::parseInt)
                .collect(toList());
    }

    public static int convertAttackTypeCode(String rawAttackTypeCode) {
        return parseToInt(rawAttackTypeCode);
    }

}
