package bossmonster.service;

import bossmonster.domain.battle.BattleField;
import bossmonster.domain.creatures.Boss;
import bossmonster.domain.creatures.Player;
import bossmonster.repository.MemoryRepository;

import java.util.List;

public class RepositoryService {
    private final MemoryRepository repository;

    public RepositoryService(MemoryRepository repository) {
        this.repository = repository;
    }

    public Long saveBattle(Player player, Boss boss) {
        BattleField battleField = new BattleField(repository.getSequence(), player, boss);
        return repository.saveBattle(battleField);
    }

    public Long getLatestBattleId() {
        List<BattleField> battles = repository.findAll();
        return battles.get(battles.size() - 1).getId();
    }

    public BattleField getBattleById(Long id) {
        return repository.findBattleById(id);
    }
}
