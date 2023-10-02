package bossmonster.view;

import bossmonster.domain.bossmonster.dto.BossMonsterInfo;
import bossmonster.domain.player.dto.PlayerInfo;

public class ResultView {

    public void printStartGame() {
        System.out.println("보스 레이드를 시작합니다!");
    }

    public void printCharacterStatus(
            BossMonsterInfo bossMonsterInfo,
            String bossMonsterImage,
            PlayerInfo playerInfo
    ) {
        System.out.println("\n=============================================");
        printBossMonsterStatus(bossMonsterInfo);
        System.out.println("---------------------------------");
        System.out.println(bossMonsterImage);
        System.out.println("---------------------------------\n");
        printPlayerStatus(playerInfo);
        System.out.println("=============================================\n");
    }

    public static void printBossMonsterStatus(BossMonsterInfo bossMonsterInfo) {
        System.out.println("BOSS HP [" +
                bossMonsterInfo.getCurrentBossMonsterHp() +
                "/" + bossMonsterInfo.getMaximumBossMonsterHp() + "]");
    }

    public static void printPlayerStatus(PlayerInfo playerInfo) {
        System.out.println(playerInfo.getPlayerName() + " HP [" +
                playerInfo.getPlayerCurrentHp() +
                "/" + playerInfo.getPlayerMaximumHp() + "] MP [" +
                playerInfo.getPlayerCurrentMp() + "/" +
                playerInfo.getPlayerMaximumMp() + "]"
        );
    }

    public void printPlayerAttackResult(String attackName, int damage) {
        System.out.println(attackName + "을 했습니다. (입힌 데미지 : " + damage + ")");
    }

    public void printBossMonsterAttackResult(int damage) {
        System.out.println("보스가 공격 했습니다. (입힌 데미지 : " + damage + ")");
    }

    public void printPlayerWin(String playerName, int gameTurn) {
        System.out.println(playerName +  "님이 " + gameTurn + "번의 전투 끝에 보스 몬스터를 잡았습니다!");
    }

    public void printBossMonsterWin(
            BossMonsterInfo bossMonsterInfo,
            String bossMonsterImage,
            PlayerInfo playerInfo
    ) {
        printCharacterStatus(
                bossMonsterInfo,
                bossMonsterImage,
                playerInfo
        );
        System.out.println(playerInfo.getPlayerName() + "의 HP가 0이 되었습니다.");
        System.out.println("보스 레이드에 실패했습니다.");
    }
}
