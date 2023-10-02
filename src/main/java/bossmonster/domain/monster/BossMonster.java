package bossmonster.domain.monster;

import static bossmonster.domain.monster.BossMonsterAppearance.*;
import static bossmonster.utils.ErrorMessage.*;

import java.util.List;

import bossmonster.domain.characterattributes.Hp;
import bossmonster.domain.player.Player;

public class BossMonster {

    private static final int MIN_HP = 100;
    private static final int MAX_HP = 300;

    private Hp hp;
    private BossMonsterAppearance appearance;

    public BossMonster(Hp hp) {
        validate(hp);
        this.hp = hp;
        this.appearance = DEFAULT;
    }

    private void validate(Hp hp) {
        if (hp.isOutOfRange(MIN_HP, MAX_HP)) {
            throw new IllegalArgumentException(BOSS_MONSTER_HP_OUT_OF_RANGE.formatted(MIN_HP, MAX_HP));
        }
    }

    public void takeDamaged(int damage) {
        hp.reduceByDamage(damage);
        appearance = SICK;
    }

    public void attack(int damage, Player player) {
        player.takeDamaged(damage);
    }

    public boolean isDead() {
        return hp.isZeroOrLess();
    }

    public void changeAppearance(BossMonsterAppearance appearance) {
        this.appearance = appearance;
    }

    public List<Integer> hpAndInitialHp() {
        return List.of(hp.getHp(), hp.getInitialHp());
    }

    public String appearance() {
        return appearance.getAppearance();
    }
}
