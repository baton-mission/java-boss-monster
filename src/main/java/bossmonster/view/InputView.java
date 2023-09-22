package bossmonster.view;

import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	private InputView() {
	}

	public static int readBossHp() {
		String hp = scanner.next();
		validateBlank(hp);
		return Integer.parseInt(hp);
	}

	public static String readPlayer() {
		String playerName = scanner.next();
		validateBlank(playerName);
		return playerName;
	}

	private static void validateBlank(String input) {
		if (input.isBlank()) {
			throw new IllegalArgumentException("[ERROR] 값을 입력해야 합니다.");
		}
	}
}
