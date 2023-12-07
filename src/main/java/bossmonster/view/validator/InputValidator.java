package bossmonster.view.validator;

import bossmonster.common.Symbol;
import bossmonster.util.validator.StringValidator;

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
}
