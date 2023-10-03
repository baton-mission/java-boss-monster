package bossmonster.util;

import java.util.Random;

public class GenerateRandomNumber {

    public static int getRandomNumber(
            int minimumNumber,
            int maximumNumber
    ) {
        Random random = new Random();
        return random.nextInt(maximumNumber - minimumNumber + 1) + minimumNumber;
    }
}
