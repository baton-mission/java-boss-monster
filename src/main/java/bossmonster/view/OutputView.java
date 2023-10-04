package bossmonster.view;

import bossmonster.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;

public class OutputView {

    public static void printDefaultBoss(BossMonster bossMonster, Player player) {
        System.out.println("============================");
        System.out.println("BOSS HP [" + bossMonster.getCurrentHp() + "/" +
                bossMonster.getMaxHp() + "]");
        System.out.println("""
                        ____________________________\s
                           ^-^
                         / 0 0 \\\s
                        (   "   )\s
                         \\  -  /\s
                          - ^ -\s
                        ____________________________"""
                );
        System.out.println(player.getName() + " HP [" + player.getCurrentHp()
                + "/" + player.getMaxHp() + "] MP [" + player.getCurrentMp() + "/"
                + player.getMaxMp() + "]");
    }

    public static void printSadBoss(BossMonster bossMonster, Player player) {
        System.out.println("============================");
        System.out.println("BOSS HP [" + bossMonster.getCurrentHp() + "/" +
                bossMonster.getMaxHp() + "]");
        System.out.println("""
                        ____________________________\s
                           ^-^\s
                         / x x \\\s
                        (   "\\   )\s
                         \\  ^  /\s
                          - ^ -\s
                        ____________________________"""
                );
        System.out.println(player.getName() + " HP [" + player.getCurrentHp()
                + "/" + player.getMaxHp() + "] MP [" + player.getCurrentMp() + "/"
                + player.getMaxMp() + "]");
    }

    public static void printHappyBoss(BossMonster bossMonster, Player player) {
        System.out.println("============================");
        System.out.println("BOSS HP [" + bossMonster.getCurrentHp() + "/" +
                bossMonster.getMaxHp() + "]");
        System.out.println("""
                        ____________________________\s
                           ^-^\s
                         / ^ ^ \\\s
                        (   "\\   )\s
                         \\  ^  /\s
                          - ^ -\s
                        ____________________________"""
        );
        System.out.println(player.getName() + " HP [" + player.getCurrentHp()
                + "/" + player.getMaxHp() + "] MP [" + player.getCurrentMp() + "/"
                + player.getMaxMp() + "]");
    }

    public static void printPlayerWin(Player player, int count) { // shoild i get name by string?
        System.out.println(player.getName() + "won after " + count + " turn");
    }

    public static void printBossMonsterWin(Player player, int count) {
        System.out.println(player.getName() + " lost after " + count + " turn");
    }

    public static void printDamageByBossMonster(int damage) {
        System.out.println("Attack by boss (damage : " + damage + ")");
    }

    public static void printDamageByPlayer(AttackType attackType) {
        System.out.println("Magical Attack! (damage : " + attackType.getDamage() + ")");
    }
}
