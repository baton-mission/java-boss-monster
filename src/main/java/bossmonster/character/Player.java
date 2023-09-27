package bossmonster.character;

import bossmonster.Application;
import bossmonster.io.Output;
import bossmonster.resources.HP;
import bossmonster.resources.MP;
import bossmonster.resources.Name;

public class Player {

    private final int SUM_HP_MP = 200;
    private Name name;
    private HP hp;
    private MP mp;
    private Integer attackCount;

    public void createName(String userInput) {
        this.name = new Name(userInput);
    }

    public void createHPMP(int hp, int mp) {
        if (hp + mp != SUM_HP_MP) {
            throw new IllegalArgumentException("[ERROR] 플레이어의 초기 HP와 MP 합은 200이어야 합니다.");
        }

        if (hp + mp == SUM_HP_MP) {
            this.hp = new HP(hp);
            this.mp = new MP(mp);
            this.attackCount = 0;
            return;
        }

        throw new IllegalArgumentException("[ERROR] 2개의 자연수를 콤마(,)를 기준으로 나눠서 입력해주세요.");
    }

    public void attack(Integer userInput,BossMonster target) {
        if (userInput == 1) {
            physicalAttack(target);
            return;
        }
        if (userInput == 2) {
            magicalAttack(target);
            return;
        }
        throw new IllegalArgumentException("[ERROR] 공격하셔야 합니다. 1또는 2를 입력해주세요.");
    }

    public void physicalAttack(BossMonster target) {
        mp.increase(10);
        attackCount ++;
        target.damaged(10, this);
    }

    public void magicalAttack(BossMonster target) {
        if(!mp.usableMagic(30))
            throw new IllegalArgumentException("[ERROR] MP가 30미만이라서 마법공격을 할 수 없습니다.");
        mp.decrease(30);
        attackCount ++;
        target.damaged(20, this);
    }

    public void damaged(Integer input, BossMonster attacker) {
        showDamaged(input);
        if(hp.canDie(input)) {
            hp.toZero();
            die(attacker);
            return;
        }
        hp.decrease(input);
        Application.turn();
    }

    public void die(BossMonster attacker) {
        attacker.victory();
        Output.battleField(this,attacker);
        System.out.println("\n" + name.showName() + "의 HP가 0이 되었습니다. \n보스 레이드에 실패했습니다.");
    }

    public void showState() {
        System.out.println(name.showName() + " HP " + hp.showNowMax() + " MP " + mp.showNowMax());
    }

    public void showDamaged(Integer damage) {
        System.out.println("보스가 공격 했습니다. (입힌 데미지: " + hp.dealDamege(damage) + ")");
    }

    public void victory() {
        System.out.println("\n" + name.showName() + " 님이 " + attackCount + "번의 전투 끝에 보스 몬스터를 잡았습니다.");
    }
}

