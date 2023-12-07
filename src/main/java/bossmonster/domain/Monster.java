package bossmonster.domain;

public class Monster {
    private final Hp totalHp;
    private final Hp currentHp;

    public Monster(Hp hp) {
        this.totalHp = hp;
        this.currentHp = hp;
    }

    public static Monster fromHp(int hp) {
        validateHpRange(hp);
        return new Monster(new Hp(hp));
    }

    private static void validateHpRange(int hp) {
        if (!isValidRange(hp)) {
            throw new IllegalArgumentException("보스 몬스터의 hp는 100이상 300이하여야 합니다.");
        }
    }

    private static boolean isValidRange(int hp) {
        return hp >= 100 && hp <= 300;
    }

    public Hp getTotalHp() {
        return totalHp;
    }

    public Hp getCurrentHp() {
        return currentHp;
    }

    public void damagedBy(PlayerAttack playerAttack) {
        currentHp.decreaseBy(playerAttack);
    }
}
