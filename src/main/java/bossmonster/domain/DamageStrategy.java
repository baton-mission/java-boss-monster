package bossmonster.domain;

@FunctionalInterface
public interface DamageStrategy {

    int getDamage(int min, int max);
}
