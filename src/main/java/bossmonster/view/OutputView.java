package bossmonster.view;

import bossmonster.domain.AttackType;
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

	public static void printStartGameStatus(BossMonster bossMonster, Player player) {
		printBossHpStatus(bossMonster.remainedBossHp());
		printStartBossImage();
		printPlayerHealthStatus(player.getName(), player.getHealth());
	}

	public static void printPlayGameStatus(BossMonster bossMonster, Player player) {
		printBossHpStatus(bossMonster.remainedBossHp());
		printHitBossImage();
		printPlayerHealthStatus(player.getName(), player.getHealth());
	}

	public static void printFailGameStatus(BossMonster bossMonster, Player player) {
		printBossHpStatus(bossMonster.remainedBossHp());
		printFailBossImage();
		printPlayerHealthStatus(player.getName(), player.getHealth());
	}

	private static void printBossHpStatus(int hp) {
		System.out.print(LINE_BREAK);
		System.out.println("============================");
		System.out.println("BOSS HP [" + hp + "/100]");
	}

	private static void printPlayerHealthStatus(String name, Health health) {
		System.out.print(LINE_BREAK);
		System.out.println(name + " HP [" + "0/100] MP [" + health.getMp() + "/100]");
		System.out.println("============================");
	}

	public static void printAttackType() {
		System.out.println(LINE_BREAK);
		System.out.println("어떤 공격을 하시겠습니까?");
		System.out.println("1. 물리 공격");
		System.out.println("2. 마법 공격");
	}

	public static void printPlayerAttackDamage(AttackType attackType) {
		System.out.print(LINE_BREAK);
		System.out.println(attackType.getAttackName() + "을 했습니다. (입힌 데미지: " + attackType.getDamage() + ")");
	}

	public static void printBossAttackDamage(int damage) {
		System.out.println("보스가 공격 했습니다. (입힌 데미지: " + damage + ")");
	}

	private static void printStartBossImage() {
		System.out.println("____________________________");
		System.out.println("   ^-^\n"
			+ " / 0 0 \\\n"
			+ "(   \"   )\n"
			+ " \\  -  /\n"
			+ "  - ^ -");
		System.out.println("____________________________");
	}

	private static void printHitBossImage() {
		System.out.println("____________________________");
		System.out.println("   ^-^\n"
			+ " / x x \\\n"
			+ "(   \"\\  )\n"
			+ " \\  ^  /\n"
			+ "  - ^ -");
		System.out.println("____________________________");
	}

	private static void printFailBossImage() {
		System.out.println("____________________________");
		System.out.println("   ^-^\n"
			+ " / ^ ^ \\\n"
			+ "(   \"   )\n"
			+ " \\  3  /\n"
			+ "  - ^ -");
		System.out.println("____________________________");
	}

	public static void printRaidSuccessMessage(String name, int count) {
		System.out.print(LINE_BREAK);
		System.out.println(name + " 님이 " + count + "번의 전투 끝에 보스 몬스터를 잡았습니다.");
	}

	public static void printPlayerHpZero(String name) {
		System.out.println(LINE_BREAK);
		System.out.println(name + "의 HP가 0이 되었습니다.");
		System.out.println("보스 레이드에 실패하였습니다.");
	}
}
