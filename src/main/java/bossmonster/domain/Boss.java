package bossmonster.domain;

public abstract class Boss {
    protected int hp;
    protected final int maxHp;

    public Boss(int hp) {
        if (hp < 100 || 300 < hp){
            throw new IllegalArgumentException("보스의 초기 HP 는 100 이상 300 이하여야 합니다.");
        }
        maxHp = hp;
        this.hp = hp;
    }

    public abstract void attack(Player player, int value);

    public void hit(int value) throws InterruptedException {
        if (hp - value < 0){
            hp = 0;
            throw new InterruptedException("보스가 죽었습니다!");
        }
        hp = hp - value;
    }

    @Override
    public final String toString() {
        return String.format("BOSS HP [%d/%d]",hp,maxHp);
    }
}
