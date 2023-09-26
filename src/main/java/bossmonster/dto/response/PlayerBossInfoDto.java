package bossmonster.dto.response;

import bossmonster.domain.AttackType;
import bossmonster.domain.BossGame;

public class PlayerBossInfoDto {

    // 공격 타입
    private final String attackTypeName;
    // 공격 데미지
    private final int attackDamage;
    // 보스 공격 데미지
    private final int bossAttackDamage;
    // 보스 현재 체력
    private final int bossCurrentHp;
    // 보스 초기 체력
    private final int bossInitialHp;
    // 플레이어 이름
    private final String playerName;
    // 플레이어 현재 hp
    private final int playerCurrentHp;
    // 플레이어 초기 hp
    private final int playerInitialHp;
    // 플레이어 현재 mp
    private final int playerCurrentMp;
    // 플레이어 초기 mp
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
