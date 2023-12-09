package bossmonster.domain;

import java.util.Arrays;

public enum PlayerAttack {
    PHYSICAL_ATTACK(1, "물리 공격", 10, 10),
    MAGICAL_ATTACK(2, "마법 공격", 20, -30);

    private final int userCommand;
    private final String message;
    private final int hpDamage;
    private final int mpSelfEffect;

    PlayerAttack(int userCommand, String message, int hpDamage, int mpSelfEffect) {
        this.userCommand = userCommand;
        this.message = message;
        this.hpDamage = hpDamage;
        this.mpSelfEffect = mpSelfEffect;
    }

    public static PlayerAttack from(int input) {
        return Arrays.stream(values())
                .filter(attack -> attack.userCommand == input)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("입력은 %s, %s로 해야합니다.", PHYSICAL_ATTACK.userCommand, MAGICAL_ATTACK.userCommand)));
    }

    public int applyMp(int mp) {
        return mp + mpSelfEffect;
    }

    public int applyHp(int hp) {
        return hp - hpDamage;
    }

    public String getMessage() {
        return message;
    }

    public int getHpDamage() {
        return hpDamage;
    }

    public int getUserCommand() {
        return userCommand;
    }
}
