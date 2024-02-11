package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private static final String PLAYER_NAME1 = "전영은";
    private static final String PlAYER_NAME2 = "안녕하세요반가워요";
    private static final int PLAYER_HP1 = 150;
    private static final int PLAYER_MP1 = 50;

    @Test
    @DisplayName("플레이어 정보 저장 테스트")
    void storePlayerInfoTest(){
        Player player = new Player(PLAYER_NAME1, PLAYER_HP1, PLAYER_MP1);

        assertThat(player.getName()).isEqualTo(PLAYER_NAME1);
        assertThat(player.getHp()).isEqualTo(PLAYER_HP1);
        assertThat(player.getMp()).isEqualTo(PLAYER_MP1);
    }
}
