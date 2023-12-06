package bossmonster.exception;

import bossmonster.view.OutputView;
import java.util.function.Supplier;

public class ExceptionHandler {

    public static <T> T retryInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception exception) {
                OutputView.printError(exception);
            }
        }
    }
}
