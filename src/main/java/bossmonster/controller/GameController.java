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
        outputView.printInit(game);
        operate(game);
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

    private void operate(Game game){
        while(true){
            int type = inputAttackType();
            game = controlAttack(game, type);

            game.addNumverOfTimes();

            boolean bossDie= bossMonsterController.die(game.getBossMonster());
            boolean playerDie = playerController.die(game.getPlayer());

            if(!bossDie){
                outputView.printResult(game, playerDie);
            }


            if(bossDie){
                outputView.printWinMessage(game);
                break;
            }

            if(playerDie){
                outputView.printFailMessage();
                break;
            }
        }

    }
    private Game controlAttack(Game game, int type){
        if(type==1){
            return startPhysicalAttack(game);
        }
        return startMagicAttack(game);
    }

    private Game startPhysicalAttack(Game game){
        BossMonster newBossMonster = bossMonsterController.hit(game.getBossMonster(), 10);
        Player player = playerController.recover(game.getPlayer());
        int random = getRandomNumber();
        Player newPlayer = playerController.hit(player, random);
        game = new Game(newBossMonster, newPlayer);
        outputView.printPhysicalAttack(random, bossMonsterController.die(game.getBossMonster()));
        return game;
    }

    private Game startMagicAttack(Game game) {
        BossMonster newBossMonster = bossMonsterController.hit(game.getBossMonster(), 20);
        int random = getRandomNumber();
        Player newPlayer = playerController.hit(game.getPlayer(), 30 + random);
        game = new Game(newBossMonster, newPlayer);
        outputView.printMagicAttack(random, bossMonsterController.die(game.getBossMonster()));
        return game;
    }

    private int getRandomNumber(){
        return (int)(Math.random()*20);
    }
}
