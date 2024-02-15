package bossmonster.service;

import static bossmonster.constant.PlayerConstant.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import bossmonster.dto.MonsterDTO;
import bossmonster.dto.PlayerDTO;

class RaidServiceTest {
	private RaidService raidService;

	@BeforeEach
	void setUp() {
		raidService = new RaidService();
		raidService.createMonster(100);
		raidService.createPlayer("Test", 100, 100);
	}

	@Test
	@DisplayName("플레이어의 물리 공격은 보스 몬스터의 HP를 10 감소시킨다.")
	void playerPhysicalAttack1() {
		// given

		// when
		raidService.attackByPlayer(PHYSICAL_ATTACK);
		MonsterDTO monsterDTO = raidService.getMonsterDTO();

		// then
		assertThat(monsterDTO.getNowHp()).isEqualTo(90);
	}

	@Test
	@DisplayName("플레이어의 마법 공격은 보스 몬스터의 HP를 20 감소시키고, 자신의 MP를 30 소모한다.")
	void playerMagicalAttack() {
		// given

		// when
		raidService.attackByPlayer(MAGIC_ATTACK);
		PlayerDTO playerDTO = raidService.getPlayerDTO();
		MonsterDTO monsterDTO = raidService.getMonsterDTO();

		// then
		assertThat(monsterDTO.getNowHp()).isEqualTo(80);
		assertThat(playerDTO.getNowMp()).isEqualTo(70);

	}

	@Test
	@DisplayName("플레이어의 물리 공격은 자신의 MP를 10 회복한다.")
	void playerPhysicalAttack2() {
		// given

		// when
		raidService.attackByPlayer(MAGIC_ATTACK);
		raidService.attackByPlayer(PHYSICAL_ATTACK);
		PlayerDTO playerDTO = raidService.getPlayerDTO();

		// then
		assertThat(playerDTO.getNowMp()).isEqualTo(80);
	}


	@RepeatedTest(50)
	@DisplayName("몬스터는 0 ~ 20의 랜덤 데미지를 입힌다.")
	void MonsterAttack() {
		// given

		// when
		raidService.attackByMonster();
		PlayerDTO playerDTO = raidService.getPlayerDTO();

		// then
		assertThat(playerDTO.getNowMp()).isBetween(80, 100);
	}
}