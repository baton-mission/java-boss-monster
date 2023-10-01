package bossmonster.domain.player;

import bossmonster.domain.bossmonster.BossMonster;
import bossmonster.domain.player.constant.PlayerAttackOption;
import bossmonster.domain.player.dto.PlayerInfo;

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

    @Override
    public void attackBossMonster(
            BossMonster bossMonster,
            PlayerAttackOption attackOption
    ) {
        checkEnoughMp(attackOption.getNeedMp());

        playerMp.decreaseCurrentMp(attackOption.getNeedMp());
        bossMonster.takeDamage(attackOption.getDamage());
        playerMp.increaseCurrentMp(attackOption.getRecoveryMp());
    }

    private void checkEnoughMp(int needMp) {
        if (!playerMp.hasEnoughMpForAttack(needMp)) {
            throw new IllegalStateException("공격을 수행하기 위한 플레이어의 MP가 부족합니다.");
        }
    }
}
