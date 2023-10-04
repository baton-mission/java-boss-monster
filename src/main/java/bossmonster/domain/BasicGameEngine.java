package bossmonster.domain;

import bossmonster.exception.GameEndException;
import bossmonster.exception.GamePolicyException;
import bossmonster.view.InputProcessor;
import bossmonster.view.OutputProcessor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicGameEngine implements GameEngine {
    private int turnCount = 0;
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
        outputProcessor.printResult("보스 레이드를 시작합니다!");
        outputProcessor.printResult(boss);
        outputProcessor.printSectionBar();
        outputProcessor.printResult(boss.bossIcon());
        outputProcessor.printSectionBar();
        try {
            playerTurn();
        }catch (GameEndException e){
            outputProcessor.printResult(String.format("%s 님이 %d번의 전투 끝에 보스 몬스터를 잡았습니다!", player.getName(), turnCount));
        }
    }

    private boolean canStart(){
        return player != null && boss != null;
    }
    private void playerTurn() {
        turnCount = turnCount + 1;
        outputProcessor.printResult(player);
        outputProcessor.printDecorateInSection();
        outputProcessor.printResult("어떤 공격을 하시겠습니까?\n1. 물리 공격\n2. 마법 공격");
        int selected = inputProcessor.getInt();
        if (selected == 1){
           player.attack(boss, 10);
        }
        if (selected == 2){
            try {
                player.magicAttack(boss, 30);
            } catch (GamePolicyException e) {
                outputProcessor.printError(e);
                player.attack(boss, 10);
            }
        }
    }

    private void bossTurn() {

    }

    private void endGame(OutputProcessor outputProcessor) {

    }
}
