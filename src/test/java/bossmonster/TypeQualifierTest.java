package bossmonster;

import bossmonster.domain.creatures.Boss;
import bossmonster.domain.creatures.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TypeQualifierTest {
    @Test
    @DisplayName("Boss를 Boss class로 검사하면 True로 반환")
    void 보스_테스트_정상() {
        //given
        Boss boss = new Boss(100, 0);
        //when
        boolean result = TypeQualifier.checkCreatureType(Boss.class, boss);
        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("Boss를 Player class로 검사하면 False 반환")
    void 보스_테스트_실패_반환() {
        //given
        Boss boss = new Boss(100, 0);
        //when
        boolean result = TypeQualifier.checkCreatureType(Player.class, boss);
        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("player를 Player class로 검사하면 true 반환")
    void 플레이어_테스트_성공() {
        //given
        Player player = new Player(100, 100, "test");
        //when
        boolean result = TypeQualifier.checkCreatureType(Player.class, player);
        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("player를 boss class로 검사하면 False 반환")
    void 플레이어_테스트_실패_반환() {
        //given
        Player player = new Player(100, 100, "test");
        //when
        boolean result = TypeQualifier.checkCreatureType(Boss.class, player);
        //then
        assertThat(result).isEqualTo(false);
    }
}