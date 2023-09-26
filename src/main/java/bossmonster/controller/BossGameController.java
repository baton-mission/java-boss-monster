package bossmonster.controller;

import static bossmonster.util.RetryUtil.read;

import bossmonster.domain.AttackType;
import bossmonster.domain.Boss;
import bossmonster.domain.BossGame;
import bossmonster.domain.Player;
import bossmonster.domain.PlayerName;
import bossmonster.domain.PlayerStatus;
import bossmonster.dto.request.AttackTypeCodeDto;
import bossmonster.dto.request.BossHpDto;
import bossmonster.dto.request.PlayerNameDto;
import bossmonster.dto.request.PlayerStatusInfoDto;
import bossmonster.dto.response.AttackTypeDto;
import bossmonster.dto.response.BossAndPlayerStatusDto;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class BossGameController {

    private static final InputView INPUT_VIEW = InputView.INSTANCE;
    private static final OutputView OUTPUT_VIEW = OutputView.INSTANCE;

    public void run() {
        Boss boss = read(this::createBoss);
        Player player = read(this::createPlayer);
        printStartMessage();
        printBossAndPlayerStatus(boss, player);

        AttackType attackType = read(this::scanAttackType);

        BossGame bossGame = BossGame.init(boss, player);
        bossGame.attack(attackType);

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
        return Boss.from(bossHpDto.getHp());
    }
}
