package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bossmonster.domain.dto.GameHistoryDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaidGameTest {

    @DisplayName("게임 기록 요청 시, DTO를 생성하여 반환함")
    @Test
    void confirmHistoryDtoByRequestHistory() {
        //given
        Player player = new Player("홍길동", 100, 100);
        BossMonster bossMonster = new BossMonster(100);
        RaidGame raidGame = new RaidGame(bossMonster, player);

        //when, then
        assertThat(raidGame.getGameHistory()).isExactlyInstanceOf(GameHistoryDto.class);
    }

    @DisplayName("게임 시작 전 턴 수는 0임")
    @Test
    void confirmDefaultTurn() {
        //given
        Player player = new Player("홍길동", 100, 100);
        BossMonster bossMonster = new BossMonster(100);
        RaidGame raidGame = new RaidGame(bossMonster, player);
        GameHistoryDto gameHistoryDto;

        //when
        gameHistoryDto = raidGame.getGameHistory();

        //then
        assertThat(gameHistoryDto.getTurnCount()).isEqualTo(0);
    }

    @DisplayName("턴이 진행되면 턴 수가 증가함")
    @Test
    void confirmIncreaseTurnByExecuteTurn() {
        //given
        Player player = new Player("홍길동", 100, 100);
        BossMonster bossMonster = new BossMonster(100);
        RaidGame raidGame = new RaidGame(bossMonster, player);
        GameHistoryDto gameHistoryDto;

        //when
        raidGame.executeTurn(AttackType.ATTACK_TYPE_NORMAL);
        gameHistoryDto = raidGame.getGameHistory();

        //then
        assertThat(gameHistoryDto.getTurnCount()).isEqualTo(1);
    }

    @DisplayName("턴이 진행되면 플레이어와 보스 몬스터가 공격을 주고 받음")
    @Test
    void confirmAttackByExecuteTurn() {
        //given
        Player player = new Player("홍길동", 100, 100);
        BossMonster bossMonster = new BossMonster(100);
        RaidGame raidGame = new RaidGame(bossMonster, player);
        GameHistoryDto gameHistoryDto;

        //when
        raidGame.executeTurn(AttackType.ATTACK_TYPE_NORMAL);
        gameHistoryDto = raidGame.getGameHistory();
        int playerAttackDamage = gameHistoryDto.getPlayerAttackDamage();
        int monsterAttackDamage = gameHistoryDto.getMonsterAttackDamage();

        //then
        assertThat(gameHistoryDto.getPlayerCurrentHP()).isEqualTo(
                gameHistoryDto.getPlayerMaxHP() - monsterAttackDamage);
        assertThat(gameHistoryDto.getMonsterCurrentHP()).isEqualTo(
                gameHistoryDto.getMonsterMaxHP() - playerAttackDamage);
    }

    @DisplayName("플레이어의 공격으로 보스 몬스터가 죽으면 플레이어를 공격하지 않음")
    @Test
    void confirmMonsterDieByPlayerAttack() {
        //given
        Player player = new Player("홍길동", 100, 100);
        BossMonster bossMonster = new BossMonster(100);
        RaidGame raidGame = new RaidGame(bossMonster, player);
        GameHistoryDto gameHistoryDto;

        //when
        bossMonster.takeDamage(90);
        raidGame.executeTurn(AttackType.ATTACK_TYPE_NORMAL);
        gameHistoryDto = raidGame.getGameHistory();

        //then
        assertThat(gameHistoryDto.getPlayerCurrentHP()).isEqualTo(gameHistoryDto.getPlayerMaxHP());
        assertThat(gameHistoryDto.getMonsterCurrentHP()).isEqualTo(0);
        assertThat(bossMonster.isAlive()).isFalse();
    }

    @DisplayName("플레이어가 죽으면 턴이 실행되지 않음")
    @Test
    void confirmNotRunningByPlayerDie() {
        //given
        Player player = new Player("홍길동", 100, 100);
        BossMonster bossMonster = new BossMonster(100);
        RaidGame raidGame = new RaidGame(bossMonster, player);
        GameHistoryDto gameHistoryDto;

        //when
        player.takeDamage(100);
        raidGame.executeTurn(AttackType.ATTACK_TYPE_NORMAL);
        gameHistoryDto = raidGame.getGameHistory();

        //then
        assertThat(player.isAlive()).isFalse();
        assertThat(gameHistoryDto.getTurnCount()).isEqualTo(0);
    }

    @DisplayName("보스 몬스터가 죽으면 턴이 실행되지 않음")
    @Test
    void confirmNotRunningByBossMonsterDie() {
        //given
        Player player = new Player("홍길동", 100, 100);
        BossMonster bossMonster = new BossMonster(100);
        RaidGame raidGame = new RaidGame(bossMonster, player);
        GameHistoryDto gameHistoryDto;

        //when
        bossMonster.takeDamage(100);
        raidGame.executeTurn(AttackType.ATTACK_TYPE_NORMAL);
        gameHistoryDto = raidGame.getGameHistory();

        //then
        assertThat(bossMonster.isAlive()).isFalse();
        assertThat(gameHistoryDto.getTurnCount()).isEqualTo(0);
    }
}