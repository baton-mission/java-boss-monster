package bossmonster;

import bossmonster.IO.Output;
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
        showDamaged(input);
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
    }
    public void die(){

    }
    public void showState(){
        System.out.println("BOSS HP " + hp.showNowMax());
        System.out.println("____________________________\n" + avatar +
                "\n____________________________");
    }
    public void showDamaged(Integer damage){
        String type = "물리";
        if (damage > 10)
            type = "마법";
        System.out.println(type + " 공격을 했습니다. (입힌 데미지: " + hp.dealDamege(damage) + ")");

    }
}
