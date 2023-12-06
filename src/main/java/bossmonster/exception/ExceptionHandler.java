package bossmonster.exception;

import bossmonster.view.OutputView;
import java.util.function.Supplier;

public class ExceptionHandler {

    public static <T> T retryInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
            }
        }
    }


    /*
    public static void retryInput(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (IllegalArgumentException exception) {
            }
        }
    }
     */
}
