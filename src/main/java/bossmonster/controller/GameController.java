package bossmonster.controller;

import bossmonster.domain.monster.Monster;
import bossmonster.domain.game.MonsterGame;
import bossmonster.domain.player.Player;
import bossmonster.domain.number.RandomNumberGenerator;
import bossmonster.domain.player.Skill;
import bossmonster.domain.player.PlayerName;
import bossmonster.domain.player.PlayerStats;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

//값을 전달해줘야하는 객체는 값을 잘 전달해줘야하는 책임이 있음
// 자기가 다루지 못하는 값이 들어오면 예외를 발생시켜야함
//유틸클래스도 쓸수있는곳이 명확해야한다? 재사용성
//dto ??

public class GameController {

    InputView inputView;
    OutputView outputView;
    MonsterGame monsterGame;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        init();
        proceedGame();
        printResult();
    }

    private void init() {
        Monster monster = createBossMonster();
        Player player = createPlayer();
        monsterGame = new MonsterGame(monster, player);
    }

    private void proceedGame() {
        startGame();

        while (monsterGame.isRun()) {
            proceedPlayerTurn();
            proceedBossMonsterTurn();
            printPlayerAndMonsterInfo();
        }
    }

    private void startGame() {
        outputView.printStart();
        printPlayerAndMonsterInfo();
        monsterGame.start();
    }

    private void printPlayerAndMonsterInfo() {
        if (monsterGame.isMonsterAlive()) {
            outputView.printMonsterInfo(monsterGame.getMonster());
            outputView.printMonsterCharacter(monsterGame.getGameStatus());
            outputView.printPlayerInfo(monsterGame.getPlayer());
        }
    }

    private void printResult() {
        Player player = monsterGame.getPlayer();
        if (monsterGame.isPlayerWin()) {
            int matchCount = monsterGame.getMatchCount();
            outputView.printWin(player, matchCount);
            return;
        }
        outputView.printLose(player);
    }

    private void proceedPlayerTurn() {
        while (true) {
            try {
                Skill skill = askSkill();
                monsterGame.proceedPlayerTurn(skill);
                outputView.printPlayerAttack(skill);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }

    }

    private Skill askSkill() {
        while (true) {
            try {
                String skillNo = inputView.askSkillNo();
                return Skill.getSkillBySkillNo(skillNo);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private void proceedBossMonsterTurn() {
        if (monsterGame.isMonsterAlive()) {
            int damage = RandomNumberGenerator.getRandomNumber(); // 몬스터게임 안에 들어가면 테스트 하기힘들어짐
            monsterGame.proceedMonsterTurn(damage);
            outputView.printMonsterAttack(damage);
        }
    }

    private Player createPlayer() {
        PlayerName playerName = createPlayerName();
        PlayerStats playerStats = createPlayerStats();
        return new Player(playerName, playerStats);
    }

    private PlayerName createPlayerName() {
        while (true) {
            try {
                return new PlayerName(inputView.askPlayerName());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private PlayerStats createPlayerStats() {
        while (true) {
            try {
                String hpAndMp = inputView.askPlayerHPAndMP();
                String[] hpAndMpSplit = hpAndMp.split(",");
                int hp = Integer.parseInt(hpAndMpSplit[0]);
                int mp = Integer.parseInt(hpAndMpSplit[1]); // dto로 변환하던가 gameview에서 해야되나?
                return PlayerStats.createPlayerStats(hp, mp);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private Monster createBossMonster() {
        while (true) {
            try {
                int monsterHP = inputView.askBossMonsterHP();
                return new Monster(monsterHP);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}
