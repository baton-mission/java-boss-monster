package bossmonster.domain.player;

import static bossmonster.domain.player.constant.PlayerOption.*;

public class PlayerHpAndMp {
    private final int hp;
    private final int mp;

    public PlayerHpAndMp(
            int hp,
            int mp
    ) {
        validateHp(hp);
        validateMp(mp);
        validateHpAndMpSum(hp + mp);
        this.hp = hp;
        this.mp = mp;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    private void validateHp(int hp) {
        if (PLAYER_MINIMUM_HP_LIMIT > hp || PLAYER_MAXIMUM_HP_LIMIT < hp) {
            throw new IllegalArgumentException("유효하지 않은 플레이어 HP입니다.");
        }
    }

    private void validateMp(int mp) {
        if (PLAYER_MINIMUM_MP_LIMIT > mp || PLAYER_MAXIMUM_MP_LIMIT < mp) {
            throw new IllegalArgumentException("유효하지 않은 플레이어 MP입니다.");
        }
    }

    private void validateHpAndMpSum(int hpAndMpSum) {
        if (hpAndMpSum != PLAYER_HP_AND_MP_SUM) {
            throw new IllegalArgumentException("플레이어의 HP와 MP의 합이 유효하지 않습니다.");
        }
    }
}
