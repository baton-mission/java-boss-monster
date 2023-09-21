package bossmonster;

import bossmonster.VO.HP;

public class BossMonster {
    private HP hp;
    public void createHP(int input){
        this.hp = new HP(input);
    }
}
