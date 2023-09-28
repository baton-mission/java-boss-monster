package bossmonster.player;

import static bossmonster.utils.ErrorMessage.*;

import bossmonster.Name;
import bossmonster.Stat;

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
}
