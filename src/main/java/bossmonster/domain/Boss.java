package bossmonster.domain;

import bossmonster.exception.GameEndException;

abstract class Boss {
    private int hp;
    private final int maxHp;

    Boss(int hp) {
        maxHp = hp;
        this.hp = hp;
    }

    abstract void attack(Player player, int damageValue);

    void hit(int damageValue) {
        if (hp - damageValue <= 0 || hp == 0){
            hp = 0;
            throw new GameEndException("보스가 죽었습니다!", true);
        }
        hp = hp - damageValue;
    }

    @Override
    public final String toString() {
        return String.format("BOSS HP [%d/%d]",hp,maxHp);
    }

    String bossIcon(){
        return "   ^-^\n" +
                " / 0 0 \\\n" +
                "(   \"   )\n" +
                " \\  -  /\n" +
                "  - ^ -";
    }

    String bossHitIcon(){
        return "   ^-^\n" +
                " / x x \\\n" +
                "(   \"\\  )\n" +
                " \\  ^  /\n" +
                "  - ^ -";
    }

    final boolean isNew(){
        return hp == maxHp;
    }
}
