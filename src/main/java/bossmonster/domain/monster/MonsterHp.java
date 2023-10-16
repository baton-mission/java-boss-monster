package bossmonster.domain.monster;

public class MonsterHp {

    private int currentHp;
    private int maxHp;

    public MonsterHp(int hp) {
        validateHp(hp);
        this.currentHp = hp;
        this.maxHp = hp;
    }
    private void validateHp(int hp) {
        if (100 > hp || hp > 300) {
            throw new IllegalArgumentException("몬스터의 HP는 100이상 300이하여야합니다.");
        }
    }

    public void reduceHp(int damage) {
        this.currentHp = currentHp - damage;
        if (currentHp < 0) {
            currentHp = 0;
        }
    }
    public boolean hasHPGreaterThanZero() {
        return currentHp > 0;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }
}
