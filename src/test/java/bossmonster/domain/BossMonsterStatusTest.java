package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BossMonsterStatusTest {

    @DisplayName("HP 변동에 의해 최대 HP를 넘어갈 경우 최대 HP로 설정됨")
    @Test
    void confirmMaxHPBySetHP() {
        //given
        BossMonsterStatus bossMonsterStatus = new BossMonsterStatus(200);

        //when
        bossMonsterStatus.setCurrentHP(250);
        int currentHP = bossMonsterStatus .getCurrentHP();

        //then
        assertThat(currentHP).isEqualTo(bossMonsterStatus .getMaxHP());
    }

    @DisplayName("HP 변동에 의해 최소 HP를 넘어갈 경우 최소 HP로 설정됨")
    @Test
    void confirmMinHPBySetHP() {
        //given
        BossMonsterStatus bossMonsterStatus = new BossMonsterStatus(200);

        //when
        bossMonsterStatus.setCurrentHP(-250);
        int currentHP = bossMonsterStatus .getCurrentHP();

        //then
        assertThat(currentHP).isEqualTo(0);
    }
}