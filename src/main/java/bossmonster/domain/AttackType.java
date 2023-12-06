package bossmonster.domain;

public enum AttackType {
    ATTACK_TYPE_NORMAL(1, "물리 공격", 10, 0, 10),
    ATTACK_TYPE_MAGIC(2, "마법 공격", 20, 30, 0);

    private final int number;
    private final String name;
    private final int damage;
    private final int mpUsage;
    private final int mpRecover;

    AttackType(final int number, final String name, final int damage, final int mpUsage, final int mpRecover) {
        this.number = number;
        this.name = name;
        this.damage = damage;
        this.mpUsage = mpUsage;
        this.mpRecover = mpRecover;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getMpUsage() {
        return mpUsage;
    }

    public int getMpRecover() {
        return mpRecover;
    }
}