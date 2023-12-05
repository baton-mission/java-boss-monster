package bossmonster.domain;

import bossmonster.domain.dto.GameHistoryDto;

public class RaidGame {

    private static final int DEFAULT_TURN = 0;

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
        this.turns = DEFAULT_TURN;

        gameHistory.addHistory(turns, status, player, bossMonster);
    }

    public void executeTurn(AttackType attackType) {
        if (isGameProgress()) {
            increaseTurn();
            int playerAttackDamage = executePlayerTurn(attackType);
            int monsterAttackDamage = executeBossMonsterTurn();
            createTurnHistory(attackType, playerAttackDamage, monsterAttackDamage);
        }
    }

    public GameHistoryDto getGameHistory() {
        return gameHistory.requestRaidHistory();
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
        gameHistory.addHistory(turns, playerAttackType.getName(), playerAttackDamage, monsterAttackDamage, status,
                player,
                bossMonster);
    }
}
