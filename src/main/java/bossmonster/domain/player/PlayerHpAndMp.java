package bossmonster.domain.player;

import static bossmonster.domain.player.constant.PlayerOption.*;

public class PlayerHpAndMp {
    private final PlayerHp hp;
    private final PlayerMp mp;

    public PlayerHpAndMp(
            int hp,
            int mp
    ) {
        validateHpAndMpSum(hp + mp);
        this.hp = convertToPlayerHp(hp);
        this.mp = convertToPlayerMp(mp);
    }

    public PlayerHp getHp() {
        return hp;
    }

    public PlayerMp getMp() {
        return mp;
    }

    private void validateHpAndMpSum(int hpAndMpSum) {
        if (hpAndMpSum != PLAYER_HP_AND_MP_SUM) {
            throw new IllegalArgumentException("플레이어의 HP와 MP의 합이 유효하지 않습니다.");
        }
    }

    private PlayerHp convertToPlayerHp(int hp) {
        return new PlayerHp(hp);
    }

    private PlayerMp convertToPlayerMp(int mp) {
        return new PlayerMp(mp);
    }
}
