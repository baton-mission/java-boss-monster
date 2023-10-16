package bossmonster.domain.battle;

import bossmonster.domain.creatures.Boss;
import bossmonster.domain.creatures.Creature;
import bossmonster.domain.creatures.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public final class BattleField {
    private static final int PLAYER_ATTACK_PRIORITY = 0;
    private static final int BOSS_ATTACK_PRIORITY = 1;
    public List<Creature> attackOrder;
    private final Boss boss;
    private final Player player;

    private final Long id;
    private int battleCount = 0;

    public BattleField(Long id, Player player, Boss boss) {
        this.id = id;
        this.player = player;
        this.boss = boss;

        attackOrder = setAttackOrders();
    }

    public void increaseBattleCount() {
        battleCount++;
    }

    public List<? extends Creature> getBattleResult() {
        return new ArrayList<>(List.of(player, boss));
    }

    public int getBattleCount() {
        return battleCount;
    }

    public Player getPlayer() {
        return player;
    }

    public Boss getBoss() {
        return boss;
    }

    public boolean isBattleEnd() {
        return (player.getHp() <= 0 || boss.getHp() <= 0);
    }

    public Long getId() {
        return id;
    }

    public List<Creature> getAttackOrder() {
        return attackOrder;
    }

    private List<Creature> setAttackOrders() {
        TreeMap<Integer, Creature> orderMap = new TreeMap<>();
        orderMap.put(BOSS_ATTACK_PRIORITY, boss);
        orderMap.put(PLAYER_ATTACK_PRIORITY, player);

        return new ArrayList<>(orderMap.values());
    }
}
