package bossmonster.domain;

public class BossMonster {

    private int hp;
    private int maxHp;

    public BossMonster(int hp) {
        validateBossStatus(hp);
        this.hp = hp;
        this.maxHp = hp;
    }

    private void validateBossStatus(int hp) {
        if (hp < 100 || hp > 300) {
            throw new IllegalArgumentException("보스 체력은 100이상, 300이하여야합니다.");
        }
    }

    public int attackPlayer(Player player) {
        int damage = (int) (Math.random() * 20);
        player.attacked(damage);
        return damage;
    }

    public void attacked(AttackType attackType) {
        int damage = attackType.getDamage();
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }

    public boolean isVictory(Player player) {
        if (player.getHp() == 0) {
            return true;
        }
        return false;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }
}
