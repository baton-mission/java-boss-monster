package bossmonster.controller;

import bossmonster.controller.dto.PlayerStatsDto;
import bossmonster.domain.monster.Monster;
import bossmonster.domain.game.MonsterGame;
import bossmonster.domain.player.Player;
import bossmonster.domain.player.Skill;
import bossmonster.domain.player.PlayerName;
import bossmonster.domain.player.PlayerStats;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;


public class GameController {

    InputView inputView;
    OutputView outputView;
    MonsterGame monsterGame;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        init();
        start();
        play();
        printResult();
    }
    private void init() {
        Monster monster = createBossMonster();
        Player player = createPlayer();
        monsterGame = new MonsterGame(monster, player);
    }

    private void start() {
        printStart();
        printPlayerAndMonsterInfo();
        monsterGame.start();
    }
    private void printStart() {
        outputView.printStart();
    }

    private void play() {
        while (monsterGame.isRun()) {
            proceedPlayerTurn();
            proceedBossMonsterTurn();
            printPlayerAndMonsterInfo();
        }
    }
    private void proceedPlayerTurn() {
        while (true) {
            try {
                String skillNo = inputView.askSkillNo();
                Skill skill = monsterGame.attackMonster(skillNo);
                outputView.printPlayerAttack(skill);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private void proceedBossMonsterTurn() {
        if (monsterGame.isMonsterAlive()) {
            int bossDamage = monsterGame.attackPlayer();
            outputView.printMonsterAttack(bossDamage);
        }
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
                PlayerStatsDto playerStatsDto = PlayerStatsDto.of(inputView.askPlayerHPAndMP());
                int hp = playerStatsDto.getHp();
                int mp = playerStatsDto.getMp();
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
