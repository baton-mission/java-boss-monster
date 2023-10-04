package bossmonster.domain;

public abstract class Player {
    protected final String name;
    protected int hp;
    protected int mp;
    protected final int maxHp;
    protected final int maxMp;


    public Player(String name, int hp, int mp) {
        if(name.length() > 5){
            throw new IllegalArgumentException("플레이어의 이름은 5글자 이하여야 합니다.");
        }
        if (hp + mp != 200){
            throw new IllegalArgumentException("플레이어의 초기 HP와 초기 MP 의 합은 200이어야 합니다.");
        }
        if (mp <=0 || hp <= 0){
            throw new IllegalArgumentException("초기 HP와 MP는 양수여야 합니다.");
        }
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        maxHp = hp;
        maxMp = mp;
    }


    public abstract void attack(Boss boss, int value);

    public abstract void magicAttack(Boss boss, int value);

    protected void recoveryMp(int value){
        mp = mp + value;
    }

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
