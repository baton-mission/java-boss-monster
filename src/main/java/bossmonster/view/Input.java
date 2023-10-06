package bossmonster.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    private Scanner sc;

    public Input(Scanner sc) {
        this.sc = sc;
    }

    public String enterText() {
        return sc.nextLine();
    }
    public int enterNumber() {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ignored) {
                throw new IllegalArgumentException("[ERROR] 보스 몬스터 HP는 숫자여야 합니다.");            }
    }
}
