package bossmonster.action;

import bossmonster.character.BossMoster;

import java.util.Random;

// 보스 몬스터 행동
public class BossMonsterAction {
    public BossMoster bossMoster;

    public BossMoster getBossMoster() {
        return bossMoster;
    }

    public void setBossMoster(BossMoster bossMoster) {
        this.bossMoster = bossMoster;
    }

    // 몬스터 상태 출력
    public void printState() {
        System.out.println("============================");
        System.out.println("BOSS HP [" + bossMoster.getCurrentHP() + "/" + bossMoster.getHP() + "]");
    }

    // 처음 보스 몬스터 출력
    public void printFirstState() {
        printState();
        System.out.println("____________________________\n" +
                "   ^-^\n" +
                " / 0 0 \\\n" +
                "(   \"   )\n" +
                " \\  -  /\n" +
                "  - ^ -\n" +
                "____________________________\n");
    }

    // 공격당한 보스 몬스터 출력
    public void printAttackedState() {
        printState();
        System.out.println("____________________________\n" +
                "   ^-^\n" +
                " / x x \\\n" +
                "(   \"\\  )\n" +
                " \\  ^  /\n" +
                "  - ^ -\n" +
                "____________________________\n");
    }

    // 보스가 이겼을 경우 상태 출력
    public void printWinState() {
        printState();
        System.out.println("____________________________\n" +
                "   ^-^\n" +
                " / ^ ^ \\\n" +
                "(   \"   )\n" +
                " \\  3  /\n" +
                "  - ^ -\n" +
                "____________________________\n");
    }

    // 플레이어 공격(0 ~ 20)
    public int attack() {
        Random random = new Random();
        int damage = random.nextInt(20);
        System.out.println("보스가 공격 했습니다. (입힌 데미지 : " + damage + ")");
        return damage;
    }

    // 플레이어에게 공격 당함
    public void damage(int damage) {
        bossMoster.setCurrentHP(bossMoster.getCurrentHP() - damage);
        if (bossMoster.getCurrentHP() < 0) bossMoster.setCurrentHP(0);
    }

    // 보스 몬스터 HP 확인
    public boolean checkHP() {
        if (bossMoster.getCurrentHP() == 0) return true; // HP가 0이 되었을 때
        return false;
    }

}