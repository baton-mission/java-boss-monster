package bossmonster.game;

import bossmonster.controller.GameInitController;
import bossmonster.controller.GamePlayController;
import bossmonster.domain.scanner.GameInputScanner;
import bossmonster.domain.scanner.GameInputScannerImpl;
import bossmonster.view.ErrorView;
import bossmonster.view.InputView;
import bossmonster.view.ResultView;

public class GameFactory {
    private final GameInputScanner scanner = new GameInputScannerImpl();
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final ErrorView errorView = new ErrorView();
    private final GameInitController gameInitController = new GameInitController(
            scanner,
            inputView,
            resultView,
            errorView
    );
    private final GamePlayController gamePlayController = new GamePlayController(
            gameInitController.initBossMonster(),
            gameInitController.initPlayer(),
            scanner,
            inputView,
            resultView,
            errorView
    );

    public GameClient createGame() {
        return new GameClient(gamePlayController);
    }
}
