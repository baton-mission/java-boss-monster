package bossmonster.domain.creatures;

public final class Boss extends Creature {

    private static final int BOSS_MIN_HP = 100;
    private static final int BOSS_MAX_HP = 300;

    public Boss(int totalHp, int totalMp) {
        super(totalHp, totalMp);
        validateHp(totalHp);
    }


    private void validateHp(int totalHp) {
        if (totalHp < BOSS_MIN_HP || totalHp > BOSS_MAX_HP) {
            throw new IllegalArgumentException("보스의 HP는 100 ~ 300 사이로 설정해야합니다.");
        }
    }
}
