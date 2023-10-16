package bossmonster.service;

import bossmonster.domain.battle.BattleField;
import bossmonster.domain.creatures.Boss;
import bossmonster.domain.creatures.Creature;
import bossmonster.domain.creatures.Player;

public class ResultService {
    public Creature checkWinner(BattleField battleField) {
        Boss boss = battleField.getBoss();
        Player player = battleField.getPlayer();
        if (player.getHp() > 0 && boss.getHp() <= 0) {
            return player;
        }
        return boss;
    }
}
