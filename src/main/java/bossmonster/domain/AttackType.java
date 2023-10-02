package bossmonster.domain;

import java.util.Arrays;

public enum AttackType {
    PHYSICAL("물리 공격", "1", 10, 10),
    MAGICAL("마법 공격", "2", 20, -30);

    private final String name;
    private final String command;
    private final int damage;
    private final int manaCost;

    AttackType(String name, String command, int damage, int manaCost) {
        this.name = name;
        this.command = command;
        this.damage = damage;
        this.manaCost = manaCost;
    }

    public static AttackType findByCommand(String command) {
        return Arrays.stream(values())
                .filter(it -> it.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(""));
    }

    public int getManaCost() {
        return this.manaCost;
    }

    public int getDamage() {
        return this.damage;
    }

    public String getName() {
        return name;
    }
}
