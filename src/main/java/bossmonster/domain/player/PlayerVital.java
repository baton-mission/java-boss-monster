package bossmonster.domain.player;

import bossmonster.domain.Hp;
import bossmonster.domain.Mp;
import bossmonster.domain.PlayerAttack;
import java.util.List;

public class PlayerVital {

    public static final int MAX_PLAYER_VITAL_SUM = 200;
    private final Mp totalMp;
    private final Hp totalHp;
    private final Hp currentHp;
    private final Mp currentMp;

    private PlayerVital(Hp totalHp, Hp currentHp, Mp totalMp, Mp currentMp) {
        this.totalHp = totalHp;
        this.currentHp = currentHp;
        this.totalMp = totalMp;
        this.currentMp = currentMp;
    }

    public static PlayerVital of(List<Integer> playerVital) {
        int hpIndex = 0;
        int mpIndex = 1;
        int hp = playerVital.get(hpIndex);
        int mp = playerVital.get(mpIndex);
        validateTotalVitalValue(hp, mp);
        return new PlayerVital(new Hp(hp), new Hp(hp), new Mp(mp), new Mp(mp));
    }

    private static void validateTotalVitalValue(int hp, int mp) {
        if (!isValidValue(hp, mp)) {
            throw new IllegalArgumentException(String.format("플레이어의 HP와 MP의 합은 %d이어야 합니다.", MAX_PLAYER_VITAL_SUM));
        }
    }

    private static boolean isValidValue(int hp, int mp) {
        return hp + mp == MAX_PLAYER_VITAL_SUM;
    }

    public void damagedBy(Hp monsterAttack) {
        currentHp.decreaseBy(monsterAttack);
    }

    public void affectMpBy(PlayerAttack playerAttack) {
        currentMp.applyPlayerAttack(playerAttack);
    }

    public boolean isOver() {
        return currentHp.isEmpty();
    }

    public void validateAttackMp(PlayerAttack playerAttack) {
        Mp newMp = currentMp;
        newMp.applyPlayerAttack(playerAttack);
        if (newMp.isUnderEmpty()) {
            throw new IllegalArgumentException("현재 보유 Mp를 넘어서는 공격을 할 수는 없습니다.");
        }
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
