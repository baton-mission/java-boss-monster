package bossmonster.view;

import bossmonster.dto.response.BossAndPlayerStatusDto;

public enum OutputView {
    INSTANCE;

    private static final String EXCEPTION_MESSAGE_FORMAT = "[ERROR] %s\n";
    private static final String BOSS_GAME_START_MESSAGE = "보스 레이드를 시작합니다!";
    private static final String BOSS_HP_STATUS_FORMAT = "BOSS HP [%d/%d]";
    private static final String PLAYER_STATUS_FORMAT = "%s HP [%d/%d] MP [%d/%d]";
    private static final String BOSS_PLAYER_STATUS_FORMAT = "============================\n" +
            "%s\n" +
            "____________________________\n" +
            "%s\n" +
            "____________________________\n" +
            "\n" +
            "%s\n" +
            "============================\n";

    private static final String BOSS_INIT_FACE = "   ^-^\n" +
            " / 0 0 \\\n" +
            "(   \"   )\n" +
            " \\  -  /\n" +
            "  - ^ -\n";

    public void printExceptionMessage(String message) {
        System.out.printf(EXCEPTION_MESSAGE_FORMAT, message);
    }

    public void printStartMessage() {
        System.out.println(BOSS_GAME_START_MESSAGE);
        printEmptyLine();
    }

    private void printEmptyLine() {
        System.out.println();
    }

    public void printBossAndPlayerStatus(BossAndPlayerStatusDto bossAndPlayerStatusDto) {
        String bossHpStatus = getBossHpMessage(bossAndPlayerStatusDto);
        String playerStatus = getPlayerStatusMessage(bossAndPlayerStatusDto);
        System.out.printf(BOSS_PLAYER_STATUS_FORMAT, bossHpStatus, BOSS_INIT_FACE, playerStatus);
        printEmptyLine();
    }

    private static String getPlayerStatusMessage(BossAndPlayerStatusDto bossAndPlayerStatusDto) {
        return String.format(PLAYER_STATUS_FORMAT,
                bossAndPlayerStatusDto.getPlayerName(),
                bossAndPlayerStatusDto.getCurrentPlayerHp(),
                bossAndPlayerStatusDto.getInitialPlayerHp(),
                bossAndPlayerStatusDto.getCurrentPlayerMp(),
                bossAndPlayerStatusDto.getInitialPlayerMp());
    }

    private static String getBossHpMessage(BossAndPlayerStatusDto bossAndPlayerStatusDto) {
        return String.format(BOSS_HP_STATUS_FORMAT,
                bossAndPlayerStatusDto.getCurrentBossHp(), bossAndPlayerStatusDto.getInitialBossHp());
    }
}
