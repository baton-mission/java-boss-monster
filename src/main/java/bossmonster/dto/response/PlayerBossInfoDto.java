package bossmonster.dto.response;

import bossmonster.domain.AttackType;
import bossmonster.domain.BossGame;

public class PlayerBossInfoDto {

    private final String attackTypeName;
    private final int attackDamage;
    private final int bossAttackDamage;
    private final int bossCurrentHp;
    private final int bossInitialHp;
    private final String playerName;
    private final int playerCurrentHp;
    private final int playerInitialHp;
    private final int playerCurrentMp;
    private final int playerInitialMp;

    public PlayerBossInfoDto(AttackType attackType, int bossAttackDamage, BossGame bossGame) {
        this.attackTypeName = attackType.getAttackTypeName();
        this.attackDamage = attackType.getAttackDamage();
        this.bossAttackDamage = bossAttackDamage;
        this.bossCurrentHp = bossGame.getBossCurrentHp();
        this.bossInitialHp = bossGame.getBossInitialHp();
        this.playerName = bossGame.getPlayerName();
        this.playerCurrentHp = bossGame.getPlayerCurrentHp();
        this.playerInitialHp = bossGame.getPlayerInitialHp();
        this.playerCurrentMp = bossGame.getPlayerCurrentMp();
        this.playerInitialMp = bossGame.getPlayerInitialMp();
    }

    public String getAttackTypeName() {
        return attackTypeName;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getBossAttackDamage() {
        return bossAttackDamage;
    }

    public int getBossCurrentHp() {
        return bossCurrentHp;
    }

    public int getBossInitialHp() {
        return bossInitialHp;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerCurrentHp() {
        return playerCurrentHp;
    }

    public int getPlayerInitialHp() {
        return playerInitialHp;
    }

    public int getPlayerCurrentMp() {
        return playerCurrentMp;
    }

    public int getPlayerInitialMp() {
        return playerInitialMp;
    }
}
