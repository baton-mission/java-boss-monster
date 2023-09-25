package bossmonster.service;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BattleTest {

    String name;
    List<Integer> status;

    Battle battle = new Battle();

    @BeforeEach
    void beforeEach() {
        name = "testName";
        int hp = 150;
        int mp = 50;
        status = new ArrayList<>();
        status.add(hp);
        status.add(mp);
    }

    @DisplayName("플레이어 공격 턴 테스트 - 물리 공격")
    @Test
    void attackBossMonsterByPhysicalAttack() {
        //given
        Player player = new Player(name, status);
        BossMonster bossMonster = new BossMonster(150);

        //when
        player.consumeMp();
        battle.attackBossMonster(player, bossMonster, 1);

        //then
        assertThat(bossMonster.getHp()).isEqualTo(140);
        assertThat(player.getMp()).isEqualTo(30);
    }

    @DisplayName("플레이어 공격 턴 테스트 - 마법 공격")
    @Test
    void attackBossMonsterByMagicAttack() {
        //given
        Player player = new Player(name, status);
        BossMonster bossMonster = new BossMonster(150);

        //when
        battle.attackBossMonster(player, bossMonster, 2);

        //then
        assertThat(bossMonster.getHp()).isEqualTo(130);
        assertThat(player.getMp()).isEqualTo(20);
    }

    @DisplayName("보스 몬스터 공격 턴 테스트")
    @Test
    void attackPlayer() {
        //given
        Player player = new Player(name, status);
        BossMonster bossMonster = new BossMonster(150);

        //when
        battle.attackPlayer(player, bossMonster);

        //then
        assertThat(player.getHp()).isLessThan(150);
    }

    @DisplayName("플레이어 승리 테스트")
    @Test
    void isVictory() {
        //given
        BossMonster bossMonster = new BossMonster(100);

        //when
        bossMonster.reduceHp(90);
        boolean result1 = battle.isVictory(bossMonster);
        bossMonster.reduceHp(10);
        boolean result2 = battle.isVictory(bossMonster);

        //then
        assertThat(result1).isEqualTo(false);
        assertThat(result2).isEqualTo(true);
    }

    @DisplayName("플레이어 패배 테스트")
    @Test
    void isDefeat() {
        //given
        Player player = new Player(name, status);

        //when
        player.reduceHp(100);
        boolean result1 = battle.isDefeat(player);
        player.reduceHp(50);
        boolean result2 = battle.isDefeat(player);

        //then
        assertThat(result1).isEqualTo(false);
        assertThat(result2).isEqualTo(true);
    }
}