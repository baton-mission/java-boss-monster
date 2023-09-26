package bossmonster.view;

public enum OutputView {
    INSTANCE;

    private static final String EXCEPTION_MESSAGE_FORMAT = "[ERROR] %s\n";

    public void printExceptionMessage(String message) {
        System.out.printf(EXCEPTION_MESSAGE_FORMAT, message);
    }
}
