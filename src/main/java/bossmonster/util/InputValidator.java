package bossmonster.util;


import java.util.regex.Pattern;

/**
 * 주로 View에서 입력받은 값을 검증하는 클래스
 */
public final class InputValidator {

    // 한글만 가능, 구분자 없음, 공백 false
    private static final Pattern KOR_FORMAT = Pattern.compile("[가-힣]+");

    // 영어만 가능, 구분자 없음, 공백 false
    private static final Pattern ENG_FORMAT = Pattern.compile("[A-Za-z]+");

    // 한글만 가능, "," 구분자, 공백 false, 구분자가 없고 한글 단어 1개만 있으면 true
    private static final Pattern KOR_COMMA_FORMAT = Pattern.compile("[가-힣]+(,[가-힣]+)*");

    // 영어만 가능, "," 구분자, 공백 false, 구분자가 없고 영어 단어 1개만 있으면 true
    private static final Pattern ENG_COMMA_FORMAT = Pattern.compile("[A-Za-z]+(,[A-Za-z]+)*");

    // 한글만 가능, ", " 구분자, 공백 false, 구분자가 없고 한글 단어 1개만 있으면 true
    private static final Pattern KOR_COMMA_SPACE_FORMAT = Pattern.compile("[가-힣]+(,\\s[가-힣]+)*");

    // 영어만 가능, ", " 구분자, 공백 false, 구분자가 없고 영어 단어 1개만 있어도 true
    private static final Pattern ENG_COMMA_SPACE_FORMAT = Pattern.compile("[A-Za-z-]+(,\\s[A-Za-z-]+)*");

    // 한글, 영어 모두 가능 (한영 조합도 가능), 구분자 없음, 공백 false
    private static final Pattern ENG_KOR_FORMAT = Pattern.compile("[A-Za-z가-힣]+");

    // 한글, 영어 모두 가능 (한영 조합도 가능) , "," 구분자 , 공백 false, 구분자가 없고 한영 단어 1개만 있어도 true
    private static final Pattern ENG_KOR_COMMA_FORMAT = Pattern.compile("[A-Za-z가-힣]+(,[A-Za-z가-힣]+)*");

    // 한글, 영어 모두 가능 (한영 조합도 가능), ", " 구분자 , 공백 false, 구분자 없고 한영 단어 1개만 있어도 true
    private static final Pattern ENG_KOR_COMMA_SPACE_FORMAT = Pattern.compile("[A-Za-z가-힣]+(,\\s[A-Za-z가-힣]+)*");

    // 숫자만 가능, 구분자 없음, 공백 false
    private static final Pattern NUMBER_FORMAT = Pattern.compile("[0-9]+");

    // 숫자만 가능, "," 구분자, 공백 false, 구분자 없고 숫자 1개만 있어도 true
    private static final Pattern NUMBER_COMMA_FORMAT = Pattern.compile("[0-9]+(,[0-9]+)*");

    // 숫자만 가능, "," 구분자, 공백 false, 구분자 없고 숫자 2개만 가능 => TODO : 확인 필요
    private static final Pattern NUMBER_COMMA_TWO_COUNT_FORMAT = Pattern.compile("[0-9]+(,[0-9]+){1}");

    // 숫자만 가능, ", " 구분자, 공백 false, 구분자 없고 숫자 1개만 있어도 true
    private static final Pattern NUMBER_COMMA_SPACE_FORMAT = Pattern.compile("[0-9]+(,\\s[0-9]+)*");

    // 한글자만 가능(영어, 숫자), 구분자 없음, 공백 false
    private static final Pattern ONE_CHAR_FORMAT = Pattern.compile("[A-Za-z0-9]");

    // 단순히 3개의 요소 및 ", " 구분자 (핵심은 3개만 올 수 있다), 공백 false,
    private static final Pattern THREE_COMMA_SPACE_FORMAT = Pattern.compile("[^,]+(,\\s[^,]+){2}");

    // 단순히 3개의 요소 및 "," 구분자 (핵심은 3개만 올 수 있다), 공백 false
    private static final Pattern THREE_COMMA_FORMAT = Pattern.compile("[^,]+(,[^,]+){2}");

    // 단순히 2개의 요소 및 "," 구분자 (핵심은 2개만 올 수 있다), 공백 false TODO : 확인 필요
    private static final Pattern TWO_COMMA_FORMAT = Pattern.compile("[^,]+(,[^,]+){1}");

    private static final String BLANK_EXCEPTION_MESSAGE = "공백은 입력할 수 없습니다.";
    private static final String FORMAT_EXCEPTION_MESSAGE = "형식에 맞지 않습니다.";

    private InputValidator() {
    }

    // TODO : 본격적으로 프로덕션 코드에 사용할 메서드들을 구현
    public static void validateBossHp(String rawBossHp) {
        if (isBlank(rawBossHp)) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
        if (!isRightFormat(NUMBER_FORMAT, rawBossHp)) {
            throw new IllegalArgumentException(FORMAT_EXCEPTION_MESSAGE);
        }
    }

    public static void validatePlayerName(String rawPlayerName) {
        if (isBlank(rawPlayerName)) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
        if (!isRightFormat(ENG_KOR_FORMAT, rawPlayerName)) {
            throw new IllegalArgumentException(FORMAT_EXCEPTION_MESSAGE);
        }
    }

    public static void validatePlayerHpAndMp(String rawPlayerHpAndMp) {
        if (isBlank(rawPlayerHpAndMp)) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
        if (!isRightFormat(NUMBER_COMMA_TWO_COUNT_FORMAT, rawPlayerHpAndMp)) {
            throw new IllegalArgumentException(FORMAT_EXCEPTION_MESSAGE);
        }
    }

    public static void validateAttackType(String rawAttackType) {
        if (isBlank(rawAttackType)) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
        if (!isRightFormat(NUMBER_FORMAT, rawAttackType)) {
            throw new IllegalArgumentException(FORMAT_EXCEPTION_MESSAGE);
        }
    }


    /**
     * 공백 및 빈 문자열 체크
     * 주로 사용자 입력으로 부터의 검증이기에 빈문자열 혹은 공백 위주로 검증
     */
    private static boolean isBlank(String input) {
        return input.isBlank();
    }

    /**
     * 이상적인 형식인지 체크
     */
    private static boolean isRightFormat(Pattern pattern, String input) {
        return pattern.matcher(input).matches();
    }


}
