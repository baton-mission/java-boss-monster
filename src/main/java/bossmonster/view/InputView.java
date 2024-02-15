package bossmonster.view;

import static bossmonster.view.message.ErrorMessage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {
	public static BufferedReader br;

	private static String input() {
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static int readMonsterHp() {
		String input = input();
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MUST_INTEGER_BUT_NOT.getMessage());
		}
	}

	public static String readPlayerName() {
		return input();
	}

	public static List<Integer> readPlayerHpMp() {
		List<Integer> playerHpMp;
		String input = input();

		try {
			playerHpMp = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MUST_INTEGER_BUT_NOT.getMessage());
		}

		return playerHpMp;
	}

	public static int readWhetherAttack() {
		int whetherAttack;
		String input = input();

		try {
			whetherAttack = Integer.parseInt(input);

			// if (whetherAttack != MAGIC.getAttackInt() && whetherAttack != PHYSICAL.getAttackInt()) {
			// 	throw new IllegalArgumentException();
			// }

			return whetherAttack;
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
}
