package bossmonster.domain.player;

import bossmonster.dto.PlayerInfo;

public class PlayerImpl
        implements Player {
    private final PlayerName playerName;
    private final PlayerHp playerHp;
    private final PlayerMp playerMp;

    public PlayerImpl(
            PlayerName playerName,
            PlayerHp playerHp,
            PlayerMp playerMp
    ) {
        this.playerName = playerName;
        this.playerHp = playerHp;
        this.playerMp = playerMp;
    }

    @Override
    public void takeDamage(int damage) {
        playerHp.decreaseCurrentHp(damage);
    }

    @Override
    public boolean isAlive() {
        if (playerHp.isCurrentHpZeroOrBelow()) {
            return false;
        }

        return true;
    }

    @Override
    public PlayerInfo getPlayerInfo() {
        return PlayerInfo.of(
                playerName.getPlayerName(),
                playerHp.getMaximumHp(),
                playerHp.getCurrentHp(),
                playerMp.getMaximumMp(),
                playerMp.getCurrentMp()
        );
    }
}
