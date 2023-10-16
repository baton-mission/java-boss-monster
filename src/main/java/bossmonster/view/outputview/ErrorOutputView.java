package bossmonster.view.outputview;

import bossmonster.view.OutputView;

import java.util.Map;

import static bossmonster.controller.Parameter.ERROR;

public class ErrorOutputView implements OutputView {
    @Override
    public void show(Map<String, String> param, Map<String, Object> model) {
        System.out.println(param.get(ERROR.getName()));
        param.remove(ERROR.getName());
    }
}
