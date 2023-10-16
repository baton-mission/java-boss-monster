package bossmonster.view.outputview;

import bossmonster.domain.creatures.Boss;
import bossmonster.domain.creatures.Player;
import bossmonster.view.OutputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

class ProgressOutputViewTest {
    private OutputView outputView = new ProgressOutputView();
    private Map<String, Object> model = new HashMap<>();

    @BeforeEach
    void create() {
        Player player = new Player(100, 100, "test");
        Boss boss = new Boss(100, 0);
        model.put("player", player);
        model.put("boss", boss);
    }

    @AfterEach
    void clear() {
        model.clear();
    }

//    @Test
//    @DisplayName("BOSS_DAMAGED")
//    void BOSS_ATTACKED() {
//        //given
//        create();
//        //when
//        BossSprite sprite = BossSprite.BOSS_DAMAGED;
//        model.put("bossSprite", sprite);
//        outputView.show(model);
//        //then
//    }

//    @Test
//    @DisplayName("BOSS_WIN")
//    void BOSS_WIN() {
//        //given
//        create();
//        //when
//        BossSprite sprite = BossSprite.BOSS_WIN;
//        model.put("bossSprite", sprite);
//        outputView.show(model);
//        //then
//    }
//
//    @Test
//    @DisplayName("BOSS_IDLE")
//    void BOSS_IDLE() {
//        //given
//        create();
//        //when
//        BossSprite sprite = BossSprite.BOSS_IDLE;
//        model.put("bossSprite", sprite);
//        outputView.show(model);
//        //then
//    }

}