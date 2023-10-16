package bossmonster.controller;

import bossmonster.TypeQualifier;
import bossmonster.domain.attack.AttackType;
import bossmonster.domain.battle.BattleField;
import bossmonster.domain.battle.GameState;
import bossmonster.domain.creatures.Creature;
import bossmonster.domain.creatures.Player;
import bossmonster.dto.BattleDTO;
import bossmonster.service.BattleService;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import bossmonster.view.outputview.BossSprite;
import bossmonster.view.outputview.ProgressOutputView;

import java.util.Map;

import static bossmonster.controller.Parameter.*;

public final class BattleController implements Controller {
    private final BattleService battleService;
    private final InputView inputView;
    private final OutputView outputView;
    private BattleField battle;

    public BattleController(BattleService battleService, InputView inputView, OutputView outputView) {
        this.battleService = battleService;
        this.inputView = inputView;
        this.outputView = outputView;
    }


    @Override
    public GameState process(Map<String, String> param, Map<String, Object> model) {
        battle = (BattleField) model.get(BATTLE.getName());
        battle.increaseBattleCount();
        for (Creature attacker : battleService.getAttackOrders(battle)) {
            getAttack(attacker, param, model);
            outputView.show(param, model);
        }
        return checkBattleEnd(param, model);
    }


    private void getAttack(Creature attacker, Map<String, String> param, Map<String, Object> model) {
        if (TypeQualifier.checkCreatureType(Player.class, attacker)) {
            model.put(PLAYER_ATTACK.getName(), selectAttack(param, model));
            return;
        }
        model.put(BOSS_ATTACK.getName(), battleService.attackByBoss(battle, AttackType.Boss.BOSS));
    }

    private BattleDTO selectAttack(Map<String, String> param, Map<String, Object> model) {
        getPlayerAttackParam(param, model);
        int attackNumber = Integer.parseInt(param.get(PLAYER_ATTACK.getName()));
        AttackType.Player attackType = AttackType.createPlayerAttack(attackNumber);
        try {
            return battleService.attackByPlayer(battle, attackType);
        } catch (IllegalArgumentException e) {
            param.put(ERROR.getName(), e.getMessage());
            return selectAttack(param, model);
        }
    }

    private void getPlayerAttackParam(Map<String, String> param, Map<String, Object> model) {
        param.put(PLAYER_ATTACK_TYPE.getName(), null);
        model.put(PLAYER_ATTACK_SELECT.getName(), AttackType.Player.class);
        try {
            outputView.show(param, model);
            inputView.readLine(param, model);
        } catch (IllegalArgumentException e) {
            param.put(ERROR.getName(), e.getMessage());
            getPlayerAttackParam(param, model);
        }
    }

    private GameState checkBattleEnd(Map<String, String> param, Map<String, Object> model) {
        if (battle.isBattleEnd()) {
            return GameState.RESULT;
        }
        getViewBattleState(new ProgressOutputView(), param, model);
        return GameState.PLAYING;
    }

    private void getViewBattleState(OutputView outputView, Map<String, String> param,
                                    Map<String, Object> model) {
        model.put(BOSS_SPRITE.getName(), BossSprite.BOSS_DAMAGED);
        model.put(BOSS.getName(), battle.getBoss());
        model.put(PLAYER.getName(), battle.getPlayer());
        outputView.show(param, model);
    }
}
