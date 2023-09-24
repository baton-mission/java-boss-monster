package bossmonster.view;

import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	private InputView() {
	}

	public static int readBossHp() {
		String hp = scanner.next();
		validateBlank(hp);
		return toInteger(hp);
	}

	public static String readPlayer() {
		String playerName = scanner.next();
		validateBlank(playerName);
		return playerName;
	}

	public static String readPlayerHpAndMp() {
		String hpAndMp = scanner.next();
		validateBlank(hpAndMp);
		return hpAndMp;
	}

	public static String readAttackType() {
		String type = scanner.next();
		validateBlank(type);
		return type;
	}

	private static void validateBlank(String input) {
		if (input.isBlank()) {
			throw new IllegalArgumentException("[ERROR] 값을 입력해야 합니다.");
		}
	}

	private static Integer toInteger(String number) {
		try {
			return Integer.valueOf(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
		}
	}
}
