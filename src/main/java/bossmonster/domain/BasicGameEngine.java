package bossmonster.domain;

import bossmonster.view.InputProcessor;
import bossmonster.view.OutputProcessor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicGameEngine implements GameEngine {
    private Player player;
    private Boss boss;
    private final InputProcessor inputProcessor;
    private final OutputProcessor outputProcessor;

    public BasicGameEngine(InputProcessor inputProcessor, OutputProcessor outputProcessor) {
        this.inputProcessor = inputProcessor;
        this.outputProcessor = outputProcessor;
    }

    @Override
    public void initGame() {
        while (boss != null){
            boss = initBoss();
        }

        while (player != null){
            player = initPlayer();
        }
        startGame();
    }

    private Boss initBoss(){
        Boss tmp = null;
        try {
            int bossHp = inputProcessor.getInt();
            tmp = new BossImpl(bossHp);
        }catch (IllegalArgumentException e){
            outputProcessor.printError(e);
        }catch (InputMismatchException e){
            outputProcessor.printError(e);
        }
        return tmp;
    }

    private Player initPlayer(){
        Player tmp = null;
        try {
            String name = inputProcessor.getString();
            String hpAndMp = inputProcessor.getString();
            String[] split = hpAndMp.split(",");
            int hp = Integer.parseInt(split[0]);
            int mp = Integer.parseInt(split[1]);
            tmp = new PlayerImpl(name, hp, mp);
        }catch (IllegalArgumentException e){
            outputProcessor.printError(e);
        }catch (InputMismatchException e){
            outputProcessor.printError(e);
        }catch (ArrayIndexOutOfBoundsException e){
            outputProcessor.printError(e);
        }
        return tmp;
    }
    private void startGame() {
        if (!canStart()){
            return;
        }
        outputProcessor.printResult(boss);
        outputProcessor.printSectionBar();
        outputProcessor.printResult(boss.bossIcon());
        outputProcessor.printSectionBar();
        playerTurn();
    }

    private boolean canStart(){
        return player != null && boss != null;
    }
    private void playerTurn() {

    }

    private void bossTurn() {

    }

    private void endGame(OutputProcessor outputProcessor) {

    }
}
