package bossmonster;

import bossmonster.IO.Output;
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
        mp.increase(10);
        attackCount ++;
        target.damaged(10, this);
    }
    public void magicalAttack(BossMonster target){
        if(!mp.usableMagic(30))
            throw new IllegalArgumentException("MP가 30미만이라서 마법공격을 할 수 없습니다.");
        mp.decrease(30);
        attackCount++;
        target.damaged(20, this);
    }
    public void damaged(Integer input){
        showDamaged(input);
        if(hp.canDie(input)){
            hp.toZero();
            die();
            return;
        }
        hp.decrease(input);
        Application.turn();
    }
    public void die(){
        System.out.println(name.showName() + "의 HP가 0이 되었습니다. \n보스 레이드에 실패했습니다.");
    }

    public void showState(){
        System.out.println(name.showName() + " HP " + hp.showNowMax() + " MP " + mp.showNowMax());
    }
    public void showDamaged(Integer damage){
        System.out.println("보스가 공격 했습니다. (입힌 데미지: " + hp.dealDamege(damage) + ")");
    }
}

