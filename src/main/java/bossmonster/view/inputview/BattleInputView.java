package bossmonster.view.inputview;

import bossmonster.view.InputValidator;
import bossmonster.view.InputView;

import java.util.Map;

import static bossmonster.controller.Parameter.PLAYER_ATTACK;
import static bossmonster.controller.Parameter.PLAYER_ATTACK_TYPE;

public class BattleInputView implements InputView {

    @Override
    public void readLine(Map<String, String> param, Map<String, Object> model) {
        getReadAttackNumber(param, model);
    }

    private void getReadAttackNumber(Map<String, String> param, Map<String, Object> model) {
        String input = InputReader.read();
        InputValidator.isNumeric(input);
        InputValidator.isValidAttackNumber(input, model.get(PLAYER_ATTACK_TYPE.getName()));
        param.put(PLAYER_ATTACK.getName(), input);
    }

}
