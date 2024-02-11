package bossmonster.controller;

import bossmonster.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerControllerTest {
    private final static String NAME = "dori";
    private final static int HP_INIT = 100;
    private final static int MP_INIT = 100;
    private final static int DAMAGE = 17;
    private final static int deadDamage = 100;
    private final Player player = new Player(NAME, HP_INIT, MP_INIT);
    private final Player playerDead = new Player(NAME, 0, MP_INIT - DAMAGE);
    private final Player playerHit = new Player(NAME, HP_INIT - DAMAGE, MP_INIT);

    private final PlayerController playerController = new PlayerController();

    @Test
    @DisplayName("플레이어 공격당했을 때 Hp 테스트")
    void playerHitTest(){
        assertThat(playerController.hit(player, DAMAGE).getHp()).isEqualTo(playerHit.getHp());
    }

    @Test
    @DisplayName("플레이어 회복 시 MP 테스트")
    void recoverMpTest(){
        assertThat(playerDead.getMp()).isEqualTo(MP_INIT-DAMAGE);
        assertThat(playerController.recover(playerDead).getMp()).isEqualTo(MP_INIT);
    }

    @Test
    @DisplayName("플레이어 죽었는지 확인 테스트")
    void playerDeadTest(){
        assertThat(playerController.die(player)).isFalse();
        assertThat(playerController.die(playerDead)).isTrue();
    }
}
