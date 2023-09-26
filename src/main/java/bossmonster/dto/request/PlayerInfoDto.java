package bossmonster.dto.request;

import java.util.List;

public class PlayerInfoDto {

    private static final int PLAYER_HP_INDEX = 0;
    private static final int PLAYER_MP_INDEX = 1;

    private final int playerHp;
    private final int playerMp;

    private PlayerInfoDto(int playerHp, int playerMp) {
        this.playerHp = playerHp;
        this.playerMp = playerMp;
    }

    public PlayerInfoDto(List<Integer> playerHpAndMp) {
        this(playerHpAndMp.get(PLAYER_HP_INDEX), playerHpAndMp.get(PLAYER_MP_INDEX));
    }


    public int getPlayerHp() {
        return playerHp;
    }

    public int getPlayerMp() {
        return playerMp;
    }
}
