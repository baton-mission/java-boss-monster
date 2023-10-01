package bossmonster.view;

import bossmonster.dto.response.BossAndPlayerStatusDto;
import bossmonster.dto.response.BossAttackDto;
import bossmonster.dto.response.PlayerBossInfoDto;

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

    private static final String BOSS_WIN_FACE = "   ^-^\n" +
            " / ^ ^ \\\n" +
            "(   \"   )\n" +
            " \\  3  /\n" +
            "  - ^ -\n";

    private static final String BOSS_BAD_FACE = "   ^-^\n" +
            " / x x \\\n" +
            "(   \"\\  )\n" +
            " \\  ^  /\n" +
            "  - ^ -\n";

    private static final String ATTACK_MESSAGE_FORMAT = "%s을 했습니다. (입힌 데미지: %d)\n";
    private static final String BOSS_DEAD_MESSAGE_FORMAT = "%s 님이 %d번의 전투 끝에 보스 몬스터를 잡았습니다.\n";

    private static final String BOSS_ATTACK_MESSAGE_FORMAT = "보스가 공격 했습니다. (입힌 데미지: %d)\n";

    private static final String PLAYER_DEAD_MESSAGE_FORMAT = "%s의 HP가 0이 되었습니다.\n";

    private static final String BOSS_GAME_FAIL_MESSAGE = "보스 레이드에 실패했습니다.\n";

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
        printBossAndPlayer(bossAndPlayerStatusDto.getCurrentBossHp(),
                bossAndPlayerStatusDto.getInitialBossHp(),
                bossAndPlayerStatusDto.getPlayerName(),
                bossAndPlayerStatusDto.getCurrentPlayerHp(),
                bossAndPlayerStatusDto.getInitialPlayerHp(),
                bossAndPlayerStatusDto.getCurrentPlayerMp(),
                bossAndPlayerStatusDto.getInitialPlayerMp(),
                BOSS_INIT_FACE);
    }

    private void printBossAndPlayer(int currentBossHp, int initialBossHp, String playerName, int currentPlayerHp,
                                    int initialPlayerHp, int currentPlayerMp, int initialPlayerMp, String bossFace) {
        String bossHpStatus = getBossHpMessage(currentBossHp,
                initialBossHp);
        String playerStatus = getPlayerStatusMessage(playerName,
                currentPlayerHp,
                initialPlayerHp,
                currentPlayerMp,
                initialPlayerMp);
        System.out.printf(BOSS_PLAYER_STATUS_FORMAT, bossHpStatus, bossFace, playerStatus);
        printEmptyLine();
    }

    private static String getPlayerStatusMessage(String playerName, int currentPlayerHp, int initialPlayerHp,
                                                 int currentPlayerMp, int initialPlayerMp) {
        return String.format(PLAYER_STATUS_FORMAT, playerName, currentPlayerHp, initialPlayerHp,
                currentPlayerMp, initialPlayerMp);
    }

    private static String getBossHpMessage(int currentBossHp, int initialBossHp) {
        return String.format(BOSS_HP_STATUS_FORMAT, currentBossHp, initialBossHp);
    }

    public void printBossDeadMessage(BossAttackDto bossDeadResponseDto) {
        printPlayerAttackMessage(bossDeadResponseDto.getAttackTypeName(), bossDeadResponseDto.getAttackDamage());
        printEmptyLine();
        System.out.printf(BOSS_DEAD_MESSAGE_FORMAT,
                bossDeadResponseDto.getAttackerPlayerName(), bossDeadResponseDto.getTotalTryCount());
    }

    private void printPlayerAttackMessage(String attackTypeName, int attackDamage) {
        System.out.printf(ATTACK_MESSAGE_FORMAT, attackTypeName, attackDamage);
    }

    public void printPlayerDeadMessage(PlayerBossInfoDto playerDeadResponseDto) {
        printPlayerAttackMessage(playerDeadResponseDto.getAttackTypeName(), playerDeadResponseDto.getAttackDamage());
        printBossAttackMessage(playerDeadResponseDto.getBossAttackDamage());
        printEmptyLine();
        printBossAndPlayer(playerDeadResponseDto.getBossCurrentHp(),
                playerDeadResponseDto.getBossInitialHp(),
                playerDeadResponseDto.getPlayerName(),
                playerDeadResponseDto.getPlayerCurrentHp(),
                playerDeadResponseDto.getPlayerInitialHp(),
                playerDeadResponseDto.getPlayerCurrentMp(),
                playerDeadResponseDto.getPlayerInitialMp(),
                BOSS_WIN_FACE);
        System.out.printf(PLAYER_DEAD_MESSAGE_FORMAT, playerDeadResponseDto.getPlayerName());
        System.out.println(BOSS_GAME_FAIL_MESSAGE);
    }

    private void printBossAttackMessage(int bossAttackDamage) {
        System.out.printf(BOSS_ATTACK_MESSAGE_FORMAT, bossAttackDamage);
    }

    public void printGameCurrentStatus(PlayerBossInfoDto playerBossInfoResponseDto) {
        printPlayerAttackMessage(playerBossInfoResponseDto.getAttackTypeName(), playerBossInfoResponseDto.getAttackDamage());
        printBossAttackMessage(playerBossInfoResponseDto.getBossAttackDamage());
        printEmptyLine();
        printBossAndPlayer(playerBossInfoResponseDto.getBossCurrentHp(),
                playerBossInfoResponseDto.getBossInitialHp(),
                playerBossInfoResponseDto.getPlayerName(),
                playerBossInfoResponseDto.getPlayerCurrentHp(),
                playerBossInfoResponseDto.getPlayerInitialHp(),
                playerBossInfoResponseDto.getPlayerCurrentMp(),
                playerBossInfoResponseDto.getPlayerInitialMp(),
                BOSS_BAD_FACE);
    }
}
