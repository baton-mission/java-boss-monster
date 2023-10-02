package bossmonster;

import java.util.List;

import bossmonster.domain.info.Hp;
import bossmonster.domain.info.Mp;
import bossmonster.domain.info.Name;
import bossmonster.domain.info.Stat;
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

    public Attack playerAttack(int attackNumber, Player player, BossMonster bossMonster) {
        Attack playerAttack = Attack.of(attackNumber);
        player.attack(playerAttack, bossMonster);
        return playerAttack;
    }

    public void bossMonsterAttack(int bossMonsterAttackDamage, BossMonster bossMonster, Player player) {
        bossMonster.attack(bossMonsterAttackDamage, player);
    }
}
