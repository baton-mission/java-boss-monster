package bossmonster.controller;

import bossmonster.IOTest;
import bossmonster.view.GameView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;


class GameControllerTest extends IOTest {

    GameController gameController;

    @BeforeEach
    void beforeEach() {
        gameController = new GameController();
    }

    @DisplayName("play 메서드 정상 입력값 테스트")
    @Test
    void playWithCorrectInput() {
        // given
        systemIn("100\ntest\n100,100\n2\n2\n2\n1\n1\n2");

        // when
        gameController.play();

        // then
        org.junit.jupiter.api.Assertions.assertTrue(gameController.player.getHp() == 0 || gameController.bossMonster.getHp() == 0);
    }
}