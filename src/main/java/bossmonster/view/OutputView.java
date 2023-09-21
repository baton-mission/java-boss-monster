package bossmonster.view;

import bossmonster.ExceptionMessage;
import bossmonster.Message;
import bossmonster.domain.Boss;
import bossmonster.domain.Player;

public class OutputView {
	public static void printError(IllegalArgumentException e) {
		System.out.println(ExceptionMessage.ERROR_PREFIX + e.getMessage());
	}

	public static void printRadeStart() {
		System.out.println(Message.START_RADE);
	}


	public static void printDoubleDiv() {
		System.out.println(Message.DOUBLE_DIV);
	}

	public static void printBoss(Boss boss) {
		System.out.printf(Message.HP_STATUS_FORMAT.toString(),
				boss.getName(),
				boss.getCurHp(),
				boss.getStartHp());
		System.out.println(Message.DIV);
		System.out.println(boss.getStatusImg());
		System.out.println(Message.DIV);
	}

	public static void printPlayer(Player player) {
		System.out.printf(Message.HP_AND_MP_STATUS_FORMAT.toString(),
				player.getName(),
				player.getCurHp(),
				player.getStartHp(),
				player.getCurMp(),
				player.getStartMp());
	}

	public static void printPlayerAttackResult(int playerToBossDamage, Player player) {
		System.out.printf(Message.PLAYER_ATTACK_FORMAT.toString(),
				player.getAttackTypeName(),
				playerToBossDamage);
	}

	public static void printBossAttackResult(int bossToPlayerDamage) {
		System.out.printf(Message.BOSS_ATTACK_FORMAT.toString(),
				bossToPlayerDamage);
	}
}
