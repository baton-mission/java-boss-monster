package controller;

import domain.Boss;

public class BossController {

    private static final Boss boss = Boss.getInstance();
    private static final PlayerController playerController = new PlayerController();
    public void setHp(int hp){
        boss.setMax_hp(hp);
        boss.setCurrent_hp(hp);
    }

    public void attack(){
        int damage = (int) (Math.random() * 20);
        playerController.getAttack(damage);
        System.out.printf("보스가 공격 했습니다. (입힌 데미지: %d) \n", damage);
    }

    public void getAttack(int damage){
        boss.setCurrent_hp(boss.getCurrent_hp() - damage);
        if(boss.getCurrent_hp() < 0) {
            boss.setCurrent_hp(0);
        }else{
            boss.setState(2);
        }
    }
    public boolean isOver(){
        if(boss.getCurrent_hp() > 0) return false;
        return true;
    }

    public void setState(int state){
        boss.setState(state);
    }
}
