package bossmonster.service;

import bossmonster.domain.Boss;
import bossmonster.domain.Player;
import java.util.Scanner;

public class GameService {
    private final Player player;
    private final Boss boss;
    private final Scanner sc = new Scanner(System.in);

    private int attackNum = 0;

    public GameService(final Integer bossHp, final String playerName, final Integer playerHp, final Integer playerMp) {
        System.out.println("\n보스 레이드를 시작합니다.\n");
        this.boss = new Boss(bossHp);
        this.player = new Player(playerName, playerHp, playerMp);
    }

    public void play() throws Exception {
        while(true) {
            boss.decreaseHp(playerAttack());
            player.decreaseHp(bossAttack());
            attackNum += 1;

            if(boss.getHp() <= 0) {
                this.win();
                break;
            }
            if(player.getHp() <= 0) {
                this.lose();
                break;
            }

            boss.printStat();
            boss.printFigure(0);
            player.printStat();
        }
    }

    public Integer playerAttack() {
        Integer attackType, damage;

        System.out.println("어떤 공격을 하시겠습니까? 공격 번호를 입력해주세요.");
        System.out.println("1. 물리 공격\n2. 마법 공격");
        attackType = sc.nextInt();

        if(attackType == 1) {
            damage = player.physicalAttack();
            System.out.println("\n물리 공격을 했습니다. (입힌 데미지: " + damage + ")");
            return damage;
        }

        if(attackType == 2) {
            damage = player.magicalAttack();
            System.out.println("\n마법 공격을 했습니다. (입힌 데미지: " + damage + ")");
            return damage;
        }

        return -1;
    }

    public Integer bossAttack() {
        Integer damage;

        damage = boss.attack();
        System.out.println("보스가 공격했습니다. (입힌 데미지: " + damage + ")");
        return damage;
    }

    public void win() {
        System.out.println("\n" + player.getName() + " 님이 " + attackNum + "번의 전투 끝에 보스 몬스터를 잡았습니다.");
    }

    public void lose() {
        boss.printStat();
        boss.printFigure(-1);
        player.printStat();
        System.out.println(player.getName() + "의 HP가 0이 되었습니다.");
        System.out.println("보스 레이드에 실패하셨습니다.");
    }
}
