package bossmonster.domain;

public class RandomDamageStrategy implements DamageStrategy {

    @Override
    public int getDamage(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
