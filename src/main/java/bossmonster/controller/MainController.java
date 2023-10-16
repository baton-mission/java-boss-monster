package bossmonster.controller;

import bossmonster.domain.battle.BattleField;
import bossmonster.domain.battle.GameState;
import bossmonster.domain.creatures.Boss;
import bossmonster.domain.creatures.Player;
import bossmonster.service.RepositoryService;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

import java.util.HashMap;
import java.util.Map;

import static bossmonster.controller.Parameter.*;

public class MainController {
    private final RepositoryService repositoryService;


    private InputView inputView;
    private OutputView outputView;
    private final Map<GameState, Controller> controllerMap = new HashMap<>();

    public MainController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
        controllerMap.put(GameState.START, ControlConfig.controlCreature());
        controllerMap.put(GameState.PLAYING, ControlConfig.controlBattle());
        controllerMap.put(GameState.RESULT, ControlConfig.controlResult());
    }

    public void run() {
        GameState gameState = GameState.START;
        Long battleId = initGame(gameState);
        gameState = GameState.PLAYING;
        while (gameState != GameState.FINISH) {
            gameState = accessController(battleId, gameState);
        }
    }

    private Long initGame(GameState state) {
        Map<String, String> param = new HashMap<>();
        Map<String, Object> model = new HashMap<>();
        controllerMap.get(state).process(param, model);

        return repositoryService.saveBattle(
                (Player) model.get(PLAYER.getName()),
                (Boss) model.get(BOSS.getName()));
    }

    private GameState accessController(Long battleId, GameState state) {
        Map<String, String> param = new HashMap<>();
        Map<String, Object> model = new HashMap<>();
        BattleField battle = repositoryService.getBattleById(battleId);
        model.put(BATTLE.getName(), battle);
        return controllerMap.get(state).process(param, model);
    }
}
