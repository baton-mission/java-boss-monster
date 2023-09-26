package bossmonster;

import bossmonster.controller.BossGameController;
import bossmonster.domain.DamageStrategy;
import bossmonster.domain.RandomDamageStrategy;

public class Main {
    public static void main(String[] args) {
        DamageStrategy damageStrategy = new RandomDamageStrategy();
        BossGameController bossGameController = new BossGameController(damageStrategy);
        bossGameController.run();
    }
}
