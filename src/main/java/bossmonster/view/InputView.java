package bossmonster.view;


import bossmonster.common.Symbol;
import bossmonster.domain.Monster;
import bossmonster.domain.PlayerAttack;
import bossmonster.domain.PlayerName;
import bossmonster.domain.PlayerVital;
import bossmonster.util.converter.Converter;
import bossmonster.view.printer.Printer;
import bossmonster.view.reader.Reader;
import bossmonster.view.validator.InputValidator;

public class InputView {
    public static final String PLAYER_VITAL_SEPARATOR = Symbol.COMMA;
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

    public PlayerVital inputPlayerVital() {
        printer.printLine("플레이어의 HP와 MP를 입력해주세요.(,로 구분)");
        String playerVital = reader.readLine();
        validator.validatePlayerVital(playerVital, "플레이어의 HP와 MP");
        validator.validateEachVital(Converter.splitToList(PLAYER_VITAL_SEPARATOR, playerVital), "플레이어의 각 HP와 MP");
        return PlayerVital.of(Converter.splitToIntegerList(PLAYER_VITAL_SEPARATOR, playerVital));
    }

    public PlayerAttack inputPlayerAttack() {
        printer.printLine("어떤 공격을 하시겠습니까?");
        printer.printLine("%d. %s", PlayerAttack.PHYSICAL_ATTACK.getUserCommand(),
                PlayerAttack.PHYSICAL_ATTACK.getMessage());
        printer.printLine("%d. %s", PlayerAttack.MAGICAL_ATTACK.getUserCommand(),
                PlayerAttack.MAGICAL_ATTACK.getMessage());
        String playerAttack = reader.readLine();
        printer.printEmptyLine();
        validator.validatePlayerAttack(playerAttack, "공격 종류");
        return PlayerAttack.from(Converter.convertToInt(playerAttack));
    }
}
