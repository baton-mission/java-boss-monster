package bossmonster.view;

import bossmonster.common.MonsterImage;
import bossmonster.domain.GameCharacters;
import bossmonster.domain.Hp;
import bossmonster.domain.MonsterGame;
import bossmonster.domain.PlayerAttack;
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

    public void printCharactersInitVital(GameCharacters gameCharacters) {
        printer.printLine("보스 레이드를 시작합니다!");
        printer.printEmptyLine();
        printCharactersStatus(gameCharacters, MonsterImage.generateMonsterImageStart());
        printer.printEmptyLine();
    }

    public void printCharactersStatus(GameCharacters gameCharacters, String monsterStatus) {
        printer.printLine(DOUBLE_LINE);
        printMonsterVital(gameCharacters);
        printer.printLine(SINGLE_LINE);
        printer.printLine(monsterStatus);
        printer.printLine(SINGLE_LINE);
        printer.printEmptyLine();
        printPlayerVital(gameCharacters);
        printer.printLine(DOUBLE_LINE);
        printer.printEmptyLine();
    }

    private void printMonsterVital(GameCharacters gameCharacters) {
        int currentMonsterHp = OutputFomatter.toCurrentMonsterHp(gameCharacters);
        int totalMonsterHp = OutputFomatter.toTotalMonsterHp(gameCharacters);

        printer.printLine("BOSS HP [%d/%d]", currentMonsterHp, totalMonsterHp);
    }

    private void printPlayerVital(GameCharacters gameCharacters) {
        String playerName = OutputFomatter.toPlayerName(gameCharacters);
        int currentPlayerHp = OutputFomatter.toCurrentPlayerHp(gameCharacters);
        int totalPlayerHp = OutputFomatter.toTotalPlayerHp(gameCharacters);
        int currentPlayerMp = OutputFomatter.toCurrentPlayerMp(gameCharacters);
        int totalPlayerMp = OutputFomatter.toTotalPlayerMp(gameCharacters);

        printer.printLine("%s HP [%d/%d] MP [%d/%d]", playerName, currentPlayerHp, totalPlayerHp, currentPlayerMp, totalPlayerMp);
    }

    public void printAttack(PlayerAttack rawPlayerAttack, Hp monsterAttack) {
        String playerAttack = OutputFomatter.toPlayerAttack(rawPlayerAttack);
        int playerAttackDamage = OutputFomatter.toPlayerAttackDamage(rawPlayerAttack);
        int monsterAttackDamage = OutputFomatter.toMonsterAttackDamage(monsterAttack);

        printer.printLine("%s을 했습니다. (입힌 데미지: %d)", playerAttack, playerAttackDamage);
        printer.printLine("보스가 공격 했습니다. (입힌 데미지: %d)", monsterAttackDamage);
        printer.printEmptyLine();
    }

    public void printAttack(PlayerAttack rawPlayerAttack) {
        String playerAttack = OutputFomatter.toPlayerAttack(rawPlayerAttack);
        int playerAttackDamage = OutputFomatter.toPlayerAttackDamage(rawPlayerAttack);

        printer.printLine("%s을 했습니다. (입힌 데미지: %d)", playerAttack, playerAttackDamage);
        printer.printEmptyLine();

    }

    public void printCharactersCurrnetVital(GameCharacters gameCharacters) {
        printCharactersStatus(gameCharacters, MonsterImage.generateMonsterImageDamaged());
        printer.printEmptyLine();
    }

    public void printCharactersMonsterWinningVital(GameCharacters gameCharacters) {
        printCharactersStatus(gameCharacters, MonsterImage.generateMonsterImageWinning());
        printer.printEmptyLine();
    }

    public void printPlayerWin(MonsterGame monsterGame) {
        String playerName = OutputFomatter.toPlayerName(monsterGame);
        int gameCount = OutputFomatter.toGameCount(monsterGame);

        printer.printLine("%s 님이 %d번의 전투 끝에 보스 몬스터를 잡았습니다.", playerName, gameCount);
    }

    public void printPlayerOver(GameCharacters gameCharacters) {
        String playerName = OutputFomatter.toPlayerName(gameCharacters);

        printer.printLine("%s의 HP가 0이 되었습니다.", playerName);
        printer.printLine("보스 레이드에 실패했습니다.");
    }

    public void printExceptionMessage(String message) {
        printer.printLine(ERROR_MESSAGE_FORMAT + message);
        printer.printEmptyLine();
    }
}
