package bossmonster.common;

public class MonsterImage {
    public static final String MONSTER_IMAGE_HEAD = "   ^-^";
    public static final String MONSTER_IMAGE_EYE_START = " / 0 0 \\";
    public static final String MONSTER_IMAGE_MOUTH_START = "(   \"   )";
    public static final String MONSTER_IMAGE_BELLY_START = " \\  -  /";
    public static final String MONSTER_IMAGE_FEET = "  - ^ -";
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

}
