package bossmonster.view;

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

	public static void printBossHpStatus(int hp) {
		System.out.print(LINE_BREAK);
		System.out.println("============================");
		System.out.println("BOSS HP [" + hp + "/" + hp + "]");
	}

	public static void printCommonBossImage() {
		System.out.println("____________________________");
		System.out.println("   ^-^\n"
			+ " / 0 0 \\\n"
			+ "(   \"   )\n"
			+ " \\  -  /\n"
			+ "  - ^ -");
		System.out.println("____________________________");
	}

	public static void printPlayerHealthStatus(String name) {
		System.out.print(LINE_BREAK);
		System.out.println(name + " HP [100/100] MP [100/100]");
		System.out.println("============================");
	}
}
