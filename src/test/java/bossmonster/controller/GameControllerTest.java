package bossmonster.controller;

import bossmonster.repository.AttackTypeRepository;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class GameControllerTest{

    @Mock
    InputView inputView;

    @Spy
    OutputView outputView;

    @Spy
    AttackTypeRepository attackTypeRepository;

    @InjectMocks
    GameController gameController;

    @DisplayName("게임 실행 테스트")
    @Test
    void playWithCorrectInput() {
        // given
        List<Integer> status = new ArrayList<>();
        status.add(200);
        status.add(0);

        given(inputView.readBossMonsterHp()).willReturn(100);
        given(inputView.readPlayerName()).willReturn("test");
        given(inputView.readPlayerHpAndMp()).willReturn(status);
        given(inputView.readAttackType()).willReturn(1);

        // when
        gameController.play();

        // then
        then(inputView).should().readBossMonsterHp();
        then(inputView).should().readPlayerName();
        then(inputView).should().readPlayerHpAndMp();
        then(inputView).should(times(10)).readAttackType();
        then(outputView).should().printBattleStartView();
        then(attackTypeRepository).should(times(10)).getAttackType(1);
    }
}