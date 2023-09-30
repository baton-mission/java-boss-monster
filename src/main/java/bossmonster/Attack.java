package bossmonster;

import java.util.Arrays;
import java.util.NoSuchElementException;

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

    public static Attack of(int number) {
        return Arrays.stream(Attack.values())
                .filter(attack -> attack.getNumber() == number)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("[ERROR] 존재하지 않는 번호입니다."));
    }

    private int getNumber() {
        return number;
    }

    public int getDamage() {
        return damage;
    }

    public int getMpConsumption() {
        return mpConsumption;
    }
}
