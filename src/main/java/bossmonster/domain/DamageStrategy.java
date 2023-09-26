package bossmonster.domain;

@FunctionalInterface
public interface DamageStrategy {

    int pickDamage(int min, int max);
}
