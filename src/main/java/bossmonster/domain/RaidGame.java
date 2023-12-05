package bossmonster.domain;

import bossmonster.domain.dto.BossMonsterDto;
import bossmonster.domain.dto.PlayerDto;
import java.util.List;

public class RaidGame {

    private BossMonster bossMonster;
    private Player player;
    private int turns = 0;

    public void createBossMonster(int hp) {
        bossMonster = new BossMonster(hp);
    }

    public void createPlayer(String name, int hp, int mp) {
        player = new Player(name, hp, mp);
    }

    public BossMonsterDto requestBossMonsterStatus() {
        return new BossMonsterDto(bossMonster.getTotalHP(), bossMonster.getCurrentHP());
    }

    public PlayerDto requestPlayerStatus() {
        return new PlayerDto(player.getName(), player.getTotalHP(), player.getCurrentHP(),
                player.getTotalMP(), player.getCurrentMP());
    }

    public List<String> requestAttackType() {
        return player.getAttackType();
    }

    public 
}
