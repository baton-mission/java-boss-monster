package bossmonster.dto.response;

import bossmonster.domain.AttackType;
import bossmonster.domain.BossGame;

public class BossAttackDto {

    private final String attackTypeName;

    private final int attackDamage;


    private final String attackerPlayerName;

    private final int totalTryCount;

    public BossAttackDto(AttackType attackType, BossGame bossGame) {
        this.attackTypeName = attackType.getAttackTypeName();
        this.attackDamage = attackType.getAttackDamage();
        this.attackerPlayerName = bossGame.getPlayerName();
        this.totalTryCount = bossGame.getTurnCount();
    }

    public String getAttackTypeName() {
        return attackTypeName;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public String getAttackerPlayerName() {
        return attackerPlayerName;
    }

    public int getTotalTryCount() {
        return totalTryCount;
    }
}
