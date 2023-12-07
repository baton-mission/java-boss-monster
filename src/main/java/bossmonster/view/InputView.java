package bossmonster.view;


import bossmonster.domain.Monster;
import bossmonster.domain.PlayerName;
import bossmonster.util.converter.Converter;
import bossmonster.view.printer.Printer;
import bossmonster.view.reader.Reader;
import bossmonster.view.validator.InputValidator;

public class InputView {
    private final Reader reader;
    private final Printer printer;
    private final InputValidator validator;

    private InputView(Reader reader, Printer printer, InputValidator validator) {
        this.reader = reader;
        this.printer = printer;
        this.validator = validator;
    }

    public static InputView of(Reader reader, Printer printer) {
        return new InputView(reader, printer, InputValidator.getInstance());
    }

    public Monster inputMonsterHP() {
        printer.printLine("보스 몬스터의 HP를 입력해주세요.");
        String monsterHP = reader.readLine();
        validator.validateMonsterHP(monsterHP, "보스 몬스터의 HP");
        return Monster.fromHp(Converter.convertToInt(monsterHP));
    }

    public PlayerName inputPlayerName() {
        printer.printLine("플레이어의 이름을 입력해주세요");
        String playerName = reader.readLine();
        validator.validatePlayerName(playerName, "플레이어의 이름");
        return new PlayerName(playerName);
    }
}
