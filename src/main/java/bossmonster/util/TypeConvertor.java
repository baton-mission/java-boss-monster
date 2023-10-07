package bossmonster.util;

import static bossmonster.util.Constants.SPLIT_UNIT;
import static bossmonster.util.ErrorMessage.ERROR;
import static bossmonster.util.ErrorMessage.NUMERIC;

public class TypeConvertor {

    public static int[] convertStringToInt(String input) {
        int[] temp = new int[2];
        String[] split = input.split(SPLIT_UNIT);
        try {
            temp[0] = Integer.parseInt(split[0]);
            temp[1] = Integer.parseInt(split[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + NUMERIC);
        }
        return temp;
    }
}
