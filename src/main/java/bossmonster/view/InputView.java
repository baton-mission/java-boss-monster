package bossmonster.view;

import static bossmonster.constant.AttackConstant.*;
import static bossmonster.constant.MonsterConstant.*;
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
		int monsterHp;
		String input = input();

		try {
			monsterHp = Integer.parseInt(input);

			if (monsterHp < MONSTER_MIN_HP.getMonsterConstant() || monsterHp > MONSTER_MAX_HP.getMonsterConstant()) {
				throw new IllegalArgumentException();
			}

			return monsterHp;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static String readPlayerName() {
		String playerName = input();
		if (playerName.length() > LENGTH_OF_NAME.getConstant()) {
			throw new IllegalArgumentException();
		}
		return playerName;
	}

	public static List<Integer> readPlayerHpMp() {
		List<Integer> playerHpMp;
		String input = input();

		try {
			playerHpMp = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
			if (playerHpMp.size() != COUNT_OF_HP_MP.getConstant())
				throw new IllegalArgumentException();
			if (playerHpMp.stream().mapToInt(Integer::valueOf).sum() != SUM_OF_HP_MP.getConstant())
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

			if (whetherAttack != MAGIC.getAttackInt() && whetherAttack != PHYSICAL.getAttackInt()) {
				throw new IllegalArgumentException();
			}

			return whetherAttack;
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
}
