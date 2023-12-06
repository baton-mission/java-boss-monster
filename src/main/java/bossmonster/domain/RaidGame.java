package bossmonster.domain;

import bossmonster.domain.dto.GameHistoryDto;

public class RaidGame {

    private static final int DEFAULT_VALUE = 0;

    private BossMonster bossMonster;
    private Player player;
    private GameHistory gameHistory;
    private boolean status;
    private int turns;

    public RaidGame(BossMonster bossMonster, Player player) {
        this.bossMonster = bossMonster;
        this.player = player;
        this.gameHistory = new GameHistory();
        this.status = true;
        this.turns = DEFAULT_VALUE;

        gameHistory.addHistory(turns, status, player, bossMonster);
    }

    public void executeTurn(AttackType attackType) {
        if (isGameProgress()) {
            increaseTurn();
            int playerAttackDamage = DEFAULT_VALUE;
            int monsterAttackDamage = DEFAULT_VALUE;
                playerAttackDamage = executePlayerTurn(attackType);
            if (bossMonster.isAlive()) {
                monsterAttackDamage = executeBossMonsterTurn();
            }
            setStatus();
            createTurnHistory(attackType, playerAttackDamage, monsterAttackDamage);
        }
    }

    public GameHistoryDto getGameHistory() {
        return gameHistory.requestRaidHistory();
    }

    private boolean isGameProgress() {
        setStatus();
        return status;
    }

    private void setStatus() {
        status = player.isAlive() && bossMonster.isAlive();
    }

    private void increaseTurn() {
        turns ++;
    }

    private int executePlayerTurn(AttackType attackType) {
        int playerAttackDamage = player.attack(attackType);
        bossMonster.takeDamage(playerAttackDamage);
        return playerAttackDamage;
    }

    private int executeBossMonsterTurn() {
        int monsterAttackDamage = bossMonster.attack();
        player.takeDamage(monsterAttackDamage);
        return monsterAttackDamage;
    }

    private void createTurnHistory(AttackType playerAttackType, int playerAttackDamage, int monsterAttackDamage) {
        gameHistory.addHistory(turns, playerAttackType.getName(), playerAttackDamage, monsterAttackDamage, status,
                player,
                bossMonster);
    }
}
