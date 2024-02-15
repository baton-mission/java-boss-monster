package bossmonster.Controller;

import bossmonster.Domain.Game;
import java.util.Scanner;

public class GameController {
    private Scanner scanner;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getAttackType() {
        System.out.println("어떤 공격을 하시겠습니까?\n"
                + "1. 물리 공격\n"
                + "2. 마법 공격");
        int attackType = scanner.nextInt();

        System.out.println();

        return attackType;
    }

    public void printStartMessage() {
        System.out.println("보스 레이드를 시작합니다!\n");
    }

    public void printBossPlayerStatus(Game game) {
        int bossMaxHp = game.getBoss().getMaxHp();
        int bossHp = game.getBoss().getHp();
        int playerMaxHp = game.getPlayer().getMaxHp();
        int playerHp = game.getPlayer().getHp();
        int playerMaxMp = game.getPlayer().getMaxMp();
        int playerMp = game.getPlayer().getMp();
        String playerName = game.getPlayer().getName();

        System.out.println("============================");

        System.out.println("Boss HP [" + bossHp + "/" + bossMaxHp + "]");

        if (bossMaxHp == bossHp) {
            System.out.println("____________________________\n"
                    + "   ^-^\n"
                    + " / 0 0 \\\n"
                    + "(   \"   )\n"
                    + " \\  -  /\n"
                    + "  - ^ -\n"
                    + "____________________________\n");
        } else {
            System.out.println("____________________________\n"
                    + "   ^-^\n"
                    + " / x x \\\n"
                    + "(   \"\\  )\n"
                    + " \\  ^  /\n"
                    + "  - ^ -\n"
                    + "____________________________\n");
        }

        System.out.println(playerName + " HP [" + playerHp + "/" + playerMaxHp + "] MP [" + playerMp + "/" + playerMaxMp + "]");
        System.out.println("============================");
        System.out.println();
    }

    public void printSuccessMessage(Game game) {
        System.out.println(game.getPlayer().getName() + "님이 " + game.getTurn() + "번의 전투 끝에 보스 몬스터를 잡았습니다.");
    }

    public void printFailMessage(Game game) {
        System.out.println(game.getPlayer().getName() + "의 HP가 0이 되었습니다. 보스 레이드에 실패했습니다.");
    }
}
