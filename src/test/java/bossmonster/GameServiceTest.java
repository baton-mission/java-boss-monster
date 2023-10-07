package bossmonster;

import bossmonster.domain.*;
import bossmonster.service.BossWeapon;
import bossmonster.service.GameService;
import org.junit.jupiter.api.Test;

import static bossmonster.util.ErrorMessage.MANA_LACK;
import static org.assertj.core.api.Assertions.*;

public class GameServiceTest {

    private final GameStatus gameStatus = new GameStatus();
    private final GameService gameService = new GameService(gameStatus);

    @Test
    void 유저의_공격_테스트() {
        //given
        Boss boss = new Boss("100");
        Player player = new Player(new Name("name"), new Status(new int[]{100, 100}));
        AttackType type = AttackType.PHYSICAL;

        //when
        gameService.attackToBoss(boss, player, type);

        //then
        assertThat(boss.getHp()).isEqualTo(90);
        assertThat(player.getMp()).isEqualTo(100);
    }

    @Test
    void 유저의_공격_테스트2() {
        //given
        Boss boss = new Boss("100");
        Player player = new Player(new Name("name"), new Status(new int[]{100, 100}));
        AttackType type = AttackType.MAGICAL;

        //when
        gameService.attackToBoss(boss, player, type);

        //then
        assertThat(boss.getHp()).isEqualTo(80);
        assertThat(player.getMp()).isEqualTo(70);
    }

    @Test
    void 유저의_공격_테스트3() {
        //given
        Boss boss = new Boss("100");
        Player player = new Player(new Name("name"), new Status(new int[]{100, 100}));
        AttackType type = AttackType.MAGICAL;
        AttackType type2 = AttackType.PHYSICAL;

        //when
        gameService.attackToBoss(boss, player, type);
        gameService.attackToBoss(boss, player, type2);

        //then
        assertThat(boss.getHp()).isEqualTo(70);
        assertThat(player.getMp()).isEqualTo(80);
    }

    @Test
    void 마나_부족_테스트() {
        //given
        Boss boss = new Boss("100");
        Player player = new Player(new Name("name"), new Status(new int[]{171, 29}));
        AttackType type = AttackType.MAGICAL;

        //when & then
        assertThatThrownBy(() -> gameService.attackToBoss(boss, player, type))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MANA_LACK);
    }

    @Test
    void 보스의_공격_테스트() {
        //given
        int bossDamage = BossWeapon.attack();
        Player player = new Player(new Name("name"), new Status(new int[]{100, 100}));

        //when
        gameService.attackToPlayer(bossDamage, player);

        //then
        assertThat(player.getHp()).isEqualTo(player.getInitialHp() - bossDamage);
    }
}
