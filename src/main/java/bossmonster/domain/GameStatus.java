package bossmonster.domain;

public class GameStatus {

    private int tryCount;
    private AttackType type;
    private int bossDamage;

    public GameStatus() {
        this.tryCount = 1;
    }

    public int getTryCount() {
        return tryCount;
    }

    public String getType() {
        return type.getName();
    }

    public int getAttackDamage() {
        return type.getDamage();
    }

    public int getBossDamage() {
        return bossDamage;
    }

    public void updateAttackType(AttackType type) {
        this.type = type;
    }

    public void updateBossDamage(int bossDamage) {
        this.bossDamage = bossDamage;
        nextRound();
    }

    private void nextRound() {
        this.tryCount++;
    }
}
