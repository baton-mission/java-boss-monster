package bossmonster.view;

import bossmonster.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.dto.PlayerDto;

public class OutputView {

    public static void printDefaultBoss(BossMonster bossMonster, PlayerDto.Status player) {
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
        System.out.println(player.getName() + " HP [" + player.getHp()
                + "/" + player.getMaxHp() + "] MP [" + player.getMp() + "/"
                + player.getMaxMp() + "]");
    }

    public static void printSadBoss(BossMonster bossMonster, PlayerDto.Status player) {
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
        System.out.println(player.getName() + " HP [" + player.getHp()
                + "/" + player.getMaxHp() + "] MP [" + player.getMp() + "/"
                + player.getMaxMp() + "]");
    }

    public static void printHappyBoss(BossMonster bossMonster, PlayerDto.Status player) {
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
        System.out.println(player.getName() + " HP [" + player.getHp()
                + "/" + player.getMaxHp() + "] MP [" + player.getMp() + "/"
                + player.getMaxMp() + "]");
    }

    public static void printPlayerWin(PlayerDto.Status player, int count) { // shoild i get name by string?
        System.out.println(player.getName() + "won after " + count + " turn");
    }

    public static void printBossMonsterWin(PlayerDto.Status player, int count) {
        System.out.println(player.getName() + " lost after " + count + " turn");
    }

    public static void printDamageByBossMonster(int damage) {
        System.out.println("Attack by boss (damage : " + damage + ")");
    }

    public static void printDamageByPlayer(AttackType attackType) {
        System.out.println("Magical Attack! (damage : " + attackType.getDamage() + ")");
    }
}
