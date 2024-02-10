package bossmonster.controller;

import bossmonster.service.GameService;
import java.util.Scanner;

public class GameUI {
    private final Scanner sc;
    private Integer bossHp, playerHp, playerMp;
    private String playerName;

    public GameUI() {
        this.sc = new Scanner(System.in);
        setPlayerData();
    }

    private void setPlayerData() {
        System.out.println("! Welcome to Boss Monster Game !");
        System.out.println("보스 몬스터의 HP를 입력해주세요.");
        this.bossHp = this.sc.nextInt();

        System.out.println("플레이어의 이름을 입력해주세요.");
        this.playerName = this.sc.next();

        System.out.println("플레이어의 HP와 MP를 입력해주세요.(,로 구분 / HP와 MP의 합 최대 200 이내)");
        String[] playerStat = this.sc.next().split(",");
        this.playerHp = Integer.parseInt(playerStat[0]);
        this.playerMp = Integer.parseInt(playerStat[1]);
    }

    public void execute() throws Exception {
        GameService gameService = new GameService(this.bossHp, this.playerName, this.playerHp, this.playerMp);
        gameService.play();
    }
}
