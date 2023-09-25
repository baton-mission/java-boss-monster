package bossmonster.service;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;

import java.util.List;

public class InitialSetting {

    public Player setPlayerStatus(String name, List<Integer> status) {
        Player player = new Player(name, status);
        return player;
    }

    public BossMonster setBossMonsterStatus(int hp) {
        BossMonster bossMonster = new BossMonster(hp);
        return bossMonster;
    }
}
