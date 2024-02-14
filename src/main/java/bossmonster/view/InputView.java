package bossmonster.view;

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
		int monsterHp;
		String input = input();

		try {
			monsterHp = Integer.parseInt(input);

			if (monsterHp < 100 || monsterHp > 300) {
				throw new IllegalArgumentException();
			}

			return monsterHp;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static String readPlayerName() {
		String playerName = input();
		if (playerName.length() > 5) {
			throw new IllegalArgumentException();
		}
		return playerName;
	}

	public static List<Integer> readPlayerHpMp() {
		List<Integer> playerHpMp;
		String input = input();

		try {
			playerHpMp = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
			if (playerHpMp.size() != 2)
				throw new IllegalArgumentException();
			if (playerHpMp.stream().mapToInt(Integer::valueOf).sum() != 200)
				throw new IllegalArgumentException();

			return playerHpMp;
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static int readWhetherAttack() {
		int whetherAttack;
		String input = input();

		try {
			whetherAttack = Integer.parseInt(input);

			if (whetherAttack != 1 && whetherAttack != 2) {
				throw new IllegalArgumentException();
			}

			return whetherAttack;
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
}
