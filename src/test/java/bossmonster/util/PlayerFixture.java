package bossmonster.util;

import bossmonster.domain.player.*;

import static bossmonster.domain.player.constant.PlayerOption.PLAYER_HP_AND_MP_SUM;

public class PlayerFixture {
    private static final String DEFAULT_PLAYER_NAME = "edgar";
    private static final int DEFAULT_PLAYER_HP = 100;
    private static final int DEFAULT_PLAYER_MP = 100;

    public static Player createPlayer() {
        return new PlayerImpl(
                createPlayerName(),
                createPlayerHp(),
                createPlayerMp()
        );
    }

    public static Player createPlayer(int hp) {
        PlayerName playerName = createPlayerName();
        PlayerHp playerHp = createPlayerHp(hp);
        PlayerMp playerMp = createPlayerMp(PLAYER_HP_AND_MP_SUM - hp);

        return new PlayerImpl(
                playerName,
                playerHp,
                playerMp
        );
    }

    public static Player createPlayer(PlayerMp playerMp) {
        return new PlayerImpl(
                createPlayerName(),
                createPlayerHp(PLAYER_HP_AND_MP_SUM - playerMp.getMaximumMp()),
                playerMp
        );
    }

    public static Player createPlayer(
            String name,
            int hp,
            int mp
    ) {
        PlayerName playerName = createPlayerName(name);
        PlayerHp playerHp = createPlayerHp(hp);
        PlayerMp playerMp = createPlayerMp(mp);

        return new PlayerImpl(
                playerName,
                playerHp,
                playerMp
        );
    }

    public static PlayerName createPlayerName() {
        return new PlayerName(DEFAULT_PLAYER_NAME);
    }

    public static PlayerName createPlayerName(String name) {
        return new PlayerName(name);
    }

    public static PlayerHp createPlayerHp() {
        return new PlayerHp(DEFAULT_PLAYER_HP);
    }

    public static PlayerHp createPlayerHp(int hp) {
        return new PlayerHp(hp);
    }

    public static PlayerMp createPlayerMp() {
        return new PlayerMp(DEFAULT_PLAYER_MP);
    }

    public static PlayerMp createPlayerMp(int mp) {
        return new PlayerMp(mp);
    }
}
