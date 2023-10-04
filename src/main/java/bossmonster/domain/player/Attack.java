package bossmonster.domain.player;

import java.util.Arrays;

import bossmonster.utils.ErrorMessage;

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
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.ERROR_NOT_FOUND_ATTACK_FOR_NUMBER));
    }

    private int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getMpConsumption() {
        return mpConsumption;
    }
}
