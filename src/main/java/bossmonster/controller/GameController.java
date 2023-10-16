package bossmonster.controller;

import bossmonster.domain.game.GameResult;
import bossmonster.domain.monster.Monster;
import bossmonster.domain.game.MonsterGame;
import bossmonster.domain.player.Player;
import bossmonster.domain.number.RandomNumberGenerator;
import bossmonster.domain.player.Skill;
import bossmonster.domain.player.PlayerName;
import bossmonster.domain.player.PlayerStats;
import bossmonster.view.GameView;

//값을 전달해줘야하는 객체는 값을 잘 전달해줘야하는 책임이 있음
// 자기가 다루지 못하는 값이 들어오면 예외를 발생시켜야함
//유틸클래스도 쓸수있는곳이 명확해야한다? 재사용성
//dto ??

public class GameController {

    GameView gameView;
    MonsterGame monsterGame;

    public GameController(GameView gameView) {
        this.gameView = gameView;
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
        do {
            proceedPlayerTurn();
            proceedBossMonsterTurn();
            printPlayerAndMonsterInformation();
        } while (monsterGame.isGameInProgress());
    }

    //TODO 몬스터가 죽었으면 출력안하고 안죽었으면 출력하고 이걸 다르게 생각해봐야하나?
    private void printPlayerAndMonsterInformation() {
        if (monsterGame.isGameInProgress()) {
            gameView.printPlayerAndMonsterInformation(monsterGame.getPlayer(),
                    monsterGame.getMonster());
        }
    }

    //TODO 뭔가 좀더 다르게 깔끔하게 가능할거같음
    private void printResult() {
        Player player = monsterGame.getPlayer();
        GameResult gameResult = monsterGame.getGameResult();
        if (gameResult == GameResult.WIN) {
            int matchCount = monsterGame.getMatchCount();
            gameView.printWin(player, matchCount);
            return;
        }
        gameView.printLose(player);
    }

    private void proceedPlayerTurn() {
        while (true) {
            try {
                Skill skill = askSkill(); // 고민인부분인거
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

    //todo 랜덤 데미지를 구해서 하는거는 게임을 진행하면서 할일일까?
    private void proceedBossMonsterTurn() {
        if (monsterGame.isMonsterPlayable()) {
            int damage = RandomNumberGenerator.getRandomNumber(); // 몬스터게임 안에 들어가면 테스트 하기힘들어짐
            monsterGame.proceedMonsterTurn(damage);
            gameView.printMonsterAttack(damage);
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
                return new PlayerName(gameView.askPlayerName());
            } catch (IllegalArgumentException e) {
                gameView.printErrorMessage(e);
            }
        }
    }

    //todo inputview에서 검증해서 dto로 받아오기
    private PlayerStats createPlayerStats() {
        while (true) {
            try {
                String hpAndMp = gameView.askPlayerHPAndMP();
                String[] hpAndMpSplit = hpAndMp.split(",");
                int hp = Integer.parseInt(hpAndMpSplit[0]);
                int mp = Integer.parseInt(hpAndMpSplit[1]); // dto로 변환하던가 gameview에서 해야되나?
                return PlayerStats.createPlayerStats(hp, mp);
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
