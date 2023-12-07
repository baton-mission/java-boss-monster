package bossmonster.domain;

import java.util.List;

public class PlayerVital {

    private final Hp totalHp;
    private final Hp currentHp;
    private final Mp totalMp;
    private final Mp currentMp;

    public PlayerVital(Hp hp, Mp mp) {
        this.totalHp = hp;
        this.currentHp = hp;
        this.totalMp = mp;
        this.currentMp = mp;
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

    public Hp getTotalHp() {
        return totalHp;
    }

    public Hp getCurrentHp() {
        return currentHp;
    }

    public Mp getTotalMp() {
        return totalMp;
    }

    public Mp getCurrentMp() {
        return currentMp;
    }
}
