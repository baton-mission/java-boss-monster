package bossmonster.view;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class InputProcessorByScanner implements InputProcessor {
    private Scanner sc = new Scanner(System.in);
    private final Random random = new Random();

    @Override
    public int getInt() {
        while (true) {
            sc = new Scanner(System.in);
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] 숫자를 입력하세요.");
            }
        }
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
