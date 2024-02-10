package bossmonster.controller;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Game;
import bossmonster.domain.Player;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BossMonsterController bossMonsterController = new BossMonsterController();
    private final PlayerController playerController = new PlayerController();

    public void run() {
        final Game game = initGame();
        outputView.printStartSentence();
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

    private int inputAttackType(){
        while(true){
            try{
                return inputView.inputAttack();
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void controlAttack(Game game){
        while(true){
            int type = inputAttackType();
            if(type == 1){
                game = startPhysicalAttack(game);
            }else{
                game = startMagicAttack(game);
            }
            if(bossMonsterController.die(game.getBossMonster())){
                //BossMonster is dead
                break;
            }
            if(playerController.die(game.getPlayer())){
                //Player id dead
                break;
            }
        }

    }

    private Game startPhysicalAttack(Game game){
        BossMonster newBossMonster = bossMonsterController.hit(game.getBossMonster(), 10);
        Player player = playerController.recover(game.getPlayer());
        Player newPlayer = playerController.hit(player, getRandomNumber());
        return new Game(newBossMonster, newPlayer);
    }

    private Game startMagicAttack(Game game) {
        BossMonster newBossMonster = bossMonsterController.hit(game.getBossMonster(), 20);
        Player newPlayer = playerController.hit(game.getPlayer(), 30 + getRandomNumber());
        return new Game(newBossMonster, newPlayer);
    }

    private int getRandomNumber(){
        return (int)(Math.random()*20);
    }
}
