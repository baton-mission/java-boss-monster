package bossmonster;

import bossmonster.VO.HP;

public class BossMonster {
    private HP hp;
    private String avatar;
    BossMonster(){
        this.avatar =
                "   ^-^\n" +
                " / 0 0 \\\n" +
                "(   \"   )\n" +
                " \\  -  /\n" +
                "  - ^ -\n";
    }
    public void createHP(Integer input){
        hp = new HP(input);
    }
    public void damaged(Integer input){
        avatar =
                "   ^-^\n" +
                " / x x \\\n" +
                "(   \"\\  )\n" +
                " \\  ^  /\n" +
                "  - ^ -";
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
        System.out.println("보스가 공격 했습니다. (입힌 데미지: " + damage + ")");
    }
    public void die(){

    }
    public void showState(){
        System.out.println("BOSS HP " + hp.showNowMax());
        System.out.println("____________________________\n" + avatar +
                "\n____________________________");
    }
}
