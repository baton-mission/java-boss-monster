package bossmonster.domain.dto;

public class GameHistoryDto {

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

    public GameHistoryDto(int turnCount, String playerName, String playerAttackType, int playerAttackDamage,
                          int monsterAttackDamage, int playerMaxHP, int playerCurrentHP, int playerMaxMP,
                          int playerCurrentMP, int monsterMaxHP, int monsterCurrentHP, boolean gameStatus) {
        this.turnCount = turnCount;
        this.playerName = playerName;
        this.playerAttackType = playerAttackType;
        this.playerAttackDamage = playerAttackDamage;
        this.monsterAttackDamage = monsterAttackDamage;
        this.playerMaxHP = playerMaxHP;
        this.playerCurrentHP = playerCurrentHP;
        this.playerMaxMP = playerMaxMP;
        this.playerCurrentMP = playerCurrentMP;
        this.monsterMaxHP = monsterMaxHP;
        this.monsterCurrentHP = monsterCurrentHP;
        this.gameStatus = gameStatus;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerAttackType() {
        return playerAttackType;
    }

    public int getPlayerAttackDamage() {
        return playerAttackDamage;
    }

    public int getMonsterAttackDamage() {
        return monsterAttackDamage;
    }

    public int getPlayerMaxHP() {
        return playerMaxHP;
    }

    public int getPlayerCurrentHP() {
        return playerCurrentHP;
    }

    public int getPlayerMaxMP() {
        return playerMaxMP;
    }

    public int getPlayerCurrentMP() {
        return playerCurrentMP;
    }

    public int getMonsterMaxHP() {
        return monsterMaxHP;
    }

    public int getMonsterCurrentHP() {
        return monsterCurrentHP;
    }

    public boolean isGameStatus() {
        return gameStatus;
    }
}
