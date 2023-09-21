package bossmonster;

import bossmonster.domain.Boss;
import bossmonster.domain.Player;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static bossmonster.domain.GameOption.DELIMITER;

public class Controller {
	public void run() {
		Boss boss = initBoss();
		Player player = initPlayer();

		OutputView.printRadeStart();
	}

	// TODO 제내릭으로 리펙터링
	private Boss initBoss() {
		try {
			int bossHp = Converter.stringToInt(InputView.readBossHp());
			return new Boss(bossHp);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			return initBoss();
		}
	}

	private Player initPlayer() {
		Player player = new Player();
		initPlayerName(player);
		initPlayerHPAndMP(player);
		return player;
	}

	private void initPlayerName(Player player) {
		try {
			player.setName(InputView.readPlayerName());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			initPlayerName(player);
		}
	}

	private void initPlayerHPAndMP(Player player) {
		try {
			String playerStatsString = InputView.readPlayerInfo();
			List<Integer> playerStats = Arrays.stream(playerStatsString.split(DELIMITER))
					.map(Converter::stringToInt)
					.collect(Collectors.toList());
			player.setHpAndMp(playerStats);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			initPlayerHPAndMP(player);
		}
	}
}
