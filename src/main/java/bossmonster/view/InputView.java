package bossmonster.view;

import static bossmonster.utils.ErrorMessage.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final String DELIMITER = ",";
    private static final Pattern NUMBER_FORMAT = Pattern.compile("^\\d+$");
    private static final Pattern VALID_DELIMITER_FORMAT = Pattern.compile("^\\d+,\\d+$");

    public static int readBossMonsterHp(Scanner scanner) {
        System.out.println("보스 몬스터의 HP를 입력해주세요.");
        String inputHp = scanner.nextLine();
        if (isNotNumber(inputHp)) {
            throw new NumberFormatException(ERROR_NUMBER_FORMAT);
        }
        return toInt(inputHp);
    }

    private static boolean isNotNumber(String inputHp) {
        return !NUMBER_FORMAT.matcher(inputHp).matches();
    }

    public static String readPlayerName(Scanner scanner) {
        System.out.println("플레이어의 이름을 입력해주세요.");
        return scanner.nextLine();
    }

    public static List<Integer> readPlayerInitialHpAndMp(Scanner scanner) {
        System.out.println("플레이어의 HP와 MP를 입력해주세요.(,로 구분)");
        String inputPlayerInitialHpAndMp = scanner.nextLine();
        if (!VALID_DELIMITER_FORMAT.matcher(inputPlayerInitialHpAndMp).matches()) {
            throw new IllegalArgumentException(ERROR_INPUT_FORMAT);
        }
        return Arrays.stream(inputPlayerInitialHpAndMp
                        .split(DELIMITER))
                .map(InputView::toInt)
                .toList();
    }

    public static int readPlayerAttackNumber(Scanner scanner) {
        System.out.println("어떤 공격을 하시겠습니까?\n" +
                           "1. 물리 공격\n" +
                           "2. 마법 공격");
        String inputPlayerAttackNumber = scanner.nextLine();
        if (isNotNumber(inputPlayerAttackNumber)) {
            throw new NumberFormatException(ERROR_NUMBER_FORMAT);
        }
        return toInt(inputPlayerAttackNumber);
    }

    private static int toInt(String string) {
        return Integer.parseInt(string);
    }
}
