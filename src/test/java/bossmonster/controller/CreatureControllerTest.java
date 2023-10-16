package bossmonster.controller;

import bossmonster.service.CreatureService;
import bossmonster.view.inputview.StartInputView;
import bossmonster.view.outputview.ErrorOutputView;
import bossmonster.view.outputview.StartOutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class CreatureControllerTest {
    private final CreatureController creatureController =
            new CreatureController(
                    new CreatureService(),
                    new StartInputView(),
                    new StartOutputView(new ErrorOutputView()));
    Map<String, String> param = new HashMap<>();
    Map<String, Object> model = new HashMap<>();

    @Test
    @DisplayName("")
    void CreatureControllerTest() {
        Map<String, String> param = new HashMap<>();
        //given
        //when
        //then
    }

}