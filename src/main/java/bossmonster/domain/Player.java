package bossmonster.domain;

import bossmonster.exception.Validator;
import java.util.Arrays;
import java.util.List;

public class Player {

    private static final String ATTACK_TYPE_NORMAL = "물리 공격";
    private static final String ATTACK_TYPE_MAGIC = "마법 공격";

    private String name;
    private int totalHP;
    private int currentHP;
    private int totalMP;
    private int currentMP;

    public Player(String name, int hp, int mp) {
        this.name = Validator.validatePlayerName(name);
        Validator.validatePlayerStatus(hp, mp);
        totalHP = hp;
        totalMP = mp;
    }

    public String getName() {
        return name;
    }

    public int getTotalHP() {
        return totalHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getTotalMP() {
        return totalHP;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public List<String> getAttackType() {
        return Arrays.asList(ATTACK_TYPE_NORMAL, ATTACK_TYPE_MAGIC);
    }


}
