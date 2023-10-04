package bossmonster.domain;

import bossmonster.domain.attacktype.AttackType;

public class Player {

    private String name;
    private int hp;
    private int mp;
    private int maxHp;
    private int maxMp;

    public Player(String name, int hp, int mp) {
        validatePlayerName(name);
        validatePlayerStatus(hp, mp);

        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.mp = mp;
        this.maxMp = mp;
    }

    public static void validatePlayerName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("플레이어의 이름은 5자 이하만 가능합니다.");
        }
    }

    public static void validatePlayerStatus(int hp, int mp) {
        if (hp < 1 || hp + mp != 200) {
            throw new IllegalArgumentException("HP는 1이상, HP와 MP의 합이 200이 되도록 입력해주세요.");
        }
    }

    public void attackBossMonster(BossMonster bossMonster, AttackType attackType) {
        if (!canAttack(attackType)) {
            throw new IllegalArgumentException();
        }

        bossMonster.attacked(attackType);
        mp += attackType.getMpChange();
        if (mp > maxMp) {
            mp = maxMp;
        }
    }

    public void attacked(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }

    public boolean isVictory(BossMonster bossMonster) {
        return bossMonster.getHp() == 0;
    }

    private boolean canAttack(AttackType attackType) {
        int mpChange = attackType.getMpChange();

        if (mp + mpChange < 0) {
            return false;
        }

        return true;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxMp() {
        return maxMp;
    }
}
