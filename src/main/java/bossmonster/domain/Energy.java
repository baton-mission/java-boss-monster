package bossmonster.domain;

public class Energy {
    private static final int MIN_ENERGY = 0;
    private final int maxEnergy;
    private int currentEnergy;

    public Energy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
        this.currentEnergy = maxEnergy;
    }

    public void change(int amount) {
        currentEnergy += amount;
        if (currentEnergy > maxEnergy) {
            currentEnergy = maxEnergy;
        }
        if (currentEnergy < MIN_ENERGY) {
            currentEnergy = MIN_ENERGY;
        }
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }
}
