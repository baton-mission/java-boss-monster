package bossmonster.domain.number;

public class BossDamageGenerator {

    public static final int MAX_DAMAGE = 21;

    public static int getDamage() {
        double randomValue = Math.random(); // 0.0 이상 1.0 미만의 난수 생성
        return (int) (randomValue * MAX_DAMAGE); // 0부터 20까지의 난수로 변환
    }
}
