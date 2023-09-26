package bossmonster;

import bossmonster.VO.HP;

public class BossMonster {

    private HP hp;
    private String avatar;
    private static final String NORMAL_FORM
                = "   ^-^\n"
                + " / 0 0 \\\n"
                + "(   \"   )\n"
                + " \\  -  /\n"
                + "  - ^ -";
    private static final String DAMAGED_FORM
                = "   ^-^\n"
                + " / x x \\\n"
                + "(   \"\\  )\n"
                + " \\  ^  /\n"
                + "  - ^ -";
    private static final String VICTORY_FORM
                = "   ^-^\n"
                + " / ^ ^ \\\n"
                + "(   \"   )\n"
                + " \\  3  /\n"
                + "  - ^ -";

    BossMonster() {
        this.avatar = NORMAL_FORM;
    }

    public void createHP(Integer input) {
        hp = HP.boss(input);
    }

    public void damaged(Integer input, Player attacker) {
        showDamaged(input);
        avatar = DAMAGED_FORM;
        if(hp.canDie(input)) {
            hp.toZero();
            die(attacker);
            return;
        }
        hp.decrease(input);
        attack(attacker);
    }

    public void attack(Player target) {
        Integer damage = (int) ((Math.random() * 1000) % 20);
        target.damaged(damage, this);
    }

    public void die(Player attcker) {
        attcker.victory();
    }

    public void showState() {
        System.out.println("BOSS HP " + hp.showNowMax());
        System.out.println("____________________________\n" + avatar
                + "\n____________________________");
    }

    public void showDamaged(Integer damage) {
        String type = "물리";
        if (damage > 10) {
            type = "마법";
        }
        System.out.println("\n" + type + " 공격을 했습니다. (입힌 데미지: " + hp.dealDamege(damage) + ")");
    }

    public void victory() {
        this.avatar = VICTORY_FORM;
    }
}
