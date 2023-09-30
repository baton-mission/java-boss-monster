package bossmonster.view;

import bossmonster.domain.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;

public class OutputView {

    private final int PHYSICAL_ATTACK = 1;
    private final int MAGIC_ATTACK = 2;
    private final int BOSS_NORMAL = 100;
    private final int BOSS_DAMAGED = 101;
    private final int BOSS_WIN = 102;
    private final String PREFIX = "[ERROR] ";

    public void printBattleStartView() {
        System.out.println("\n보스 레이드를 시작합니다!\n");
    }

    public void printPlayerPhaseView(AttackType attackType) {
        if (attackType.getTypeNum() == PHYSICAL_ATTACK) {
            System.out.println("\n물리 공격을 했습니다. (입힌 대미지: " + attackType.getDamage() + ")");
        }

        if (attackType.getTypeNum() == MAGIC_ATTACK) {
            System.out.println("\n마법 공격을 했습니다. (입힌 대미지: " + attackType.getDamage() + ")");
        }
    }
    public void printBossPhaseView(int bossDamage) {
        System.out.println("보스가 공격했습니다. (입힌 대미지: " + bossDamage + ")\n");
    }

    public void printEndGameByVictoryView(Player player, int turnCount) {
        System.out.println("\n" + player.getName() + " 님이 " + turnCount + "번의 전투 끝에 보스 몬스터를 잡았습니다.");
    }

    public void printEndGameByDefeatView(Player player, BossMonster bossMonster, int turnCount) {
        printBattleInfoView(player, bossMonster, turnCount);
        System.out.println(player.getName() + "의 HP가 0이 되었습니다");
        System.out.println("보스 레이드에 실패했습니다.");
    }

    public void printBattleInfoView(Player player, BossMonster bossMonster, int turnCount) {
        System.out.println("============================");
        System.out.println("BOSS HP [" + bossMonster.getHp() + "/" + bossMonster.getMaxHp() + "]");
        System.out.println("____________________________");

        if (turnCount == 1) {
            printBossMonsterView(BOSS_NORMAL);
        }

        if (turnCount > 1 && player.getHp() > 0) {
            printBossMonsterView(BOSS_DAMAGED);
        }

        if (turnCount > 1 && player.getHp() == 0) {
            printBossMonsterView(BOSS_WIN);
        }

        System.out.println("____________________________");
        System.out.println(player.getName()
                + " HP [" + player.getHp() + "/" + player.getMaxHp()
                + "] MP [" + player.getMp() + "/" + player.getMaxMp() +"]");
        System.out.println("============================\n");
    }

    public void printBossHpException() {
        System.out.println(PREFIX + "보스 체력은 100이상, 300이하여야합니다.");
    }

    public void printPlayerNameException() {
        System.out.println(PREFIX + "플레이어의 이름은 5자 이하만 가능합니다.");
    }

    public void printPlayerStatusException() {
        System.out.println(PREFIX + "HP는 1이상, HP와 MP의 합이 200이 되도록 입력해주세요.");
    }

    public void printAttackTypeException() {
        System.out.println(PREFIX + "1 또는 2를 입력해주세요.");
    }

    public void printLackOfMPException() {
        System.out.println(PREFIX + "마법 공격에 필요한 MP가 부족합니다.");
    }


    private void printBossMonsterView(int bossCondition) {
        if (bossCondition == BOSS_NORMAL) {
            System.out.println("   ^-^\n / 0 0 \\\n(   \"   )\n \\  -  /\n  - ^ -");
        }

        if (bossCondition == BOSS_DAMAGED) {
            System.out.println("   ^-^\n / x x \\\n(   \"   )\n \\  -  /\n  - ^ -");

        }

        if (bossCondition == BOSS_WIN) {
            System.out.println("   ^-^\n / ^ ^ \\\n(   \"   )\n \\  -  /\n  - ^ -");

        }
    }
}
