package bossmonster.view;

import bossmonster.message.ErrorMessage;
import bossmonster.message.InputMessage;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private Scanner sc;

    public InputView(Scanner sc) {
        this.sc = sc;
    }

    public int askBossMonsterHP() {
        print(InputMessage.MONSTER_HP.getMessage());
        return getInt();
    }

    public String askPlayerName() {
        print(InputMessage.PLAYER_NAME.getMessage());
        return getString();
    }

    public String askPlayerHPAndMP() {
        System.out.println(InputMessage.PLAYER_HP_AND_MP.getMessage());
        return getString();
    }

    public String askSkillNo() {
        print(InputMessage.SKILL_LIST.getMessage());
        return getString();
    }

    private void print(String message) {
        System.out.println(message);
    }

    private String getString() {
        String str = sc.nextLine();
        validateBlank(str);
        return str;
    }

    private void validateBlank(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessage.getErrorMessage(ErrorMessage.NOT_BLANK));
        }
    }

    private int getInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException ignored) {
            throw new IllegalArgumentException(
                    ErrorMessage.getErrorMessage(ErrorMessage.NOT_NUMBER));
        }
    }
}
