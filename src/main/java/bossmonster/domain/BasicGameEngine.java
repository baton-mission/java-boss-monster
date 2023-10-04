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
        while (boss == null){
            boss = initBoss();
        }

        while (player == null){
            player = initPlayer();
        }
        startGame();
    }

    private Boss initBoss(){
        outputProcessor.printResult("보스 몬스터의 체력을 입력해주세요.");
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
            outputProcessor.printResult("플레이어의 이름을 입력해주세요");
            String name = inputProcessor.getString();
            outputProcessor.printResult("플레이어의 HP와 MP를 입력해주세요.(,로 구분)");
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
        outputProcessor.printResult(boss);
        outputProcessor.printSectionBar();
        outputProcessor.printResult(boss.bossHitIcon());
        outputProcessor.printSectionBar();
        outputProcessor.printResult(player);
        outputProcessor.printDecorateInSection();
        outputProcessor.printResult("어떤 공격을 하시겠습니까?\n1. 물리 공격\n2. 마법 공격");
        int selected = inputProcessor.getInt();
        if (selected == 1){
           player.attack(boss, 10);
           outputProcessor.printResult(String.format("물리공격을 했습니다. (입힌 데미지: %d)",10));
        }
        if (selected == 2){
            try {
                player.magicAttack(boss, 20);
                outputProcessor.printResult(String.format("마법공격을 했습니다. (입힌 데미지: %d)",20));
            } catch (GamePolicyException e) {
                outputProcessor.printError(e);
                player.attack(boss, 10);
                outputProcessor.printResult(String.format("물리공격을 했습니다. (입힌 데미지: %d)",10));
            }
        }
        try {
            bossTurn();
        }catch (GameEndException e){
            outputProcessor.printResult(String.format("%s의 HP가 0이 되었습니다.\n보스 레이드에 실패했습니다.",player.getName()));
        }
    }

    private void bossTurn() {
        int attackValue = inputProcessor.getRandomInt(21);
        boss.attack(player,attackValue);
        outputProcessor.printResult(String.format("보스가 공격을 했습니다. (입힌 데미지: %d)",attackValue));
        outputProcessor.printDecorateInSection();
        try {
            playerTurn();
        }catch (GameEndException e){
            outputProcessor.printResult(String.format("%s 님이 %d번의 전투 끝에 보스 몬스터를 잡았습니다!", player.getName(), turnCount));
        }
    }
}
