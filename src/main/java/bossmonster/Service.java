package bossmonster;

import java.util.List;

import bossmonster.monster.BossMonster;
import bossmonster.player.Player;

public class Service {

    public BossMonster generateBossMonster(int bossMonsterHp) {
        return new BossMonster(new Hp(bossMonsterHp));
    }

    public Player generatePlayer(String playerName, List<Integer> playerInitialHpAndMp) {
        Hp playerHp = new Hp(playerInitialHpAndMp.get(0));
        Mp playerMp = new Mp(playerInitialHpAndMp.get(1));
        return new Player(new Name(playerName), new Stat(playerHp, playerMp));
    }
}
