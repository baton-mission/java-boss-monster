package bossmonster.controller;

import bossmonster.IOTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class GameControllerTest extends IOTest {

    @DisplayName("게임 실행 테스트")
    @Test
    void playWithCorrectInput() {
        // given
        GameController gameController = new GameController();
        systemIn("100\ntest\n100,100\n2\n2\n2\n1\n1\n2");

        // when
        gameController.play();

        // then
        assertThat(getOutput()).contains("보스 몬스터의 HP를 입력해주세요.");
        assertThat(getOutput()).contains("플레이어의 이름을 입력해주세요.");
        assertThat(getOutput()).contains("플레이어의 HP와 MP를 입력해주세요.");
        assertThat(getOutput()).contains("보스 레이드를 시작합니다!");
        assertThat(getOutput()).contains("어떤 공격을 하시겠습니까?");
        assertThat(getOutput()).contains("1. 물리 공격");
        assertThat(getOutput()).contains("2. 마법 공격");
        assertThat(getOutput()).contains("물리 공격을 했습니다.");
        assertThat(getOutput()).contains("마법 공격을 했습니다.");
        assertThat(getOutput()).contains("보스가 공격했습니다.");
    }
}