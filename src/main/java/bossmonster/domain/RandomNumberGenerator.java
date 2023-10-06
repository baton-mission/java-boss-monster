package bossmonster.domain;

public class RandomNumberGenerator {
    public static int getRandomNumber() {
        double randomValue = Math.random(); // 0.0 이상 1.0 미만의 난수 생성
        return (int) (randomValue * 21); // 0부터 20까지의 난수로 변환
    }
}
