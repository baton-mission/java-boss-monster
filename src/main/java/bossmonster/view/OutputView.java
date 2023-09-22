package bossmonster.view;

import bossmonster.message.ExceptionMessage;
import bossmonster.message.ViewMessage;
import bossmonster.domain.boss.Boss;
import bossmonster.domain.GameOption;
import bossmonster.domain.player.Player;

import java.util.List;

public class OutputView {
	public static void printError(IllegalArgumentException e) {
		System.out.println(ExceptionMessage.ERROR_PREFIX + e.getMessage());
	}

	public static void printRadeStart() {
		System.out.println(ViewMessage.START_RADE);
	}

	public static void printRadeInfo(Boss boss, Player player) {
		OutputView.printDoubleDiv();
		OutputView.printBoss(boss);
		OutputView.printPlayer(player);
		OutputView.printDoubleDiv();
	}

	private static void printDoubleDiv() {
		System.out.println(ViewMessage.DOUBLE_DIV);
	}

	private static void printBoss(Boss boss) {
		List<Integer> hp = boss.getHp();
		System.out.printf(ViewMessage.HP_STATUS_FORMAT.toString(),
				boss.getName(),
				hp.get(GameOption.CURRENT_POINT_IDX),
				hp.get(GameOption.START_POINT_IDX));
		System.out.println(ViewMessage.DIV);
		System.out.println(boss.getStatusImg());
		System.out.println(ViewMessage.DIV);
	}

	private static void printPlayer(Player player) {
		System.out.println();
		List<Integer> hp = player.getHp();
		List<Integer> mp = player.getMp();
		System.out.printf(ViewMessage.HP_AND_MP_STATUS_FORMAT.toString(),
				player.getName(),
				hp.get(GameOption.CURRENT_POINT_IDX),
				hp.get(GameOption.START_POINT_IDX),
				mp.get(GameOption.CURRENT_POINT_IDX),
				mp.get(GameOption.START_POINT_IDX));
	}

	public static void printPlayerAttackResult(int playerToBossDamage, Player player) {
		System.out.printf(ViewMessage.PLAYER_ATTACK_FORMAT.toString(),
				player.getAttackTypeName(),
				playerToBossDamage);
	}

	public static void printBossAttackResult(int bossToPlayerDamage) {
		System.out.printf(ViewMessage.BOSS_ATTACK_FORMAT.toString(),
				bossToPlayerDamage);
	}

	public static void printRadeWin(Player player) {
		System.out.println();
		System.out.printf(ViewMessage.RADE_WIN_FORMAT.toString(),
				player.getName(),
				player.getAttackCount());
	}

	public static void printRadeLoss(Player player) {
		System.out.println();
		System.out.printf(ViewMessage.RADE_LOSS_FORMAT.toString(), player.getName());
	}
}
