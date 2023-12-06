package bossmonster.domain;

import bossmonster.domain.dto.GameHistoryDto;
import java.util.ArrayList;
import java.util.List;

public class GameHistory {

    private class Turns {

        private int turnCount;
        private String playerName;
        private String playerAttackType;
        private int playerAttackDamage;
        private int monsterAttackDamage;
        private int playerMaxHP;
        private int playerCurrentHP;
        private int playerMaxMP;
        private int playerCurrentMP;
        private int monsterMaxHP;
        private int monsterCurrentHP;
        private boolean gameStatus;

        public Turns(int turnCount, String playerAttackType, int playerAttackDamage,
                     int monsterAttackDamage, boolean gameStatus, Player player, BossMonster bossMonster) {
            this.turnCount = turnCount;
            this.playerName = player.getName();
            this.playerAttackType = playerAttackType;
            this.playerAttackDamage = playerAttackDamage;
            this.monsterAttackDamage = monsterAttackDamage;
            this.playerMaxHP = player.getMaxHP();
            this.playerCurrentHP = player.getCurrentHP();
            this.playerMaxMP = player.getMaxMP();
            this.playerCurrentMP = player.getCurrentMP();
            this.monsterMaxHP = bossMonster.getMaxHP();
            this.monsterCurrentHP = bossMonster.getCurrentHP();
            this.gameStatus = gameStatus;
        }
    }

    private static final String DEFAULT_ATTACK_TYPE = "";
    private static final int DEFAULT_DAMAGE = 0;
    private int recentRecord;
    private List<Turns> raidHistory = new ArrayList<>();

    public void addHistory(int turnCount, boolean gameStatus, Player player, BossMonster bossMonster) {
        raidHistory.add(
                new Turns(turnCount, DEFAULT_ATTACK_TYPE, DEFAULT_DAMAGE, DEFAULT_DAMAGE, gameStatus, player,
                        bossMonster));
    }

    public void addHistory(int turnCount, String playerAttackType, int playerAttackDamage,
                           int monsterAttackDamage, boolean gameStatus, Player player, BossMonster bossMonster) {
        raidHistory.add(
                new Turns(turnCount, playerAttackType, playerAttackDamage, monsterAttackDamage, gameStatus, player,
                        bossMonster));
    }

    public GameHistoryDto requestRaidHistory() {
        setRecentRecord();
        Turns turns = raidHistory.get(recentRecord);
        return new GameHistoryDto(turns.turnCount, turns.playerName, turns.playerAttackType, turns.playerAttackDamage,
                turns.monsterAttackDamage, turns.playerMaxHP, turns.playerCurrentHP, turns.playerMaxMP,
                turns.playerCurrentMP, turns.monsterMaxHP, turns.monsterCurrentHP, turns.gameStatus);
    }

    private void setRecentRecord() {
        recentRecord = raidHistory.size() - 1;
    }
}
