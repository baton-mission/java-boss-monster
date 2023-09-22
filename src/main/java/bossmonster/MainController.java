package bossmonster;

import bossmonster.domain.player.AttackType;
import bossmonster.domain.boss.Boss;
import bossmonster.domain.GameService;
import bossmonster.domain.player.Player;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

import java.util.List;

import static bossmonster.domain.GameOption.DELIMITER;

public class MainController {
	public static final GameService service = new GameService();

	public void run() {
		Boss boss = initBoss();
		Player player = initPlayer();
		proceedRade(boss, player);
		printResult(boss, player);
	}

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
			List<Integer> playerStats = Converter.stringToSplitInt(playerStatsString, DELIMITER);
			player.setStats(playerStats);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			initPlayerHPAndMP(player);
		}
	}

	private void proceedRade(Boss boss, Player player) {
		OutputView.printRadeStart();
		while (boss.isAlive() && player.isAlive()) {
			OutputView.printRadeInfo(boss, player);
			initAttackType(player);
			int playerToBossDamage = service.attackBoss(boss, player);
			int bossToPlayerDamage = service.attackPlayer(boss, player);
			OutputView.printPlayerAttackResult(playerToBossDamage, player);
			if (boss.isAlive()) {
				OutputView.printBossAttackResult(bossToPlayerDamage);
			}
		}
	}

	private void initAttackType(Player player) {
		try {
			int attackNumber = Converter.stringToInt(InputView.readAttackType());
			player.setAttackType(AttackType.findByNumber(attackNumber));
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			initAttackType(player);
		}
	}

	private void printResult(Boss boss, Player player) {
		if (player.isAlive()) {
			OutputView.printRadeWin(player);
			return;
		}
		OutputView.printRadeInfo(boss, player);
		OutputView.printRadeLoss(player);
	}

}
