package bossmonster;

import bossmonster.VO.HP;

public class BossMonster {
    private HP hp;
    public void createHP(int input){
        hp = new HP(input);
    }
    public void damaged(int input){
        if(hp.canDie(input)){
            hp.toZero();
            die();
            return;
        }
        hp.decrease(input);
    }
    public void die(){

    }
}
