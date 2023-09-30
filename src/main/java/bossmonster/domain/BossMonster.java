package bossmonster.domain;

public class BossMonster {

    int hp;
    int maxHp;

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setHp(int hp) {
        validateBossStatus(hp);
        this.hp = hp;
        this.maxHp = hp;
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

    private void validateBossStatus(int hp) {
        if (hp < 100 || hp > 300) {
            throw new IllegalArgumentException();
        }
    }
}
