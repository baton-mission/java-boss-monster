package bossmonster.common;

public class MonsterImage {
    public static final String MONSTER_IMAGE_HEAD = "   ^-^";
    public static final String MONSTER_IMAGE_EYE_START = " / 0 0 \\";
    public static final String MONSTER_IMAGE_MOUTH_START = "(   \"   )";
    public static final String MONSTER_IMAGE_BELLY_START = " \\  -  /";
    public static final String MONSTER_IMAGE_FEET = "  - ^ -";
    private static final String MONSTER_IMAGE_EYE_DAMAGED = " / x x \\";
    private static final String MONSTER_IMAGE_MOUTH_DAMAGED = "(   \"\\  )";
    private static final String MONSTER_IMAGE_BELLY_DAMAGED = " \\  ^  /";
    private static final String MONSTER_IMAGE_EYE_WINNING = " / ^ ^ \\";
    private static final String MONSTER_IMAGE_MOUTH_WINNING = "(   \"   )";
    private static final String MONSTER_IMAGE_BELLY_WINNING = " \\  3  /";
    public static final String MONSTER_IMAGE_START =
            MONSTER_IMAGE_HEAD
                    + System.lineSeparator()
                    + MONSTER_IMAGE_EYE_START
                    + System.lineSeparator()
                    + MONSTER_IMAGE_MOUTH_START
                    + System.lineSeparator()
                    + MONSTER_IMAGE_BELLY_START
                    + System.lineSeparator()
                    + MONSTER_IMAGE_FEET;
    public static final String MONSTER_IMAGE_DAMAGED =
            MONSTER_IMAGE_HEAD
                    + System.lineSeparator()
                    + MONSTER_IMAGE_EYE_DAMAGED
                    + System.lineSeparator()
                    + MONSTER_IMAGE_MOUTH_DAMAGED
                    + System.lineSeparator()
                    + MONSTER_IMAGE_BELLY_DAMAGED
                    + System.lineSeparator()
                    + MONSTER_IMAGE_FEET;
    public static final String MONSTER_IMAGE_WINNING =
            MONSTER_IMAGE_HEAD
                    + System.lineSeparator()
                    + MONSTER_IMAGE_EYE_WINNING
                    + System.lineSeparator()
                    + MONSTER_IMAGE_MOUTH_WINNING
                    + System.lineSeparator()
                    + MONSTER_IMAGE_BELLY_WINNING
                    + System.lineSeparator()
                    + MONSTER_IMAGE_FEET;

}
