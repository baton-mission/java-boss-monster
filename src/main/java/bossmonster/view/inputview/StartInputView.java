package bossmonster.view.inputview;

import bossmonster.view.InputValidator;
import bossmonster.view.InputView;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static bossmonster.controller.Parameter.*;

public class StartInputView implements InputView {
    private static final String DELIM = ",";
    private static final int PLAYER_PARAM_SIZE = 2;
    private final Map<String, Consumer<Map<String, String>>> inputMap = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, Consumer<Map<String, String>>>(BOSS_HP.getName(), readBossHp()),
            new AbstractMap.SimpleEntry<String, Consumer<Map<String, String>>>(PLAYER_NAME.getName(), readPlayerName()),
            new AbstractMap.SimpleEntry<String, Consumer<Map<String, String>>>(PLAYER_HP.getName(), readPlayerStat())
    );

    @Override
    public void readLine(Map<String, String> param, Map<String, Object> model) {
        for (String name : param.keySet()) {
            if (inputMap.containsKey(name) && param.get(name) == null) {
                inputMap.get(name).accept(param);
                return;
            }
        }

    }

    private Consumer<Map<String, String>> readBossHp() {
        return param -> {
            String input = InputReader.read();
            InputValidator.isNumeric(input);
            param.put(BOSS_HP.getName(), input);
        };
    }


    private Consumer<Map<String, String>> readPlayerName() {
        return param -> {
            String input = InputReader.read();
            InputValidator.hasSpace(input);
            param.put(PLAYER_NAME.getName(), input);
        };
    }

    private Consumer<Map<String, String>> readPlayerStat() {
        return param -> {
            String input = InputReader.read();
            InputValidator.isCorrectSize(input, DELIM, PLAYER_PARAM_SIZE);
            List<String> split = splitInput(input, DELIM);
            split.forEach(InputValidator::isNumeric);
            param.put(PLAYER_HP.getName(), split.get(0));
            param.put(PLAYER_MP.getName(), split.get(1));
        };
    }

    private List<String> splitInput(String input, String delim) {
        return Arrays.stream(input.split(delim))
                .map(String::trim)
                .toList();
    }
}
