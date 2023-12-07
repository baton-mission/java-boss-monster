package bossmonster.domain;

import java.util.List;

public class PlayerVital {

    private final Hp hp;
    private final Mp mp;

    public PlayerVital(Hp hp, Mp mp) {
        this.hp = hp;
        this.mp = mp;
    }

    public static PlayerVital of(List<Integer> playerVital) {
        validateTotalVitalValue(playerVital);
        return new PlayerVital(new Hp(playerVital.get(0)), new Mp(playerVital.get(1)));
    }

    private static void validateTotalVitalValue(List<Integer> playerVital) {
        if (!isValidValue(playerVital)) {
            throw new IllegalArgumentException("플레이어의 HP와 MP의 합은 200이어야 합니다.");
        }
    }

    private static boolean isValidValue(List<Integer> playerVital) {
        return playerVital.get(0) + playerVital.get(1) == 200;
    }
}
