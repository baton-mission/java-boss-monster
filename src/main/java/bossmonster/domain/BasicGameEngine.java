package bossmonster.domain;

import bossmonster.exception.GameEndException;
import bossmonster.view.InputProcessor;
import bossmonster.view.OutputProcessor;

import static bossmonster.view.GuideText.*;

public class BasicGameEngine implements GameEngine {
    private int turnCount = 0;
    private Player player;
    private Boss boss;
    private final InputProcessor inputProcessor;
    private final OutputProcessor outputProcessor;
    private final RuleChecker ruleChecker;

    public BasicGameEngine(InputProcessor inputProcessor, OutputProcessor outputProcessor, RuleChecker ruleChecker) {
        this.inputProcessor = inputProcessor;
        this.outputProcessor = outputProcessor;
        this.ruleChecker = ruleChecker;
    }

    @Override
    public void initGame() {
        boss = initBoss();
        player = initPlayer();
        startGame();
    }

    private Boss initBoss(){
        outputProcessor.print(BOSS_HP_INPUT);
        int bossHp = 0;
        boolean firstTimeInput = true;
        while (!ruleChecker.checkBossInitHp(bossHp)){
            if(!firstTimeInput){
                outputProcessor.printError("보스의 HP는 100 이상 300 이하여야 합니다.");
                outputProcessor.print(String.format("\n%s", BOSS_HP_INPUT));
            }
            bossHp = inputProcessor.getInt();
            firstTimeInput = false;
        }
        return new BossImpl(bossHp);
    }

    private Player initPlayer(){
        String playerName = initPlayerName();
        String[] split = initPlayerHPAndMP().split(",");
        int hp = Integer.parseInt(split[0]);
        int mp = Integer.parseInt(split[1]);
        return new PlayerImpl(playerName, hp, mp);
    }

    private String initPlayerName(){
        outputProcessor.print(PLAYER_NAME_INPUT);
        String name = "";
        boolean firstTimeInput = true;
        while (!ruleChecker.checkPlayerName(name)){
            if(!firstTimeInput){
                outputProcessor.printError("플레이어의 이름은 5글자 이하여야 합니다.");
                outputProcessor.print(PLAYER_NAME_INPUT);
            }
            name = inputProcessor.getString();
            firstTimeInput = false;
        }
        return name;
    }

    private String initPlayerHPAndMP(){
        outputProcessor.print(PLAYER_HP_MP_INPUT);
        String hpAndMP = "";
        boolean firstTimeInput = true;
        while (!ruleChecker.checkPlayerHpAndMP(hpAndMP)){
            if(!firstTimeInput){
                outputProcessor.printError("플레이어의 HP와 MP의 합은 200이어야합니다.");
                outputProcessor.print(PLAYER_HP_MP_INPUT);
            }
            hpAndMP = inputProcessor.getString();
            firstTimeInput = false;
        }
        return hpAndMP;
    }

    private void startGame() {
        if (!canStart()){
            return;
        }
        outputProcessor.print(GAME_START);
        printStatus();
        try {
            playerTurn();
        }catch (GameEndException e){
            outputProcessor.print(String.format(KILL_BOSS, player.getName(), turnCount));
        }
    }

    private boolean canStart(){
        return player != null && boss != null;
    }

    private void playerTurn() {
        updateTurnCount();
        if(!boss.isNew()){
            printStatus();
        }
        outputProcessor.printDecoration();
        outputProcessor.print(ATTACK_STRATEGY);
        while (true) {
            try {
                int attackType = inputProcessor.getInt();
                playerAttack(attackType);
                break;
            } catch (IllegalArgumentException e) {
                outputProcessor.printError(e.getMessage());
            }
        }
        bossTurn();
    }

    private void updateTurnCount() {
        turnCount = turnCount + 1;
    }

    private boolean playerAttack(int attackType){
        if(attackType == 1){
            playerNormalAttack();
            return true;
        }
        if(attackType == 2){
            return playerMagicAttack();
        }
        throw new IllegalArgumentException("없는 공격 타입");
    }

    private boolean playerMagicAttack(){
        if(!ruleChecker.checkPlayerCanMagicAttack(player, 30)) {
            outputProcessor.printError("MP가 부족해 마법공격을 할 수 없습니다.");
            playerNormalAttack();
            return false;
        }
        player.magicAttack(boss, 20);
        outputProcessor.print(String.format(MAGIK_ATTACK, 20));
        return true;
    }

    private void playerNormalAttack(){
        player.attack(boss, 10);
        outputProcessor.print(String.format(NORMAL_ATTACK, 10));
    }

    private void printStatus() {
        outputProcessor.print(NEW_LINE_DOUBLE_LINE);
        outputProcessor.print(boss);
        printBossImage();
        outputProcessor.print(player);
    }

    private void printBossImage(){
        outputProcessor.print(SINGLE_LINE);
        if(boss.isNew()){
            outputProcessor.print(boss.bossIcon());
        }
        if(!boss.isNew()) {
            outputProcessor.print(boss.bossHitIcon());
        }
        outputProcessor.print(SINGLE_LINE_NEW_LINE);
    }

    private void bossTurn() {
        int attackValue = inputProcessor.getRandomInt(21);
        boss.attack(player,attackValue);
        outputProcessor.print(String.format(BOSS_ATTACK, attackValue));
        try {
            playerTurn();
        }catch (GameEndException e){
            outputProcessor.print(String.format(KILL_BOSS, player.getName(), turnCount));
        }
    }
}
