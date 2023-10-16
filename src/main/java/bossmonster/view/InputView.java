package bossmonster.view;

import bossmonster.message.ErrorMessage;
import bossmonster.message.InputMessage;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    public static final String LINE_BREAK = "\n";
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
        return getPlayerHPandMP();
    }

    private String getPlayerHPandMP() {
        String regex = "(\\d{1,}),(\\d{1,})";
        String str = sc.nextLine();
        if (!Pattern.matches(regex, str)) {
            throw new IllegalArgumentException(
                    ErrorMessage.getErrorMessage(ErrorMessage.WRONG_PLAYER_HP_MP_FORMAT));
        }
        return str;
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
                    ErrorMessage.getErrorMessage(ErrorMessage.NOT_BLANCK));
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
