package bossmonster.domain.monster;

import bossmonster.domain.Hp;
import bossmonster.domain.PlayerAttack;

public class Monster {
    public static final int MIN_MONSTER_HP = 100;
    public static final int MAX_MONSTER_HP = 300;
    private final Hp totalHp;
    private final Hp currentHp;

    private Monster(Hp totalHp, Hp currentHp) {
        this.totalHp = totalHp;
        this.currentHp = currentHp;
    }

    public static Monster fromHp(int hp) {
        validateHpRange(hp);
        return new Monster(new Hp(hp), new Hp(hp));
    }

    private static void validateHpRange(int hp) {
        if (!isValidRange(hp)) {
            throw new IllegalArgumentException(
                    String.format("보스 몬스터의 hp는 %d이상 %d이하여야 합니다.", MIN_MONSTER_HP, MAX_MONSTER_HP));
        }
    }

    private static boolean isValidRange(int hp) {
        return hp >= MIN_MONSTER_HP && hp <= MAX_MONSTER_HP;
    }

    public void damagedBy(PlayerAttack playerAttack) {
        currentHp.decreaseBy(playerAttack);
    }

    public boolean isOver() {
        return currentHp.isEmpty();
    }

    public Hp getTotalHp() {
        return totalHp;
    }

    public Hp getCurrentHp() {
        return currentHp;
    }
}
