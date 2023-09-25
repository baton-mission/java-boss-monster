package bossmonster.action;

import bossmonster.character.Player;
import bossmonster.error.Error;

public class PlayerAction {
    public Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    // 현재 플레이어 상태 출력
    public void printState() {
        System.out.println(player.getName() + " HP [" + player.getCurrentHP() + "/" + player.getHP() + "]"
                + " MP [" + player.getCurrentMP() + "/" + player.getMP() + "]");
        System.out.println("============================");
    }

    // 플레이어의 물리 공격
    public void physicalAttack() {
        System.out.println("물리 공격을 했습니다. (입힌 데미지: 10)");
        player.setCurrentMP(player.getCurrentMP() + 10); // MP 회복
        if(player.getCurrentMP() > player.getMP()) player.setCurrentMP(player.getMP()); // 최대 회복 MP
    }

    // 플레이어의 마법 공격
    public boolean magicAttack() {
        try {
            checkMP(20);
        } catch (IllegalArgumentException e) {
            Error.printError("MP가 부족합니다. 물리 공격을 해주세요");
            return true;
        }

        System.out.println("마법 공격을 했습니다. (입힌 데미지: 20)");
        player.setCurrentMP(player.getCurrentMP() - 30); // MP 소모
        return false;
    }

    // 보스 몬스터에 데미지 입음
    public void damage(int damage) {
        player.setCurrentHP(player.getCurrentHP() - damage);
        if(player.getCurrentHP() < 0) player.setCurrentHP(0);
    }

    // 플레이어 HP 확인
    public boolean checkHP() {
        if(player.getCurrentHP() == 0) return true; // HP가 0이 되었을 때
        return false;
    }

    // 플레이어 MP 확인
    public void checkMP(int MP) {
        if(player.getCurrentMP() - MP < 0) { // MP가 0이 되었을 때
            throw new IllegalArgumentException();
        }
    }
}
