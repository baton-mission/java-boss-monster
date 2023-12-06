package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerStatusTest {

    @DisplayName("HP 변동에 의해 최대 HP를 넘어갈 경우 최대 HP로 설정됨")
    @Test
    void confirmMaxHPBySetHP() {
        //given
        PlayerStatus playerStatus = new PlayerStatus(100, 100);

        //when
        playerStatus.setCurrentHP(150);
        int currentHP = playerStatus.getCurrentHP();

        //then
        assertThat(currentHP).isEqualTo(playerStatus.getMaxHP());
    }

    @DisplayName("HP 변동에 의해 최소 HP를 넘어갈 경우 최소 HP로 설정됨")
    @Test
    void confirmMinHPBySetHP() {
        //given
        PlayerStatus playerStatus = new PlayerStatus(100, 100);

        //when
        playerStatus.setCurrentHP(-110);
        int currentHP = playerStatus.getCurrentHP();

        //then
        assertThat(currentHP).isEqualTo(0);
    }

    @DisplayName("MP 변동에 의해 최대 MP를 넘어갈 경우 최대 MP로 설정됨")
    @Test
    void confirmMaxMPBySetMP() {
        //given
        PlayerStatus playerStatus = new PlayerStatus(100, 100);

        //when
        playerStatus.setCurrentMP(150);
        int currentMP = playerStatus.getCurrentMP();

        //then
        assertThat(currentMP).isEqualTo(playerStatus.getMaxMP());
    }

    @DisplayName("MP 변동에 의해 최소 MP를 넘어갈 경우 최소 MP로 설정됨")
    @Test
    void confirmMinMPBySetMP() {
        //given
        PlayerStatus playerStatus = new PlayerStatus(100, 100);

        //when
        playerStatus.setCurrentMP(-110);
        int currentMP = playerStatus.getCurrentMP();

        //then
        assertThat(currentMP).isEqualTo(0);
    }
}