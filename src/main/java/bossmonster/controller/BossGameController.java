package bossmonster.controller;

import static bossmonster.util.RetryUtil.read;

import bossmonster.domain.AttackType;
import bossmonster.domain.Boss;
import bossmonster.domain.BossGame;
import bossmonster.domain.DamageStrategy;
import bossmonster.domain.Player;
import bossmonster.domain.PlayerName;
import bossmonster.domain.PlayerStatus;
import bossmonster.dto.request.AttackTypeCodeDto;
import bossmonster.dto.request.BossHpDto;
import bossmonster.dto.request.PlayerNameDto;
import bossmonster.dto.request.PlayerStatusInfoDto;
import bossmonster.dto.response.AttackTypeDto;
import bossmonster.dto.response.BossAndPlayerStatusDto;
import bossmonster.dto.response.BossAttackDto;
import bossmonster.dto.response.PlayerBossInfoDto;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class BossGameController {

    private static final InputView INPUT_VIEW = InputView.INSTANCE;
    private static final OutputView OUTPUT_VIEW = OutputView.INSTANCE;

    private final DamageStrategy damageStrategy;

    public BossGameController(DamageStrategy damageStrategy) {
        this.damageStrategy = damageStrategy;
    }

    public void run() {
        Boss boss = read(this::createBoss);
        Player player = read(this::createPlayer);
        printStartMessage();
        printBossAndPlayerStatus(boss, player);
        BossGame bossGame = BossGame.init(boss, player);
        playingGame(bossGame);

    }

    private void playingGame(BossGame bossGame) {
        AttackType attackType = read(this::scanAttackType);
        int bossDamage = bossGame.attack(attackType);

        /**
         * 물리 공격을 했습니다. (입힌 데미지: 10)
         * 보스가 공격 했습니다. (입힌 데미지: 10)
         *
         * ============================
         * BOSS HP [30/100]
         * ____________________________
         *    ^-^
         *  / x x \
         * (   "\  )
         *  \  ^  /
         *   - ^ -
         * ____________________________
         *
         * dori HP [50/100] MP [20/100]
         * ============================
         */

        if (bossGame.isBossDead()) {
            BossAttackDto bossDeadResponseDto = new BossAttackDto(attackType, bossGame);
            OUTPUT_VIEW.printBossDeadMessage(bossDeadResponseDto);
            // 종료 되어야 한다.
            return;
        }

        if (bossGame.isPlayerDead()) {
            PlayerBossInfoDto playerBossInfoResponseDto = new PlayerBossInfoDto(attackType, bossDamage, bossGame);
            OUTPUT_VIEW.printPlayerDeadMessage(playerBossInfoResponseDto);
            // 종료 되어야 한다.
            return;
        }

        // 일반적인 경우 => 공격 턴 재시도
        PlayerBossInfoDto playerBossInfoResponseDto = new PlayerBossInfoDto(attackType, bossDamage, bossGame);
        OUTPUT_VIEW.printGameCurrentStatus(playerBossInfoResponseDto);
        playingGame(bossGame);
    }

    private AttackType scanAttackType() {
        AttackTypeDto attackTypeDto = new AttackTypeDto();
        AttackTypeCodeDto attackTypeCodeDto = read(INPUT_VIEW::scanAttackType, attackTypeDto);
        return AttackType.fromCode(attackTypeCodeDto.getAttackTypeCode());
    }

    private static void printStartMessage() {
        OUTPUT_VIEW.printStartMessage();
    }

    private void printBossAndPlayerStatus(Boss boss, Player player) {
        BossAndPlayerStatusDto bossAndPlayerStatusDto = new BossAndPlayerStatusDto(boss, player);
        OUTPUT_VIEW.printBossAndPlayerStatus(bossAndPlayerStatusDto);
    }

    private Player createPlayer() {
        PlayerName playerName = read(this::createPlayerName);
        PlayerStatus playerStatus = read(this::createPlayerStatus);
        return Player.from(playerName, playerStatus);
    }

    private PlayerStatus createPlayerStatus() {
        PlayerStatusInfoDto statusInfoDto = read(INPUT_VIEW::scanPlayerHpAndMp);
        return PlayerStatus.from(statusInfoDto.getPlayerHp(), statusInfoDto.getPlayerMp());
    }

    private PlayerName createPlayerName() {
        PlayerNameDto playerNameDto = read(INPUT_VIEW::scanPlayerNames);
        return PlayerName.from(playerNameDto.getPlayerName());
    }

    private Boss createBoss() {
        BossHpDto bossHpDto = read(INPUT_VIEW::scanBossHp);
        return Boss.from(bossHpDto.getHp(), damageStrategy);
    }
}
