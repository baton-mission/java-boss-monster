package bossmonster;

import bossmonster.VO.HP;
import bossmonster.VO.MP;
import bossmonster.VO.Name;

public class Player {
    private Name name;
    private HP hp;
    private MP mp;
    private Integer attackCount;
    public void createName(String input){
        this.name = new Name(input);
    }
    public void createHPMP(int hp, int mp){
        if (hp + mp != 200)
            throw new IllegalArgumentException("플레이어의 초기 HP와 MP 합은 200이어야 합니다.");
        this.hp = new HP(hp);
        this.mp = new MP(mp);
        this.attackCount = 0;

    }

    public void attack(Integer input,BossMonster target) {
        if (input == 1){
            physicalAttack(target);
            return;
        }
        if (input == 2) {
            magicalAttack(target);
            return;
        }
        throw new IllegalArgumentException("공격하셔야 합니다. 1또는 2를 입력해주세요.");
    }
    public void physicalAttack(BossMonster target){
        target.damaged(10);
        mp.increase(10);
        attackCount ++;
        System.out.println("물리 공격을 했습니다. (입힌 데미지: 10)");
    }
    public void magicalAttack(BossMonster target){
        if(!mp.usableMagic(30))
            throw new IllegalArgumentException("MP가 30미만이라서 마법공격을 할 수 없습니다.");
        target.damaged(20);
        mp.decrease(30);
        attackCount++;
        System.out.println("마법 공격을 했습니다. (입힌 데미지: 20)");
    }
    public void damaged(Integer input){
        if(hp.canDie(input)){
            hp.toZero();
            die();
            return;
        }
        hp.decrease(input);
    }
    public void die(){}

    public void showState(){
        System.out.println(name.showName() + " HP " + hp.showNowMax() + " MP " + mp.showNowMax());
    }
}

