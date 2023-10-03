package bossmonster.domain.player.dto;

public class PlayerAttackResult {
    private final boolean isSuccess;
    private final String playerAttackName;
    private final int attackDamage;

    private PlayerAttackResult(
            final boolean isSuccess,
            final String playerAttackName,
            final int attackDamage
    ) {
        this.isSuccess = isSuccess;
        this.playerAttackName = playerAttackName;
        this.attackDamage = attackDamage;
    }

    public static PlayerAttackResult of(
            final boolean isSuccess,
            final String playerAttackName,
            final int attackDamage
    ) {
        return new PlayerAttackResult(
                isSuccess,
                playerAttackName,
                attackDamage
        );
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getPlayerAttackName() {
        return playerAttackName;
    }

    public int getAttackDamage() {
        return attackDamage;
    }
}
