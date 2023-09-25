package bossmonster.action;

import bossmonster.character.BossMoster;
import bossmonster.character.Player;
import bossmonster.error.Error;

import java.util.Scanner;

public class InitialCharacter {
    private Player player = new Player();
    private BossMoster bossMoster = new BossMoster();

    final Scanner sc = new Scanner(System.in);

    // 보스 몬스터 및 플레이어 초기 설정
    public InitialCharacter() {
        System.out.print("보스 몬스터의 HP 입력 : ");
        checkBossMonsterHP();

        System.out.print("플레이어 이름 입력 : ");
        checkPlayerName();

        System.out.print("플레이어의 HP, MP 입력(스페이스로 구분) : ");
        checkPlayerHPMP();

        System.out.println("보스 레이드를 시작합니다!\n");
    }

    // 보스 몬스터의 HP 입력 확인
    private void checkBossMonsterHP() {
        int HP = sc.nextInt();
        while(HP < 100 || 300 < HP) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                Error.printError("보스 몬스터 초기 HP는 100 이상 300 이하입니다.");
            }
            HP = sc.nextInt();
        }

        bossMoster.setHP(HP);
        bossMoster.setCurrentHP(HP);
    }

    // 플레이어 이름 길이 확인
    private void checkPlayerName() {
        String name = sc.next();
        while(!(name.length() <= 5)) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                Error.printError("플레이어 이름 길이는 5자 이하만 가능합니다.");
            }
            name = sc.next();
        }

        player.setName(name);
    }

    // 플레이어의 HP, MP 입력
    private void checkPlayerHPMP() {
        int HP = sc.nextInt();
        int MP = sc.nextInt();
        while(!(HP + MP == 200)) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                Error.printError("플레이어의 HP와 MP의 합은 200 입니다.");
            }
            HP = sc.nextInt();
            MP = sc.nextInt();
        }

        player.setHP(HP);
        player.setCurrentHP(HP);
        player.setMP(MP);
        player.setCurrentMP(MP);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public BossMoster getBossMoster() {
        return bossMoster;
    }

    public void setBossMonster(BossMoster bossMoster) {
        this.bossMoster = bossMoster;
    }
}