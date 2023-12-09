package bossmonster.common;

public class MonsterImage {
    private MonsterImage() {
    }

    private static final String HEAD = "   ^-^";
    private static final String EYE_START = " / 0 0 \\";
    private static final String EYE_DAMAGED = " / x x \\";
    private static final String EYE_WINNING = " / ^ ^ \\";
    private static final String MOUTH_START = "(   \"   )";
    private static final String MOUTH_DAMAGED = "(   \"\\  )";
    private static final String MOUTH_WINNING = "(   \"   )";
    private static final String BELLY_START = " \\  -  /";
    private static final String BELLY_DAMAGED = " \\  ^  /";
    private static final String BELLY_WINNING = " \\  3  /";
    private static final String FEET = "  - ^ -";

    // 이미지 생성 메서드
    private static String generateMonsterImage(String head, String eye, String mouth, String belly, String feet) {
        return head
                + System.lineSeparator()
                + eye
                + System.lineSeparator()
                + mouth
                + System.lineSeparator()
                + belly
                + System.lineSeparator()
                + feet;
    }

    public static String generateMonsterImageStart() {
        return generateMonsterImage(HEAD, EYE_START, MOUTH_START, BELLY_START, FEET);
    }

    public static String generateMonsterImageDamaged() {
        return generateMonsterImage(HEAD, EYE_DAMAGED, MOUTH_DAMAGED, BELLY_DAMAGED, FEET);
    }

    public static String generateMonsterImageWinning() {
        return generateMonsterImage(HEAD, EYE_WINNING, MOUTH_WINNING, BELLY_WINNING, FEET);
    }
}
