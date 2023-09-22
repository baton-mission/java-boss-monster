package bossmonster;

import bossmonster.VO.HP;

public class BossMonster {
    private HP hp;
    public void createHP(Integer input){
        hp = new HP(input);
    }
    public void damaged(Integer input){
        if(hp.canDie(input)){
            hp.toZero();
            die();
            return;
        }
        hp.decrease(input);
    }
    public void attack(Player target){
        Integer damage = (int) (Math.random() % 21);
        target.damaged(damage);
    }
    public void die(){

    }
}
