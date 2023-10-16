package bossmonster.controller;

import bossmonster.domain.battle.GameState;
import bossmonster.domain.creatures.Boss;
import bossmonster.domain.creatures.Player;
import bossmonster.service.CreatureService;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import bossmonster.view.outputview.BossSprite;
import bossmonster.view.outputview.ProgressOutputView;

import java.util.Map;

import static bossmonster.controller.Parameter.*;

public class CreatureController implements Controller {
    private final CreatureService creatureService;
    private final InputView inputView;
    private final OutputView outputView;


    public CreatureController(CreatureService creatureService, InputView inputView, OutputView outputView) {
        this.creatureService = creatureService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public GameState process(Map<String, String> param, Map<String, Object> model) {
        model.put(BOSS.getName(), getBoss(param, model));
        model.put(PLAYER.getName(), getPlayer(param, model));
        getViewBattleState(new ProgressOutputView(), param, model);
        return GameState.PLAYING;
    }

    private Boss getBoss(Map<String, String> param, Map<String, Object> model) {
        try {
            param.put(BOSS_HP.getName(), null);
            outputView.show(param, model);
            inputView.readLine(param, model);
            return createBoss(param);
        } catch (IllegalArgumentException e) {
            param.put(ERROR.getName(), e.getMessage());
            return getBoss(param, model);
        }
    }

    private Boss createBoss(Map<String, String> param) {
        int bossHp = Integer.parseInt(param.get(BOSS_HP.getName()));
        return creatureService.createBoss(bossHp);
    }

    private Player getPlayer(Map<String, String> param, Map<String, Object> model) {
        try {
            getPlayerName(param, model);
            getPlayerStat(param, model);
            return createPlayer(param);
        } catch (IllegalArgumentException e) {
            param.put(ERROR.getName(), e.getMessage());
            return getPlayer(param, model);
        }
    }

    private void getPlayerName(Map<String, String> param, Map<String, Object> model) {
        param.put(PLAYER_NAME.getName(), null);
        outputView.show(param, model);
        inputView.readLine(param, model);
    }

    private void getPlayerStat(Map<String, String> param, Map<String, Object> model) {
        param.put(PLAYER_HP.getName(), null);
        outputView.show(param, model);
        inputView.readLine(param, model);
    }

    private Player createPlayer(Map<String, String> param) {
        return creatureService.createPlayer(param);
    }

    private void getViewBattleState(OutputView outputView, Map<String, String> param, Map<String, Object>
            model) {
        model.put(BOSS_SPRITE.getName(), BossSprite.BOSS_IDLE);
        outputView.show(param, model);
    }
}
