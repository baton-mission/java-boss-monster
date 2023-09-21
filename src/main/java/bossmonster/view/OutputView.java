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
		System.out.printf(Message.HP_STATUS_FORMAT.toString(),
				player.getName(),
				player.getCurHp(),
				player.getStartHp(),
				player.getCurMp(),
				player.getStartMp());
	}
}
