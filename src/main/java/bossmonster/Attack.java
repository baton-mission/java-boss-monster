package bossmonster;

public enum Attack {

    PHYSICAL(1, "물리 공격", 10, -10),
    MAGIC(2, "마법 공격", 20, 30);

    private int number;
    private String name;
    private int damage;
    private int mpConsumption;

    Attack(int number, String name, int damage, int mpConsumption) {
        this.number = number;
        this.name = name;
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
