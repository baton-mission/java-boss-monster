package bossmonster.view;

public enum OutputView {
    INSTANCE;

    private static final String EXCEPTION_MESSAGE_FORMAT = "[ERROR] %s\n";
    private static final String BOSS_GAME_START_MESSAGE = "보스 레이드를 시작합니다!";

    public void printExceptionMessage(String message) {
        System.out.printf(EXCEPTION_MESSAGE_FORMAT, message);
    }

    public void printStartMessage() {
        System.out.println(BOSS_GAME_START_MESSAGE);
    }
}
