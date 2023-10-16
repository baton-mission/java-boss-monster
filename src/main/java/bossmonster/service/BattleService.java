package bossmonster.service;

import bossmonster.domain.attack.AttackEntity;
import bossmonster.domain.attack.AttackType;
import bossmonster.domain.battle.BattleField;
import bossmonster.domain.creatures.Creature;
import bossmonster.dto.BattleDTO;

import java.util.List;


public class BattleService {
    public List<Creature> getAttackOrders(BattleField battleField) {
        return battleField.getAttackOrder();
    }

    public BattleDTO attackByPlayer(BattleField battleField, AttackType.Player type) {
        AttackEntity entity = new AttackEntity(battleField.getPlayer(), battleField.getBoss(), type);
        int damage = entity.attack();
        return new BattleDTO(damage, type.getAttackName());
    }

    public BattleDTO attackByBoss(BattleField battleField, AttackType.Boss type) {
        int damage = AttackType.Boss.setDamage();
        AttackEntity entity = new AttackEntity(battleField.getBoss(), battleField.getPlayer(), damage, 0);
        entity.attack();
        return new BattleDTO(entity.getDamage(), type.getAttackName());
    }
}
