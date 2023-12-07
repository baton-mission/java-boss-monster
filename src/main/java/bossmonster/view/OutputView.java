package bossmonster.view;

import static bossmonster.common.MonsterImage.MONSTER_IMAGE_START;

import bossmonster.domain.GameCharacters;
import bossmonster.view.formatter.OutputFomatter;
import bossmonster.view.printer.Printer;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] ";
    public static final String DOUBLE_LINE = "============================";
    public static final String SINGLE_LINE = "____________________________";
    private final Printer printer;

    public OutputView(Printer printer) {
        this.printer = printer;
    }

//    public void printTemplate(Template rawTemplate) {
//        int template = OutputFomatter.toTemplate(rawTemplate);
//        printer.printLine("%d개", template);
//    }

    public void printExceptionMessage(String message) {
        printer.printLine(ERROR_MESSAGE_FORMAT + message);
        printer.printEmptyLine();
    }

    public void printCharactersInitVital(GameCharacters gameCharacters) {
        printer.printLine("보스 레이드를 시작합니다!");
        printCharactersVital(gameCharacters, MONSTER_IMAGE_START);
        printer.printEmptyLine();
    }
    public void printCharactersVital(GameCharacters gameCharacters, String monsterStatus) {
        int currentMonsterHp = OutputFomatter.toCurrentMonsterHp(gameCharacters);
        int totalMonsterHp = OutputFomatter.toTotalMonsterHp(gameCharacters);
        String playerName = OutputFomatter.toPlayerName(gameCharacters);
        int currentPlayerHp = OutputFomatter.toCurrentPlayerHp(gameCharacters);
        int totalPlayerHp = OutputFomatter.toTotalPlayerHp(gameCharacters);
        int currentPlayerMp = OutputFomatter.toCurrentPlayerMp(gameCharacters);
        int totalPlayerMp = OutputFomatter.toTotalPlayerMp(gameCharacters);
        printer.printEmptyLine();
        printer.printLine(DOUBLE_LINE);
        printer.printLine("BOSS HP [%d/%d]", currentMonsterHp, totalMonsterHp);
        printer.printLine(SINGLE_LINE);
        printer.printLine(monsterStatus);
        printer.printLine(SINGLE_LINE);
        printer.printEmptyLine();
        printer.printLine("%s HP [%d/%d] MP [%d/%d]", playerName, currentPlayerHp, totalPlayerHp, currentPlayerMp, totalPlayerMp);
        printer.printLine(DOUBLE_LINE);
        printer.printEmptyLine();
    }
}
