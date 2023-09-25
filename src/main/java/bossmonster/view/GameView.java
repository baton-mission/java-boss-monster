package bossmonster.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

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
        return parseToIntegerList(inputString);
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
