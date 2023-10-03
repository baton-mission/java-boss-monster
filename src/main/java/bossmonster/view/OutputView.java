package bossmonster.view;

public class OutputView {
    private static final String PRINT_START_RAID = "보스 레이드를 시작합니다!";
    private static final String PRINT_TWO_LINE = "============================";
    private static final String PRINT_BOSS_START_IMAGE =
                    "____________________________\n" +
                    "   ^-^\n" +
                    " / 0 0 \\\n" +
                    "(   \"   )\n" +
                    " \\  -  /\n" +
                    "  - ^ -" +
                    "____________________________\n";
    private static final String PRINT_BOSS_ATTACKED_IMAGE =
                    "____________________________\n" +
                    "   ^-^\n" +
                    " / x x \\\n" +
                    "(   \"   )\n" +
                    " \\  -  /\n" +
                    "  - ^ -" +
                    "____________________________\n";

    public void printStartRaid() {
        System.out.println(PRINT_START_RAID);
    }

    public void printBossHP(int HP, int maxHP) {
        System.out.println(PRINT_TWO_LINE);
        System.out.println("BOSS HP  [" + HP + "/" + maxHP + "]");
    }

    public void printPlayerHPAndMP(String name, int HP, int maxHP, int MP, int maxMP) {
        System.out.println(name + " HP [" + HP + "/" + maxHP + "] " + " MP [" + MP + "/" + maxMP + "]");
        System.out.println(PRINT_TWO_LINE);
    }

    public void printBossStartImage() {
        System.out.println(PRINT_BOSS_START_IMAGE);
    }

    public void printBossAttackedImage() {
        System.out.println(PRINT_BOSS_ATTACKED_IMAGE);
    }
}