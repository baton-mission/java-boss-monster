package bossmonster.view;

public class OutputView {
    private static final String PRINT_START_RAID = "보스 레이드를 시작합니다!";
    private static final String PRINT_TWO_LINE = "============================";
    private static final String PRINT_MAGICAL_ATTACK = "마법 공격을 했습니다. (입힌 데미지: 20)";
    private static final String PRINT_PHYSICAL_ATTACK = "물리 공격을 했습니다. (입힌 데미지: 10)";
    private static final String PRINT_END_RAID = "번의 전투 끝에 보스 몬스터를 잡았습니다.";
    private static final String PRINT_BOSS_ATTACK = "보스가 공격 했습니다. (입힌 데미지: ";
    private static final String PRINT_FAILED_RAID = "의 HP가 0이 되었습니다. \n보스 레이드에 실패했습니다.";
    private static final String PRINT_CANT_USE_MAGICAL_ATTACK = "MP가 부족해 마법 공격을 할 수 없습니다.";
    private static final String PRINT_BOSS_START_IMAGE =
                    "____________________________\n" +
                    "   ^-^\n" +
                    " / 0 0 \\\n" +
                    "(   \"   )\n" +
                    " \\  -  /\n" +
                    "  - ^ -\n" +
                    "____________________________\n";
    private static final String PRINT_BOSS_ATTACKED_IMAGE =
                    "____________________________\n" +
                    "   ^-^\n" +
                    " / x x \\\n" +
                    "(   \"   )\n" +
                    " \\  -  /\n" +
                    "  - ^ -\n"+
                    "____________________________\n";
    private static final String PRINT_BOSS_WIN_IMAGE =
                    "____________________________\n" +
                    "   ^-^\n" +
                    " / ^ ^ \\\n" +
                    "(   \"   )\n" +
                    " \\  3  /\n" +
                    "  - ^ -\n" +
                    "____________________________";

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

    public void printBossWinImage() {
        System.out.println(PRINT_BOSS_WIN_IMAGE);
    }

    public void printBossAttack(int number) {
        System.out.println(PRINT_BOSS_ATTACK + number + ")");
    }

    public void printMagicalAttack() {
        System.out.println(PRINT_MAGICAL_ATTACK);
    }

    public void printPhysicalAttack() {
        System.out.println(PRINT_PHYSICAL_ATTACK);
    }

    public void printEndRaid(String name, int number) {
        System.out.println(name + "님이 " +number + PRINT_END_RAID);
    }

    public void printFailedRaid(String name) {
        System.out.println(name + PRINT_FAILED_RAID);
    }

    public void printCantUseMagicalAttack() {
        System.out.println(PRINT_CANT_USE_MAGICAL_ATTACK);
    }
}