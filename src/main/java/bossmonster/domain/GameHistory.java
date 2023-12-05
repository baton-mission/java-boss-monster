package bossmonster.domain;

import java.util.ArrayList;
import java.util.List;

public class GameHistory {

    private class Turns {

        private int turnCount;
        private String playerName;
        private AttackType playerAttackType;
        private int playerAttackDamage;
        private int monsterAttackDamage;
        private int playerMaxHP;
        private int playerCurrentHP;
        private int playerMaxMP;
        private int playerCurrentMP;
        private int monsterMaxHP;
        private int monsterCurrentHP;
        private boolean gameStatus;

        public Turns(int turnCount, AttackType playerAttackType, int playerAttackDamage,
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

    private static final int DEFAULT_DAMAGE = 0;
    private List<Turns> turnHistory = new ArrayList<>();

    public void addHistory(int turnCount, boolean gameStatus, Player player, BossMonster bossMonster) {
        turnHistory.add(
                new Turns(turnCount, AttackType.ATTACK_TYPE_NONE, DEFAULT_DAMAGE, DEFAULT_DAMAGE, gameStatus, player,
                        bossMonster));
    }

    public void addHistory(int turnCount, AttackType playerAttackType, int playerAttackDamage,
                           int monsterAttackDamage, boolean gameStatus, Player player, BossMonster bossMonster) {
        turnHistory.add(
                new Turns(turnCount, playerAttackType, playerAttackDamage, monsterAttackDamage, gameStatus, player,
                        bossMonster));
    }
}
