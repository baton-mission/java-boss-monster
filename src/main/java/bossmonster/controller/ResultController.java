package bossmonster.controller;

import bossmonster.TypeQualifier;
import bossmonster.domain.battle.BattleField;
import bossmonster.domain.battle.GameState;
import bossmonster.domain.creatures.Creature;
import bossmonster.domain.creatures.Player;
import bossmonster.service.ResultService;
import bossmonster.view.OutputView;
import bossmonster.view.outputview.BossSprite;
import bossmonster.view.outputview.ProgressOutputView;

import java.util.Map;

import static bossmonster.controller.Parameter.*;

public class ResultController implements Controller {
    private final ResultService resultService;
    private final OutputView outputView;
    private BattleField battle;

    public ResultController(ResultService resultService, OutputView outputView) {
        this.resultService = resultService;
        this.outputView = outputView;
    }

    @Override
    public GameState process(Map<String, String> param, Map<String, Object> model) {
        battle = (BattleField) model.get(BATTLE.getName());
        moveToWinnerView(param, model);
        return GameState.FINISH;
    }

    private void moveToWinnerView(Map<String, String> param, Map<String, Object> model) {
        Creature winner = resultService.checkWinner(battle);
        if (TypeQualifier.checkCreatureType(Player.class, winner)) {
            getPlayerWinView(param, model);
            return;
        }
        getBossWinView(param, model);
    }

    private void getPlayerWinView(Map<String, String> param, Map<String, Object> model) {
        model.put(PLAYER_WIN.getName(), battle.getPlayer());
        outputView.show(param, model);
    }

    private void getBossWinView(Map<String, String> param, Map<String, Object> model) {
        model.put(BOSS_WIN.getName(), battle.getPlayer());
        getViewBattleState(new ProgressOutputView(), param, model);
        outputView.show(param, model);
    }

    private void getViewBattleState(OutputView outputView, Map<String, String> param,
                                    Map<String, Object> model) {
        model.put(BOSS_SPRITE.getName(), BossSprite.BOSS_WIN);
        model.put(BOSS.getName(), battle.getBoss());
        model.put(PLAYER.getName(), battle.getPlayer());
        outputView.show(param, model);
    }
}
