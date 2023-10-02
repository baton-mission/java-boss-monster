package bossmonster.service;

import java.util.List;

import bossmonster.domain.characterattributes.Hp;
import bossmonster.domain.characterattributes.Mp;
import bossmonster.domain.characterattributes.Name;
import bossmonster.domain.characterattributes.Stat;
import bossmonster.domain.monster.BossMonster;
import bossmonster.domain.player.Attack;
import bossmonster.domain.player.Player;

public class Service {

    public BossMonster generateBossMonster(int bossMonsterHp) {
        return new BossMonster(new Hp(bossMonsterHp));
    }

    public Player generatePlayer(String playerName, List<Integer> playerInitialHpAndMp) {
        Hp playerHp = new Hp(playerInitialHpAndMp.get(0));
        Mp playerMp = new Mp(playerInitialHpAndMp.get(1));
        return new Player(new Name(playerName), new Stat(playerHp, playerMp));
    }

    public void playerAttack(Attack playerAttack, Player player, BossMonster bossMonster) {
        player.attack(playerAttack, bossMonster);
    }

    public void bossMonsterAttack(int bossMonsterAttackDamage, BossMonster bossMonster, Player player) {
        bossMonster.attack(bossMonsterAttackDamage, player);
    }
}
