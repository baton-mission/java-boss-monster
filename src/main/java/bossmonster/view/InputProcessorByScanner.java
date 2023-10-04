package bossmonster.view;

import java.util.Random;
import java.util.Scanner;

public class InputProcessorByScanner implements InputProcessor {
    private final Scanner sc = new Scanner(System.in);
    private final Random random = new Random();

    @Override
    public int getInt() {
        return sc.nextInt();
    }

    @Override
    public String getString() {
        return sc.next();
    }

    @Override
    public int getRandomInt(int bound) {
        return random.nextInt(bound);
    }
}
