package bossmonster.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CurrentBossHpTest {


    @Test
    void attackedBy는_물리공격을_할_경우_보스체력을_10_깎는다() {
        CurrentBossHp currentBossHp = CurrentBossHp.from(100);
        AttackType attackType = AttackType.PHYSICAL;
        CurrentBossHp expectedCurrentBossHp = CurrentBossHp.from(90);

        CurrentBossHp actualCurrentBossHp = currentBossHp.attackedBy(attackType);

        assertEquals(expectedCurrentBossHp, actualCurrentBossHp);
    }

    @Test
    void attackedBy는_마법공격을_할_경우_보스체력을_20_깎는다() {
        CurrentBossHp currentBossHp = CurrentBossHp.from(100);
        AttackType attackType = AttackType.MAGICAL;
        CurrentBossHp expectedCurrentBossHp = CurrentBossHp.from(80);

        CurrentBossHp actualCurrentBossHp = currentBossHp.attackedBy(attackType);

        assertEquals(expectedCurrentBossHp, actualCurrentBossHp);
    }

    @Test
    void isUnderZero는_보스체력이_0보다_작은_경우_true를_반환한다() {
        CurrentBossHp currentBossHp = CurrentBossHp.from(0);

        boolean actual = currentBossHp.isUnderZero();

        assertTrue(actual);
    }

    @Test
    void isUnderZero는_보스체력이_0보다_크거나_같은_경우_false를_반환한다() {
        CurrentBossHp currentBossHp = CurrentBossHp.from(1);

        boolean actual = currentBossHp.isUnderZero();

        assertFalse(actual);
    }
}
