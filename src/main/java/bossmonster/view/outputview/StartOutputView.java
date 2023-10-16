package bossmonster.view.outputview;

import bossmonster.view.OutputView;

import java.util.LinkedHashMap;
import java.util.Map;

import static bossmonster.controller.Parameter.*;

public class StartOutputView implements OutputView {
    private static final Map<String, Runnable> textMap = new LinkedHashMap<>();
    private final ErrorOutputView errorOutputView;

    public StartOutputView(ErrorOutputView errorOutputView) {
        this.errorOutputView = errorOutputView;
        initTextConfig();
    }

    private void initTextConfig() {
        textMap.put(BOSS_HP.getName(),
                () -> System.out.println("보스 몬스터의 HP를 입력해주세요."));

        textMap.put(PLAYER_NAME.getName(),
                () -> System.out.println("플레이어의 이름을 입력해주세요"));

        textMap.put(PLAYER_HP.getName(),
                () -> System.out.println("플레이어의 HP와 MP를 입력해주세요.(,로 구분)"));
    }

    @Override
    public void show(Map<String, String> param, Map<String, Object> model) {
        if (param.containsKey(ERROR.getName())) {
            errorOutputView.show(param, model);
        }
        for (String name : param.keySet()) {
            if (textMap.containsKey(name) && param.get(name) == null) {
                textMap.get(name).run();
                return;
            }
        }
    }

}
