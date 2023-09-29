package bossmonster.monster;

import static bossmonster.utils.ErrorMessage.*;

import java.util.Random;

import bossmonster.Hp;
import bossmonster.player.Player;

public class BossMonster {

    private static final int MIN_HP = 100;
    private static final int MAX_HP = 300;

    private Hp hp;
    private Appearance appearance;

    public BossMonster(Hp hp) {
        validate(hp);
        this.hp = hp;
    }

    private void validate(Hp hp) {
        if (hp.isOutOfRange(MIN_HP, MAX_HP)) {
            throw new IllegalArgumentException(BOSS_MONSTER_HP_OUT_OF_RANGE.formatted(MIN_HP, MAX_HP));
        }
    }

    public void takeDamaged(int damage) {
        hp.reduceByDamage(damage);
        appearance = Appearance.SICK;
    }

    public void attack(int damage, Player player) {
        player.takeDamaged(damage);
    }
}
