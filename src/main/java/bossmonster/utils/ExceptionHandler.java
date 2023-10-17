package bossmonster.utils;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class ExceptionHandler {
    public static final String ERROR_PREFIX = "[ERROR] ";

    public static <T> T repeat(Supplier<T> supplier) {
        T t;
        try {
            t = supplier.get();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return repeat(supplier);
        }
        return t;
    }

    public static <T, U> void repeat(BiConsumer<T, U> biConsumer, T t, U u) {
        try {
            biConsumer.accept(t, u);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            repeat(biConsumer, t, u);
        }
    }

    private static void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
