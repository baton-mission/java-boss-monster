package bossmonster.view;

import bossmonster.domain.dto.GameHistoryDto;
import bossmonster.view.constants.Message;
import java.util.LinkedHashMap;

public class OutputView {

    public static void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public static void printGameStatus(GameHistoryDto gameHistoryDto) {
        printNewLine();
        printBossMonsterStatus(gameHistoryDto);
        printBossMonster(gameHistoryDto);
        printPlayerStatus(gameHistoryDto);
    }

    public static void printAttackType(LinkedHashMap<Integer, String> attackType) {
        System.out.println(Message.INPUT_ATTACK_TYPE_SELECT.getMessage());
        for (int number : attackType.keySet()) {
            System.out.println(String.format(Message.INPUT_ATTACK_TYPE.getMessage(), number, attackType.get(number)));
        }
    }

    public static void printTurnResult(GameHistoryDto gameHistoryDto) {
        System.out.println(
                String.format(Message.OUTPUT_TURN_RESULT_PLAYER.getMessage(), gameHistoryDto.getPlayerAttackType(),
                        gameHistoryDto.getPlayerAttackDamage()));
        System.out.println(
                String.format(Message.OUTPUT_TURN_RESULT_BOSS.getMessage(), gameHistoryDto.getMonsterAttackDamage()));
    }

    public static void printPlayerWin(GameHistoryDto gameHistoryDto) {
        System.out.println(
                String.format(Message.OUTPUT_GAME_OVER_PLAYER_WIN.getMessage(), gameHistoryDto.getPlayerName(),
                        gameHistoryDto.getTurnCount()));
    }

    public static void printPlayerLose(GameHistoryDto gameHistoryDto) {
        System.out.println(
                String.format(Message.OUTPUT_GAME_OVER_PLAYER_LOSE.getMessage(), gameHistoryDto.getPlayerName(),
                        gameHistoryDto.getPlayerCurrentHP()));
    }

    private static void printNewLine() {
        System.out.println();
    }

    private static void printBossMonsterStatus(GameHistoryDto gameHistoryDto) {
        System.out.println(Message.OUTPUT_LINE_ONE.getMessage());
        System.out.println(String.format(Message.OUTPUT_BOSS_STATUS.getMessage(), gameHistoryDto.getMonsterCurrentHP(),
                gameHistoryDto.getMonsterMaxHP()));
        System.out.println(Message.OUTPUT_LINE_TWO.getMessage());
    }

    private static void printPlayerStatus(GameHistoryDto gameHistoryDto) {
        System.out.println(Message.OUTPUT_LINE_TWO.getMessage());
        System.out.println(
                String.format(Message.OUTPUT_PLAYER_STATUS.getMessage(), gameHistoryDto.getPlayerName(),
                        gameHistoryDto.getPlayerCurrentHP(), gameHistoryDto.getPlayerMaxHP(),
                        gameHistoryDto.getPlayerCurrentMP(), gameHistoryDto.getPlayerMaxMP()));
        System.out.println(Message.OUTPUT_LINE_ONE.getMessage());
    }

    private static void printBossMonster(GameHistoryDto gameHistoryDto) {
        if (!gameHistoryDto.isGameStatus() && gameHistoryDto.getPlayerCurrentHP() == 0) {
            System.out.println(Message.OUTPUT_BOSS_WIN.getMessage());
        }
        if (gameHistoryDto.isGameStatus() && gameHistoryDto.getMonsterCurrentHP() == gameHistoryDto.getMonsterMaxHP()) {
            System.out.println(Message.OUTPUT_BOSS_DEFAULT.getMessage());
        }
        if (gameHistoryDto.isGameStatus() && gameHistoryDto.getMonsterCurrentHP() < gameHistoryDto.getMonsterMaxHP()) {
            System.out.println(Message.OUTPUT_BOSS_DAMAGED.getMessage());
        }
    }
}
