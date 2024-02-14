package bossmonster.view;

import static bossmonster.constant.AttackConstant.*;
import static bossmonster.constant.PlayerConstant.*;

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
		return Integer.parseInt(input);
	}

	public static String readPlayerName() {
		return input();
	}

	public static List<Integer> readPlayerHpMp() {
		List<Integer> playerHpMp;
		String input = input();

		playerHpMp = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
		if (playerHpMp.size() != COUNT_OF_HP_MP.getConstant())
			throw new IllegalArgumentException();

		return playerHpMp;
	}

	public static int readWhetherAttack() {
		int whetherAttack;
		String input = input();

		try {
			whetherAttack = Integer.parseInt(input);

			if (whetherAttack != MAGIC.getAttackInt() && whetherAttack != PHYSICAL.getAttackInt()) {
				throw new IllegalArgumentException();
			}

			return whetherAttack;
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
}
