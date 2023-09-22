package bossmonster.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Health;
import bossmonster.domain.Player;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class BossMonsterGame {

	public void startGame() {
		BossMonster bossMonster = inputBossHp();
		Player player = inputPlayer();
		OutputView.printStartRaidMessage();
	}

	private BossMonster inputBossHp() {
		OutputView.printBossHp();
		String bossHp = InputView.readBossHp();
		Health health = new Health(Integer.parseInt(bossHp), 0);
		return new BossMonster(health);
	}

	private Player inputPlayer() {
		OutputView.printPlayerName();
		String playerName = InputView.readPlayer();
		List<Integer> health = inputPlayerHpAndMp();
		return new Player(playerName, new Health(health.get(0), health.get(1)));
	}

	private List<Integer> inputPlayerHpAndMp() {
		OutputView.printPlayerHpAndMp();
		String hpAndMp = InputView.readPlayerHpAndMp();
		return Arrays.stream(hpAndMp.split(","))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}
