package bossmonster.controller;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Game;
import bossmonster.domain.Player;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    public void run() {
        final Game game = initGame();
    }

    private Game initGame() {
        final BossMonster bossMonster = initBossMonsterHp();
        final Player player = initPlayer();
        return new Game(bossMonster, player);
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

    private Player initPlayer() {
        final String name = initPlayerName();
        final int[] playerInfo = initPlayerInfo();
        return new Player(name, playerInfo[0], playerInfo[1]);
    }

    private String initPlayerName() {
        while(true){
            try{
                return inputView.readPlayerName();
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private int[] initPlayerInfo() {
        while(true){
            try{
                return inputView.readPlayerInfo();
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
