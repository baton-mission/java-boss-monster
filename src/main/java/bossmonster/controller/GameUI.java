package bossmonster.controller;

import bossmonster.exception.InvalidBossHPException;
import bossmonster.exception.InvalidPlayerHpMpException;
import bossmonster.exception.InvalidPlayerNameException;
import bossmonster.service.GameService;
import java.util.Scanner;

public class GameUI {
    private final Scanner sc;
    private Integer bossHp, playerHp, playerMp;
    private String playerName;

    public GameUI() {
        this.sc = new Scanner(System.in);
        this.setBossHp();
        this.setPlayerName();
        this.setPlayerHpMp();
    }

    private void setBossHp() {
        System.out.println("! Welcome to Boss Monster Game !");
        while(true) {
            try {
                System.out.println("보스 몬스터의 HP를 입력해주세요. (100이상 300이하)");
                this.bossHp = this.sc.nextInt();

                if(this.bossHp < 100 || this.bossHp > 300)
                    throw new InvalidBossHPException();

                return;
            } catch (InvalidBossHPException e) {
                System.out.println("\n[ERROR] 유효한 보스 HP 값을 입력해주세요.");
            }
        }
    }

    private void setPlayerName() {
        while(true) {
            try {
                System.out.println("플레이어의 이름을 입력해주세요. (5자 이내)");
                this.playerName = this.sc.next();

                if(this.playerName.length() > 5)
                    throw new InvalidPlayerNameException();

                this.sc.nextLine();
                return;
            } catch (InvalidPlayerNameException e) {
                System.out.println("\n[ERROR] 올바른 플레이어 이름을 입력해주세요.");
            }
        }
    }

    private void setPlayerHpMp() {
        while(true) {
            String playerStatInput;
            try {
                System.out.println("플레이어의 HP와 MP를 입력해주세요.(,로 구분 / HP와 MP의 합 최대 200 이내)");
                playerStatInput = this.sc.nextLine();

                if(!playerStatInput.matches("^[0-9]{1,3},[0-9]{1,3}$"))     // 콤마 앞뒤로 숫자 3자리 이내
                    throw new IllegalArgumentException();

            } catch (IllegalArgumentException e) {
                System.out.println("\n[ERROR] 유효한 형태의 HP, MP 값을 입력해주세요 (Ex. 100,100)");
                continue;
            }

            try {
                String[] playerStat = playerStatInput.split(",");
                this.playerHp = Integer.parseInt(playerStat[0]);
                this.playerMp = Integer.parseInt(playerStat[1]);

                if(this.playerHp + this.playerMp > 200)
                    throw new InvalidPlayerHpMpException();
            } catch (InvalidPlayerHpMpException e) {
                e.getStackTrace();
                System.out.println("\n[ERROR] 유효한 형태의 HP, MP 값을 입력해주세요 (Ex. 100,100)");
                continue;
            }

            return;
        }
    }

    public void execute() {
        GameService gameService = new GameService(this.bossHp, this.playerName, this.playerHp, this.playerMp);
        gameService.play();
    }
}