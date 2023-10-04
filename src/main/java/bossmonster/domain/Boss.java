package bossmonster.domain;

import bossmonster.exception.GameEndException;

public abstract class Boss {
    protected int hp;
    protected final int maxHp;

    public Boss(int hp) {
        maxHp = hp;
        this.hp = hp;
    }

    public abstract void attack(Player player, int value);

    public void hit(int value) {
        if (hp - value <= 0 || hp == 0){
            hp = 0;
            throw new GameEndException("보스가 죽었습니다!", true);
        }
        hp = hp - value;
    }

    @Override
    public final String toString() {
        return String.format("BOSS HP [%d/%d]",hp,maxHp);
    }

    public String bossIcon(){
        return "   ^-^\n" +
                " / 0 0 \\\n" +
                "(   \"   )\n" +
                " \\  -  /\n" +
                "  - ^ -";
    }

    public String bossHitIcon(){
        return "   ^-^\n" +
                " / x x \\\n" +
                "(   \"\\  )\n" +
                " \\  ^  /\n" +
                "  - ^ -";
    }

    public final boolean isNew(){
        return hp == maxHp;
    }
}
