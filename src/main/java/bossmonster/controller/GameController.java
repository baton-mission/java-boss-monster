package bossmonster.controller;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Game;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    public void run() {
//        final Game game = initGame();
        initGame();
    }

//    private Game initGame() {
    private void initGame() {
        final BossMonster bossMonster = initBossMonsterHp();
    }

    private BossMonster initBossMonsterHp() {
        while(true){
            try{
                final int bossMonsterHp = inputView.readBossMonsterHp();
                return new BossMonster(bossMonsterHp);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
