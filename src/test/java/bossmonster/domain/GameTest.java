package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    private final int bossHp = 100;
    private final String playerName = "dori";
    private final int playerHp = 100;
    private final int playerMp = 100;

    @Test
    @DisplayName("게임 초기화 테스트")
    void initGame(){
        //given
        final BossMonster bossMonster = new BossMonster(bossHp);
        final Player player = new Player(playerName, playerHp, playerMp);
        final Game game = new Game(bossMonster, player);

        //when
        BossMonster newBossMonster = game.getBossMonster();
        Player newPlayer = game.getPlayer();

        //then
        assertThat(newBossMonster).isEqualTo(bossMonster);
        assertThat(newPlayer).isEqualTo(player);
    }
}
