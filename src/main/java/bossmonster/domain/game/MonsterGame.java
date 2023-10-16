package bossmonster.domain.game;

import bossmonster.domain.monster.Monster;
import bossmonster.domain.player.Player;
import bossmonster.domain.player.Skill;

public class MonsterGame {

    private int matchCount;
    private Monster monster;

    private Player player;

    public MonsterGame(Monster monster, Player player) {
        this.matchCount = 0;
        this.monster = monster;
        this.player = player;
    }

    public void proceedPlayerTurn(Skill skill) {
        if (player.isAlive()) {
            player.attack(skill, monster);
            increaseMatchCount();
        }
    }
    private void increaseMatchCount() {
        matchCount++;
    }

    public void proceedMonsterTurn(int damage) {
        if (monster.isAlive()) {
            monster.takeDamage(damage, player);
        }
    }


    public boolean isGameInProgress() {
        return player.isAlive() && monster.isAlive();
    }


    public GameResult getGameResult() {
        if(player.isAlive()) {
            return GameResult.WIN;
        }
        return GameResult.LOSE;
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

    public boolean isMonsterPlayable() {
        return monster.isAlive();
    }
}
