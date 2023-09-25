package bossmonster.view;

import bossmonster.dto.BattleInfoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameView {
    Scanner scanner = new Scanner(System.in);

    public int printBossHpSettingView() {
        System.out.println("보스 몬스터의 HP를 입력해주세요.");
        int bossHp = Integer.valueOf(scanner.nextLine());
        return bossHp;
    }

    public String printPlayerNameSettingView() {
        System.out.println("플레이어의 이름을 입력해주세요.");
        String playerName = scanner.nextLine();
        return playerName;
    }

    public List<Integer> printPlayerStatusSettingView() {
        System.out.println("플레이어의 HP와 MP를 입력해주세요.");
        String inputString = scanner.nextLine();
        System.out.println("\n보스 레이드를 시작합니다!");
        return parseToIntegerList(inputString);
    }

    public int printPlayerPhaseView(BattleInfoDto battleInfoDto) {
        printBattleInfoView(battleInfoDto);
        System.out.println("어떤 공격을 하시겠습니까?");
        System.out.println("1. 물리 공격");
        System.out.println("2. 마법 공격");

        int attackType = Integer.parseInt(scanner.nextLine());
        if (attackType == 1) {
            System.out.println("물리 공격을 했습니다. (입힌 대미지: 10)");
        }

        if (attackType == 2) {
            System.out.println("마법 공격을 했습니다. (입힌 대미지: 20)");
        }

        return attackType;
    }

    public void printBossPhaseView(int bossDamage) {
        System.out.println("보스가 공격했습니다. (입힌 대미지: " + bossDamage + ")");
    }

    private void printBattleInfoView(BattleInfoDto battleInfoDto) {
        System.out.println("============================");
        System.out.println("BOSS HP [" + battleInfoDto.getBossHp() + "/" + battleInfoDto.getBossMaxHp() + "]");
        System.out.println("____________________________");
        System.out.println("  ^-^\n / 0 0 \\\n(   \"   )\n \\  -  /\n  - ^ -");
        System.out.println("____________________________");
        System.out.println(battleInfoDto.getPlayerName()
                + " HP [" + battleInfoDto.getPlayerHp() + "/" + battleInfoDto.getPlayerMaxHp()
                + "] MP [" + battleInfoDto.getPlayerMp() + "/" + battleInfoDto.getPlayerMaxMp() +"]");
        System.out.println("============================\n");
    }

    private List<Integer> parseToIntegerList(String inputString) {
        String[] inputStringArray = inputString.split(",");
        int playerHp = Integer.parseInt(inputStringArray[0]);
        int playerMp = Integer.parseInt(inputStringArray[1]);
        List<Integer> status = new ArrayList<>();
        status.add(playerHp);
        status.add(playerMp);

        return status;
    }
}
