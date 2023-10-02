package bossmonster.domain;

public class GameStatus {

    private int tryCount;
    private AttackType type;
    private int bossDamage;

    public GameStatus() {
        this.tryCount = 1;
    }

    public void updateInfo(AttackType type, int bossDamage) {
        this.type = type;
        this.bossDamage = bossDamage;
    }

    public void nextRound() {
        this.tryCount++;
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
}
