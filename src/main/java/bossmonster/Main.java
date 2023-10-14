package bossmonster;

import bossmonster.domain.BasicGameEngine;
import bossmonster.domain.BasicRuleChecker;
import bossmonster.domain.GameEngine;
import bossmonster.domain.RuleChecker;
import bossmonster.view.InputProcessor;
import bossmonster.view.InputProcessorByScanner;
import bossmonster.view.OutputProcessor;
import bossmonster.view.OutputProcessorBySystemOut;

public class Main {
    public static void main(String[] args) {
        InputProcessor inputProcessor = new InputProcessorByScanner();
        OutputProcessor outputProcessor = new OutputProcessorBySystemOut();
        RuleChecker ruleChecker = new BasicRuleChecker();

        GameEngine gameEngine = new BasicGameEngine(inputProcessor, outputProcessor, ruleChecker);
        gameEngine.initGame();
    }
}
