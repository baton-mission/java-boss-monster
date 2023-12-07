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

    public static void validateTemplate(String template, String target) {
        StringValidator.validateBlank(template, target);
        StringValidator.validateNumeric(template, target);
        StringValidator.validateIntegerRange(template, target);
    }
}
