package bossmonster.domain;

import java.util.List;

public class PlayerVital {

    private final Hp totalHp;
    private final Hp currentHp;
    private final Mp totalMp;
    private final Mp currentMp;

    public PlayerVital(Hp totalHp, Hp currentHp, Mp totalMp, Mp currentMp) {
        this.totalHp = totalHp;
        this.currentHp = currentHp;
        this.totalMp = totalMp;
        this.currentMp = currentMp;
    }

    public static PlayerVital of(List<Integer> playerVital) {
        validateTotalVitalValue(playerVital);
        int hp = playerVital.get(0);
        int mp = playerVital.get(1);
        return new PlayerVital(new Hp(hp), new Hp(hp), new Mp(mp), new Mp(mp));
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

    public void damagedBy(Hp monsterAttack) {
        currentHp.decreaseBy(monsterAttack);
    }

    public void affectMpBy(PlayerAttack playerAttack) {
        currentMp.affectMpBy(playerAttack);
    }

    public boolean isOver() {
        return currentHp.isEmpty();
    }
}
