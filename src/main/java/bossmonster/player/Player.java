package bossmonster.player;

import static bossmonster.utils.ErrorMessage.*;

import java.util.List;

import bossmonster.Attack;
import bossmonster.Name;
import bossmonster.Stat;
import bossmonster.monster.BossMonster;

public class Player {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int SUM_OF_INITIAL_HP_AND_MP = 200;

    private Name name;
    private Stat stat;

    public Player(Name name, Stat stat) {
        validate(name, stat);
        this.name = name;
        this.stat = stat;
    }

    private void validate(Name name, Stat stat) {
        if (name.isLengthOver(MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException(ERROR_PLAYER_NAME_LENGTH_OVER.formatted(MAX_NAME_LENGTH));
        }
        if (stat.isNotSumOfInitialHpAndMp(SUM_OF_INITIAL_HP_AND_MP)) {
            throw new IllegalArgumentException(ERROR_SUM_OF_INITIAL_HP_AND_MP.formatted(SUM_OF_INITIAL_HP_AND_MP));
        }
    }

    public void attack(Attack attack, BossMonster bossMonster) {
        this.stat.consumeMp(attack.getMpConsumption());
        bossMonster.takeDamaged(attack.getDamage());
    }

    public void takeDamaged(int damage) {
        stat.reduceByDamage(damage);
    }

    public boolean isDead() {
        return stat.isHpNegative();
    }

    public String name() {
        return name.getName();
    }

    public List<Integer> stat() {
        return stat.hpAndInitialHpAndMpAndInitialMp();
    }
}
