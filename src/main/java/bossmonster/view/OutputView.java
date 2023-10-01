package bossmonster.view;

import bossmonster.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;

public class OutputView {

    public static void bossDefault(BossMonster bossMonster, Player player) {
        System.out.println("============================");
        System.out.println("BOSS HP [" + bossMonster.getCurrentHp() + "/" +
                bossMonster.getMaxHp() + "]");
        System.out.println("____________________________");
        System.lineSeparator();
        System.out.println("   ^-^");
        System.out.println(" / 0 0 \\");
        System.out.println("(   \"   )");
        System.out.println(" \\  -  /");
        System.out.println("  - ^ -");
        System.lineSeparator();
        System.out.println("____________________________");
        System.lineSeparator();
        System.out.println(player.getName() + " HP [" + player.getCurrentHp()
                + "/" + player.getMaxHp() + "] MP [" + player.getCurrentMp() + "/"
                + player.getMaxMp() + "]");
    }

    public static void bossSad(BossMonster bossMonster, Player player) {
        System.out.println("============================");
        System.out.println("BOSS HP [" + bossMonster.getCurrentHp() + "/" +
                bossMonster.getMaxHp() + "]");
        System.out.println("____________________________");
        System.lineSeparator();
        System.out.println("   ^-^");
        System.out.println(" / x x \\");
        System.out.println("(   \"\\   )");
        System.out.println(" \\  ^  /");
        System.out.println("  - ^ -");
        System.lineSeparator();
        System.out.println("____________________________");
        System.lineSeparator();
        System.out.println(player.getName() + " HP [" + player.getCurrentHp()
                + "/" + player.getMaxHp() + "] MP [" + player.getCurrentMp() + "/"
                + player.getMaxMp() + "]");
    }

    public static void bossHappy(BossMonster bossMonster, Player player) {
        System.out.println("============================");
        System.out.println("BOSS HP [" + bossMonster.getCurrentHp() + "/" +
                bossMonster.getMaxHp() + "]");
        System.out.println("____________________________");
        System.lineSeparator();
        System.out.println("   ^-^");
        System.out.println(" / ^ ^ \\");
        System.out.println("(   \"   )");
        System.out.println(" \\  -  /");
        System.out.println("  - ^ -");
        System.lineSeparator();
        System.out.println("____________________________");
        System.lineSeparator();
        System.out.println(player.getName() + " HP [" + player.getCurrentHp()
                + "/" + player.getMaxHp() + "] MP [" + player.getCurrentMp() + "/"
                + player.getMaxMp() + "]");
    }

    public static void playerWin(Player player, int count) { // shoild i get name by string?
        System.out.println(player.getName() + "won after " + count + " turn");
    }

    public static void bossMonsterWin(Player player, int count) {
        System.out.println(player.getName() + " lost after " + count + " turn");
    }

    public static void damageByBossMonster(int damage) {
        System.out.println("Attack by boss (damage : " + damage + ")");
    }

    public static void damageByPlayer(AttackType attackType) {
        System.out.println("Magical Attack! (damage : " + attackType.getDamage() + ")");
    }
}
