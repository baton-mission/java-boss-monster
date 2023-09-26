package bossmonster.controller;

import static bossmonster.util.RetryUtil.read;

import bossmonster.domain.Boss;
import bossmonster.domain.Player;
import bossmonster.domain.PlayerName;
import bossmonster.domain.PlayerStatus;
import bossmonster.dto.request.BossHpDto;
import bossmonster.dto.request.PlayerNameDto;
import bossmonster.dto.request.PlayerStatusInfoDto;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class BossGameController {

    private static final InputView INPUT_VIEW = InputView.INSTANCE;
    private static final OutputView OUTPUT_VIEW = OutputView.INSTANCE;

    public void run() {
        Boss boss = read(this::createBoss);

        Player player = read(this::createPlayer);

        OUTPUT_VIEW.printStartMessage();
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
