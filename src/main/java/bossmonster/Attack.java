package bossmonster;

public enum Attack {

    PHYSICAL(1, 10, -10),
    MAGIC(2, 20, 30);

    private int number;
    private int damage;
    private int mpConsumption;

    Attack(int number, int damage, int mpConsumption) {
        this.number = number;
        this.damage = damage;
        this.mpConsumption = mpConsumption;
    }

    public int getDamage() {
        return damage;
    }

    public int getMpConsumption() {
        return mpConsumption;
    }
}
