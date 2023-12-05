package bossmonster.domain;

import java.util.Arrays;
import java.util.List;

public class RaidGame {

    private BossMonster bossMonster;
    private Player player;
    private GameHistory gameHistory;
    private boolean status;
    private int turns;

    public RaidGame() {
        this.gameHistory = new GameHistory();
        this.status = true;
        this.turns = 0;
    }

    public void createBossMonster(int hp) {
        bossMonster = new BossMonster(hp);
    }

    public void createPlayer(String name, int maxHP, int maxMP) {
        List<AttackType> attackType = Arrays.asList(AttackType.ATTACK_TYPE_NORMAL, AttackType.ATTACK_TYPE_MAGIC);
        player = new Player(name, maxHP, maxMP, attackType);
    }

    public void executeTurn(AttackType attackType) {
        if (isGameProgress()) {
            increaseTurn();
            int playerAttackDamage = executePlayerTurn(attackType);
            int monsterAttackDamage = executeBossMonsterTurn();
            createTurnHistory(attackType, playerAttackDamage, monsterAttackDamage);
        }
    }

    private boolean isGameProgress() {
        return status;
    }

    private void setStatus(boolean status) {
        this.status = status;
    }

    private void increaseTurn() {
        turns ++;
    }

    private int executePlayerTurn(AttackType attackType) {
        int playerAttackDamage = player.attack(attackType);
        bossMonster.takeDamage(playerAttackDamage);
        setStatus(bossMonster.isAlive());
        return playerAttackDamage;
    }

    private int executeBossMonsterTurn() {
        int monsterAttackDamage = bossMonster.attack();
        player.takeDamage(monsterAttackDamage);
        setStatus(player.isAlive());
        return monsterAttackDamage;
    }

    private void createTurnHistory(AttackType playerAttackType, int playerAttackDamage, int monsterAttackDamage) {
        gameHistory.addHistory(turns, playerAttackType, playerAttackDamage, monsterAttackDamage, status, player,
                bossMonster);
    }
}
