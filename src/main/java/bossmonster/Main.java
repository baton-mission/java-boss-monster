package bossmonster;

import bossmonster.controller.BossMonsterController;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import bossmonster.view.printer.ConsolePrinter;
import bossmonster.view.printer.Printer;
import bossmonster.view.reader.ConsoleReader;
import bossmonster.view.reader.Reader;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Printer printer = new ConsolePrinter();

        InputView inputView = InputView.of(reader, printer);
        OutputView outputView = new OutputView(printer);

        BossMonsterController bossMonsterController = new BossMonsterController(inputView, outputView);
        bossMonsterController.run();
    }
}
