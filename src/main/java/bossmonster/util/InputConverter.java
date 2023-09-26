package bossmonster.util;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

public final class InputConverter {
    // 콤마 구분자
    private static final String COMMA_DELIMITER = ",";

    // 콤마 + 공백 구분자
    private static final String COMMA_SPACE_DELIMITER = ", ";


    // TODO : 본격적으로 프러덕션 코드에서 사용할 메서드들을 구현
    public static int convertTryCount(String rawTryCount) {
        return parseToInt(rawTryCount);
    }


    /**
     * 콤마 구분자로 문자열을 나누어 리스트로 반환
     */
    private static List<String> split(String format, String input) {
        // TODO : 원하는 구분자에 맞게 구현
        return List.of(input.split(format));
    }

    private static List<Integer> splitToInt(String format, String input) {
        // TODO : 원하는 구분자에 맞게 구현
        return Stream.of(input.split(format))
                .map(Integer::parseInt)
                .collect(toList());
    }


    private static int parseToInt(String input) {
        return Integer.parseInt(input);
    }


    public static int convertBossHp(String rawBossHp) {
        return parseToInt(rawBossHp);
    }

    public static List<Integer> convertPlayerHpAndMp(String rawPlayerHpAndMp) {
        return splitToInt(COMMA_DELIMITER, rawPlayerHpAndMp);
    }

    public static int convertAttackTypeCode(String rawAttackTypeCode) {
        return parseToInt(rawAttackTypeCode);
    }
}
