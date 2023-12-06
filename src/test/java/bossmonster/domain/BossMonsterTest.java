package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BossMonsterTest {

    @DisplayName("보스 몬스터의 HP가 100이상 300이하가 아닐 경우 예외가 발생함")
    @Test
    void rangeExceptionByBossMonsterStatus() {
        //given
        int minHP = 99;
        int maxHP = 301;

        //when, then
        assertThatThrownBy(() -> new BossMonster(minHP))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BossMonster(maxHP))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보스 몬스터의 공격은 0~20의 랜덤 데미지를 가짐")
    @Test
    void confirmDamageOfBossMonsterAttack() {
        //given
        BossMonster bossMonster = new BossMonster(200);

        //when
        int damage = bossMonster.attack();
        boolean range = (damage >= 0) && (damage <= 20);

        //then
        assertThat(range).isTrue();
    }

    @DisplayName("공격 받은 데미지 만큼 HP가 감소함")
    @Test
    void confirmDamagedByAttack() {
        //given
        BossMonster bossMonster = new BossMonster(200);
        int damage = 30;

        //when
        bossMonster.takeDamage(damage);
        int currentHP = bossMonster.getCurrentHP();

        //then
        assertThat(currentHP).isEqualTo(170);
    }

    @DisplayName("HP가 0일 경우 보스 몬스터는 죽음")
    @Test
    void confirmDieByZeroHP() {
        //given
        BossMonster bossMonster = new BossMonster(200);
        int damage = 200;

        //when
        bossMonster.takeDamage(damage);
        int currentHP = bossMonster.getCurrentHP();
        boolean bossMonsterStatus = bossMonster.isAlive();

        //then
        assertThat(currentHP).isEqualTo(0);
        assertThat(bossMonsterStatus).isFalse();
    }
}