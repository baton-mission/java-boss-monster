package bossmonster.controller.dto;

import bossmonster.message.ErrorMessage;
import java.util.regex.Pattern;

public class PlayerStatsDto {


    private static final String REGEX = "(\\d{1,}),(\\d{1,})";
    private static final String COMMA_DELIMITER = ",";
    private static final int PLAYER_HP_INDEX = 0;
    private static final int PLAYER_MP_INDEX = 1;
    private int hp;
    private int mp;

    private PlayerStatsDto(int hp, int mp) {
        this.hp = hp;
        this.mp = mp;
    }
    public static PlayerStatsDto of(String stats) {
        validate(stats);
        String[] statsValues = stringToStringArray(stats);
        int hp = Integer.parseInt(statsValues[PLAYER_HP_INDEX]);
        int mp = Integer.parseInt(statsValues[PLAYER_MP_INDEX]);
        return new PlayerStatsDto(hp,mp);
    }

    private static void validate(String stats) {
        if (!Pattern.matches(REGEX, stats)) {
            throw new IllegalArgumentException(
                    ErrorMessage.getErrorMessage(ErrorMessage.WRONG_PLAYER_HP_MP_FORMAT));
        }
    }
    private static String[] stringToStringArray(String stats) {
        return stats.split(COMMA_DELIMITER);
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }
}
