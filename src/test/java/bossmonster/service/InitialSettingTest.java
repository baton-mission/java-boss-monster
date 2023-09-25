package bossmonster.service;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InitialSettingTest {

    InitialSetting initialSetting = new InitialSetting();

    @DisplayName("플레이어 정보 세팅 테스트")
    @Test
    void setPlayerStatus() {
        //given
        final String name = "testName";
        final int hp = 150;
        final int mp = 50;
        List<Integer> status = new ArrayList<>();
        status.add(hp);
        status.add(mp);

        //when
        Player player = initialSetting.setPlayerStatus(name, status);

        //then
        assertThat(player.getName()).isEqualTo("testName");
        assertThat(player.getStatus().get(0)).isEqualTo(150);
        assertThat(player.getStatus().get(1)).isEqualTo(50);
    }

    @DisplayName("보스 몬스터 정보 세팅 테스트")
    @Test
    void setBossMonsterStatus() {
        //given
        final int hp = 200;

        //when
        BossMonster bossMonster = initialSetting.setBossMonsterStatus(hp);

        //then
        assertThat(bossMonster.getHp()).isEqualTo(200);
        assertThat(bossMonster.getTurnCount()).isEqualTo(1);
    }

}