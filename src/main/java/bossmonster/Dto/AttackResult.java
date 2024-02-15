package bossmonster.Dto;

import bossmonster.Domain.Boss;
import bossmonster.Domain.Player;

public class AttackResult {
    private final Boss boss;
    private final Player player;
    public AttackResult(Boss boss, Player player) {
        this.boss = boss;
        this.player = player;
    }
    public Boss getBoss() {
        return boss;
    }
    public Player getPlayer() {
        return player;
    }
}
