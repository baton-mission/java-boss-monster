package bossmonster.domain;

import bossmonster.exception.GameEndException;
import bossmonster.view.InputProcessor;
import bossmonster.view.OutputProcessor;

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
        outputProcessor.print("보스 몬스터의 체력을 입력해주세요.");
        int bossHp = 0;
        boolean firstTimeInput = true;
        while (!ruleChecker.checkBossInitHp(bossHp)){
            if(!firstTimeInput){
                outputProcessor.printError("보스의 HP는 100 이상 300 이하여야 합니다.");
                outputProcessor.print("\n보스 몬스터의 체력을 입력해주세요.");
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
        outputProcessor.print("\n플레이어의 이름을 입력해주세요");
        String name = "";
        boolean firstTimeInput = true;
        while (!ruleChecker.checkPlayerName(name)){
            if(!firstTimeInput){
                outputProcessor.printError("플레이어의 이름은 5글자 이하여야 합니다.");
                outputProcessor.print("\n플레이어의 이름을 입력해주세요");
            }
            name = inputProcessor.getString();
            firstTimeInput = false;
        }
        return name;
    }

    private String initPlayerHPAndMP(){
        outputProcessor.print("\n플레이어의 HP와 MP를 입력해주세요.(,로 구분)");
        String hpAndMP = "";
        boolean firstTimeInput = true;
        while (!ruleChecker.checkPlayerHpAndMP(hpAndMP)){
            if(!firstTimeInput){
                outputProcessor.printError("플레이어의 HP와 MP의 합은 200이어야합니다.");
                outputProcessor.print("\n플레이어의 HP와 MP를 입력해주세요.(,로 구분)");
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
        outputProcessor.print("\n보스 레이드를 시작합니다!");
        printStatus();
        try {
            playerTurn();
        }catch (GameEndException e){
            outputProcessor.print(String.format("%s 님이 %d번의 전투 끝에 보스 몬스터를 잡았습니다!", player.getName(), turnCount));
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
        outputProcessor.print("어떤 공격을 하시겠습니까?\n1. 물리 공격\n2. 마법 공격");
        while (true) {
            try {
                int attackType = inputProcessor.getInt();
                playerAttack(attackType);
                break;
            } catch (IllegalArgumentException e) {
                outputProcessor.printError(e.getMessage());
            }
        }
        try {
            bossTurn();
        }catch (GameEndException e){
            outputProcessor.print(String.format("%s의 HP가 0이 되었습니다.\n보스 레이드에 실패했습니다.",player.getName()));
        }
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
        outputProcessor.print(String.format("\n마법공격을 했습니다. (입힌 데미지: %d)", 20));
        return true;
    }

    private void playerNormalAttack(){
        player.attack(boss, 10);
        outputProcessor.print(String.format("\n물리공격을 했습니다. (입힌 데미지: %d)",10));
    }

    private void printStatus() {
        outputProcessor.print("\n============================");
        outputProcessor.print(boss);
        printBossImage();
        outputProcessor.print(player);
    }

    private void printBossImage(){
        outputProcessor.print("____________________________");
        if(boss.isNew()){
            outputProcessor.print(boss.bossIcon());
        }
        if(!boss.isNew()) {
            outputProcessor.print(boss.bossHitIcon());
        }
        outputProcessor.print("____________________________\n");
    }

    private void bossTurn() {
        int attackValue = inputProcessor.getRandomInt(21);
        boss.attack(player,attackValue);
        outputProcessor.print(String.format("보스가 공격을 했습니다. (입힌 데미지: %d)",attackValue));
        try {
            playerTurn();
        }catch (GameEndException e){
            outputProcessor.print(String.format("\n%s 님이 %d번의 전투 끝에 보스 몬스터를 잡았습니다!", player.getName(), turnCount));
        }
    }
}
