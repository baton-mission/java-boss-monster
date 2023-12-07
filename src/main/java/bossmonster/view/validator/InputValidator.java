package bossmonster.view.validator;

import bossmonster.common.Symbol;
import bossmonster.util.validator.GeneralValidator;
import bossmonster.util.validator.StringValidator;
import java.util.List;

public class InputValidator {
    private static InputValidator inputValidator;
    public static final String TEMPLATE_SEPARATOR = Symbol.COMMA;

    private InputValidator() {
    }

    public static InputValidator getInstance() {
        if (inputValidator == null) {
            return new InputValidator();
        }
        return inputValidator;
    }

    public void validateMonsterHP(String monsterHP, String target) {
        StringValidator.validateBlank(monsterHP, target);
        StringValidator.validateNumeric(monsterHP, target);
        StringValidator.validateIntegerRange(monsterHP, target);
    }

    public void validatePlayerName(String playerName, String target) {
        StringValidator.validateBlank(playerName, target);
    }

    public void validatePlayerVital(String playerVital, String target) {
        StringValidator.validateBlank(playerVital, target);
        GeneralValidator.validateDuplicateSubstring(Symbol.COMMA, playerVital, target);
        GeneralValidator.validateStartSubstring(Symbol.COMMA, playerVital, target);
        GeneralValidator.validateEndSubstring(Symbol.COMMA, playerVital, target);
        GeneralValidator.validateSplittedCount(Symbol.COMMA, playerVital, 2, target);
    }

    public void validateEachVital(List<String> playerVital, String target) {
        playerVital.forEach(eachVital -> StringValidator.validateBlank(eachVital, target));
        playerVital.forEach(eachVital -> StringValidator.validateNumeric(eachVital, target));
        playerVital.forEach(eachVital -> StringValidator.validateIntegerRange(eachVital, target));
    }

    public void validatePlayerAttack(String playerAttack, String target) {
        StringValidator.validateBlank(playerAttack, target);
        StringValidator.validateNumeric(playerAttack, target);
        StringValidator.validateIntegerRange(playerAttack, target);
    }
}
