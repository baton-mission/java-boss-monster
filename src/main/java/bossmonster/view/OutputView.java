package bossmonster.view;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Health;
import bossmonster.domain.Player;

public class OutputView {

	private static final String LINE_BREAK = "\n";

	private OutputView() {
	}

	public static void printBossHp() {
		System.out.println("보스 몬스터의 HP를 입력해주세요.");
	}

	public static void printPlayerName() {
		System.out.print(LINE_BREAK);
		System.out.println("플레이어의 이름을 입력해주세요.");
	}

	public static void printPlayerHpAndMp() {
		System.out.print(LINE_BREAK);
		System.out.println("플레이어의 HP와 MP를 입력해주세요.(,로 구분)");
	}

	public static void printStartRaidMessage() {
		System.out.print(LINE_BREAK);
		System.out.println("보스 레이드를 시작합니다!");
	}

	public static void printGameStatus(BossMonster bossMonster, Player player) {
		printBossHpStatus(bossMonster.remainedBossHp());
		printCommonBossImage();
		printPlayerHealthStatus(player.getName(), player.getHealth());
	}

	private static void printBossHpStatus(int hp) {
		System.out.print(LINE_BREAK);
		System.out.println("============================");
		System.out.println("BOSS HP [" + hp + "/100]");
	}

	private static void printCommonBossImage() {
		System.out.println("____________________________");
		System.out.println("   ^-^\n"
			+ " / 0 0 \\\n"
			+ "(   \"   )\n"
			+ " \\  -  /\n"
			+ "  - ^ -");
		System.out.println("____________________________");
	}

	private static void printPlayerHealthStatus(String name, Health health) {
		System.out.print(LINE_BREAK);
		System.out.println(name + " HP [" + health.getHp() + "/100] MP [" + health.getMp() + "/100]");
		System.out.println("============================");
	}

	public static void printAttackType() {
		System.out.println(LINE_BREAK);
		System.out.println("어떤 공격을 하시겠습니까?");
		System.out.println("1. 물리 공격");
		System.out.println("2. 마법 공격");
	}
}
