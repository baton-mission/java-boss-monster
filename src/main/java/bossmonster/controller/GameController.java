package bossmonster.controller;

import bossmonster.domain.GameResult;
import bossmonster.domain.GameStatus;
import bossmonster.domain.Monster;
import bossmonster.domain.MonsterGame;
import bossmonster.domain.Player;
import bossmonster.domain.RandomNumberGenerator;
import bossmonster.domain.Skill;
import bossmonster.view.GameView;

//todo controller 놨두고? game 도메인 놨두고?
public class GameController {

    GameView gameView;

    MonsterGame monsterGame;

    Player player;
    Monster monster;

    public GameController(GameView gameView) {
        this.gameView = gameView;
    }

    public void play() {
        init();
        proceedGame();
        printResult();
    }
    private void init() {
        monster = createBossMonster();
        player = createPlayer();
        monsterGame = new MonsterGame(monster,player);
        gameView.printStartGame(player,monster);
    }

    private void proceedGame() {
        do {
            proceedPlayerTurn();
            proceedBossMonsterTurn();
            gameView.enter();
            updateGame();
            printProgressInformation();
        } while (monsterGame.isGameInProgress());
    }

    private void printProgressInformation() {
        if(monster.isAlive()) {
            gameView.printGameProgress(player,monster);
        }
    }

    private void updateGame() {
        monsterGame.updateGame();
    }

    private void printResult() {
        GameResult gameResult = monsterGame.getGameResult();
        if(gameResult == GameResult.WIN) {
            gameView.printWin(player);
        } else {
            gameView.printLose(player);
        }
    }


    private void proceedPlayerTurn() {
        while (true) {
            try {
                Skill skill = askSkill(); // 스킬모르니까 스킬한테 물어보고 게임한테 이스킬써줘 하고 말하는거 <<메뉴판과 같은거라 생각함
                monsterGame.proceedPlayerTurn(skill);
                gameView.printPlayerAttack(skill);
                return;
            } catch (IllegalArgumentException e) {
                gameView.printErrorMessage(e);
            }
        }

    }
    private Skill askSkill() {
        while (true) {
            try {
                String skillNo = gameView.askSkillNo();
                return Skill.getSkillBySkillNo(skillNo);
            } catch (IllegalArgumentException e) {
                gameView.printErrorMessage(e);
            }
        }
    }



    private void proceedBossMonsterTurn() {
        if(monster.isAlive()) {
            int damage = RandomNumberGenerator.getRandomNumber();
            monsterGame.proceedMonsterTurn(damage);
            gameView.printMonsterAttack(damage);
        }
    }

    private Player createPlayer() {
        Player player = new Player();
        askName(player);
        askHpAndMp(player);
        return player;
    }

    private void askName(Player player) {
        while (true) {
            try {
                String name = gameView.askPlayerName();
                player.setName(name);
                return;
            } catch (IllegalArgumentException e) {
                gameView.printErrorMessage(e);
            }
        }
    }

    //왼쪽 숫자 오른쪽 숫자 , 가 있는지 확인
    private void askHpAndMp(Player player) {
        while (true) {
            try {
                String hpAndMp = gameView.askPlayerHPAndMP();
                String[] hpAndMpSplit = hpAndMp.split(",");
                int hp = Integer.parseInt(hpAndMpSplit[0]);
                int mp = Integer.parseInt(hpAndMpSplit[1]); // dto로 변환하던가 gameview에서 해야되나?
                player.setHpAndMp(hp, mp);
                return;
            } catch (IllegalArgumentException e) {
                gameView.printErrorMessage(e);
            }
        }
    }


    private Monster createBossMonster() {
        while (true) {
            try {
                int monsterHP = gameView.askBossMonsterHP();
                return new Monster(monsterHP);
            } catch (IllegalArgumentException e) {
                gameView.printErrorMessage(e);
            }
        }
    }


}
