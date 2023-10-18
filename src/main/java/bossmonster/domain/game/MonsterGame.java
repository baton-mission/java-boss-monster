package bossmonster.domain.game;

import bossmonster.domain.monster.Monster;
import bossmonster.domain.number.BossDamageGenerator;
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

    public Skill attackMonster(String skillNo) {
        Skill skill = Skill.getSkillBySkillNo(skillNo);
        if (player.isAlive()) {
            player.attack(monster, skill);
            increaseMatchCount();
        }
        if (monster.isDead()) {
            gameStatus = GameStatus.END;
        }
        return skill;
    }

    private void increaseMatchCount() {
        matchCount++;
    }

    public int attackPlayer() {
        int damage = BossDamageGenerator.getDamage();
        if (monster.isAlive()) {
            monster.attack(player, damage);
        }
        if (player.isDead()) {
            gameStatus = GameStatus.END;
        }
        return damage;
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
