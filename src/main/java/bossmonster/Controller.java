package bossmonster;

import bossmonster.domain.Boss;
import bossmonster.domain.GameOption;
import bossmonster.domain.Player;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static bossmonster.domain.GameOption.*;

public class Controller {
	public void run() {
		Boss boss = initBoss();
		Player player = initPlayer();
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
		try {
			String playerName = InputView.readPlayerName();
			String playerInfoString = InputView.readPlayerInfo();
			List<Integer> playerInfo = Arrays.stream(playerInfoString.split(DELIMITER))
					.map(Converter::stringToInt)
					.collect(Collectors.toList());
			return new Player(playerName, playerInfo.get(HP_INDEX), playerInfo.get(MP_INDEX));
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			return initPlayer();
		}
	}
}
