package bossmonster.service;

import java.util.List;

import bossmonster.domain.characterattributes.Hp;
import bossmonster.domain.characterattributes.Mp;
import bossmonster.domain.characterattributes.Name;
import bossmonster.domain.characterattributes.Stat;
import bossmonster.domain.monster.BossMonster;
import bossmonster.domain.monster.BossMonsterAppearance;
import bossmonster.domain.player.Attack;
import bossmonster.domain.player.Player;

public class Service {

    public BossMonster generateBossMonster(int bossMonsterHp) {
        return new BossMonster(new Hp(bossMonsterHp));
    }

    public Player generatePlayer(String playerName, List<Integer> playerInitialHpAndMp) {
        Hp playerHp = new Hp(getInitialHp(playerInitialHpAndMp));
        Mp playerMp = new Mp(getInitialMp(playerInitialHpAndMp));
        return new Player(new Name(playerName), new Stat(playerHp, playerMp));
    }

    private Integer getInitialHp(List<Integer> playerInitialHpAndMp) {
        return playerInitialHpAndMp.get(0);
    }

    private Integer getInitialMp(List<Integer> playerInitialHpAndInitialMp) {
        return playerInitialHpAndInitialMp.get(1);
    }

    public void playerAttack(Attack playerAttack, Player player, BossMonster bossMonster) {
        player.attack(playerAttack, bossMonster);
    }

    public void bossMonsterAttack(int bossMonsterAttackDamage, BossMonster bossMonster, Player player) {
        bossMonster.attack(bossMonsterAttackDamage, player);
    }

    public void changeBossMonsterAppearanceToHappy(BossMonster bossMonster) {
        bossMonster.changeAppearance(BossMonsterAppearance.HAPPY);
    }
}
