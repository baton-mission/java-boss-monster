package bossmonster.repository;

import bossmonster.domain.battle.BattleField;
import bossmonster.domain.creatures.Boss;
import bossmonster.domain.creatures.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bossmonster.controller.Parameter.BATTLE;

public class MemoryRepository {
    private static final Map<String, List<Object>> store = new HashMap<>();

    private Long sequence = 0L;

    private static MemoryRepository instance;

    private MemoryRepository() {
        store.put(BATTLE.getName(), new ArrayList<>());
    }

    public static MemoryRepository getInstance() {
        if (instance == null) {
            instance = new MemoryRepository();
        }
        return instance;
    }

    public Long getSequence() {
        return sequence;
    }

    public Long saveBattle(BattleField battleField) {
        store.get(BATTLE.getName()).add(battleField);
        sequence++;
        return battleField.getId();
    }

    public BattleField findBattleById(Long id) {
        List<Object> battleField = store.get(BATTLE.getName());

        return (BattleField) battleField.stream()
                .filter(object -> isMatch(object, id))
                .findAny()
                .orElse(null);
    }

    public List<BattleField> findAll() {
        List<Object> battleField = store.get(BATTLE.getName());
        return battleField.stream().map(e -> (BattleField) e).toList();
    }

    public Player getPlayer(Long battleId) {
        BattleField battle = findBattleById(battleId);
        return battle.getPlayer();
    }

    public Boss getBoss(Long battleId) {
        BattleField battle = findBattleById(battleId);
        return battle.getBoss();
    }

    private boolean isMatch(Object object, long targetId) {
        BattleField battle = (BattleField) object;
        return (battle != null && battle.getId() == targetId);
    }
}
