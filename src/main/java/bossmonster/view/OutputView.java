package bossmonster.view;

import java.util.Map;

public interface OutputView {
    void show(Map<String, String> param, Map<String, Object> model);
}
