package bossmonster.domain.bossmonster;

public class BossMonsterImpl
        implements BossMonster {

    private final BossMonsterHp bossMonsterHp;

    public BossMonsterImpl(BossMonsterHp bossMonsterHp) {
        this.bossMonsterHp = bossMonsterHp;
    }

    @Override
    public void takeDamage(int damage) {
        bossMonsterHp.decreaseCurrentHp(damage);
    }
}
