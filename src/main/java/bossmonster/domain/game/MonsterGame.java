package bossmonster.domain.game;

import bossmonster.domain.monster.Monster;
import bossmonster.domain.player.Player;
import bossmonster.domain.player.Skill;

public class MonsterGame {


    private GameStatus gameStatus;
    private int matchCount;
    private Monster monster;

    private Player player;

    public MonsterGame(Monster monster, Player player) {
        this.matchCount = 0;
        this.gameStatus = GameStatus.INIT;
        this.monster = monster;
        this.player = player;
    }

    public void proceedPlayerTurn(Skill skill) {
        if (player.isAlive()) {
            player.attack(skill, monster);
            increaseMatchCount();
        }
        if(monster.isDead()) {
            gameStatus = GameStatus.END;
        }
    }

    private void increaseMatchCount() {
        matchCount++;
    }

    public void proceedMonsterTurn(int damage) {
        if (monster.isAlive()) {
            monster.takeDamage(damage, player);
        }
        if(player.isDead()) {
            gameStatus = GameStatus.END;
        }
    }

    public boolean isRun() {
        return player.isAlive() && monster.isAlive();
    }

    public boolean isPlayerWin() {
        return player.isAlive();
    }

    public boolean isMonsterAlive() {
        return monster.isAlive();
    }

    public boolean isPlayerAlive() {
        return player.isAlive();
    }
    public void start() {
        gameStatus = GameStatus.PLAY;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Monster getMonster() {
        return monster;
    }

    public Player getPlayer() {
        return player;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }


}
