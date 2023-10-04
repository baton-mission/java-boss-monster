package bossmonster.domain;

import bossmonster.domain.attacktype.AttackType;

public class BossMonster {

    private final int BOSS_NORMAL = 100;
    private final int BOSS_DAMAGED = 101;
    private final int BOSS_WIN = 102;

    private int hp;
    private int maxHp;
    private int condition;

    public BossMonster(int hp) {
        validateBossStatus(hp);
        this.hp = hp;
        this.maxHp = hp;
        this.condition = BOSS_NORMAL;
    }

    private void validateBossStatus(int hp) {
        if (hp < 100 || hp > 300) {
            throw new IllegalArgumentException("보스 체력은 100이상, 300이하여야합니다.");
        }
    }

    public int attackPlayer(Player player) {
        int damage = (int) (Math.random() * 20);
        player.attacked(damage);

        if (player.getHp() == 0) {
            condition = BOSS_WIN;
        }

        return damage;
    }

    public void attacked(AttackType attackType) {
        int damage = attackType.getDamage();
        hp -= damage;
        condition = BOSS_DAMAGED;

        if (hp < 0) {
            hp = 0;
        }
    }

    public boolean isDead() {
        return hp == 0;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getCondition() {
        return condition;
    }
}
