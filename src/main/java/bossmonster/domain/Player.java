package bossmonster.domain;

import bossmonster.AttackType;

public class Player {

    String name;
    int hp;
    int mp;
    int maxHp;
    int maxMp;

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

    public void setName(String name) {
        validatePlayerName(name);
        this.name = name;
    }

    public void setStatus(int hp, int mp) {
        validatePlayerStatus(hp, mp);
        this.hp = hp;
        this.maxHp = hp;
        this.mp = mp;
        this.maxMp = mp;
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
        if (bossMonster.getHp() == 0) {
            return true;
        }
        return false;
    }

    private void validatePlayerName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePlayerStatus(int hp, int mp) {
        if (hp + mp != 200) {
            throw new IllegalArgumentException();
        }
    }

    private boolean canAttack(AttackType attackType) {
        int mpChange = attackType.getMpChange();

        if (mp + mpChange < 0) {
            return false;
        }

        return true;
    }
}
