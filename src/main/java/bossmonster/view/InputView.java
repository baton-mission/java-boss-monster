package bossmonster.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class InputView {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static String input() {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static int readMonsterHp() {

		return 0;
	}

	public static String readPlayerName() {
		return null;
	}

	public static List<Integer> readPlayerHpMp() {
		return null;
	}

	public static int readWhetherAttack() {
		return 0;
	}
}
