package bossmonster.view.outputview;

import bossmonster.domain.battle.BattleField;
import bossmonster.view.OutputView;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static bossmonster.controller.Parameter.*;

public class ResultOutputView implements OutputView {

    private final Map<String, Consumer<Map<String, String>>> resultMap = Map.ofEntries(
            Map.entry(BOSS_WIN.getName(), viewBossWinResult()),
            Map.entry(PLAYER_WIN.getName(), viewPlayerWinResult())
    );

    @Override
    public void show(Map<String, String> param, Map<String, Object> model) {
        Map<String, String> paramMap = initParam(model);
        model.keySet().forEach(key -> {
            if (resultMap.containsKey(key)) {
                resultMap.get(key).accept(paramMap);
            }
        });
    }

    private Map<String, String> initParam(Map<String, Object> model) {
        Map<String, String> map = new HashMap<>();
        BattleField battle = (BattleField) model.get(BATTLE.getName());
        map.put(PLAYER_NAME.getName(), battle.getPlayer().getName());
        map.put(BATTLE_COUNT.getName(), String.valueOf(battle.getBattleCount()));
        return map;
    }

    private Consumer<Map<String, String>> viewPlayerWinResult() {
        return param ->
        {
            String name = param.get(PLAYER_NAME.getName());
            String count = param.get(BATTLE_COUNT.getName());

            OutputWriter.writeln(name + "님이 " +
                    count + "번의 전투 끝에 보스 몬스터를 잡았습니다.");
            OutputWriter.print();
        };
    }

    private Consumer<Map<String, String>> viewBossWinResult() {
        return param ->
        {
            String name = param.get(PLAYER_NAME.getName());
            OutputWriter.writeln(name + "의 HP가 0이 되었습니다.");
            OutputWriter.writeln("보스 레이드에 실패했습니다.");
            OutputWriter.print();
        };
    }
}
