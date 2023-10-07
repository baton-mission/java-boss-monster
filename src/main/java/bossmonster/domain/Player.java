package bossmonster.domain;

public class Player {

    private final Name name;
    private final Status status;

    public Player(Name name, Status status) {
        this.name = name;
        this.status = status;
    }

    public boolean isAlive() {
        return status.upperZero();
    }

    public boolean isDie() {
        return status.underZero();
    }

    public void updateMana(AttackType type) {
        status.updateMana(type);
    }

    public void hit(int bossDamage) {
        status.updateHp(bossDamage);
    }

    public String getName() {
        return name.name();
    }

    public int getHp() {
        return status.getHp();
    }

    public int getMp() {
        return status.getMp();
    }

    public int getInitialHp() {
        return status.getInitialHp();
    }

    public int getInitialMp() {
        return status.getInitialMp();
    }

    public Status getStatus() {
        return status;
    }
}
