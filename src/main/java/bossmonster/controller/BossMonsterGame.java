package bossmonster.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import bossmonster.domain.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Health;
import bossmonster.domain.Player;
import bossmonster.domain.RandomDamageGenerator;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class BossMonsterGame {

	private final RandomDamageGenerator randomDamageGenerator;

	public BossMonsterGame(RandomDamageGenerator randomDamageGenerator) {
		this.randomDamageGenerator = randomDamageGenerator;
	}

	public void startGame() {
		BossMonster bossMonster = inputBossHp();
		Player player = inputPlayer();
		OutputView.printStartRaidMessage();
		OutputView.printStartGameStatus(bossMonster, player);
		play(bossMonster, player);
	}

	public void play(BossMonster bossMonster, Player player) {
		while (true) {
			OutputView.printAttackType();
			AttackType type = inputAttackType();
			player.attack(type);
			bossMonster.attackedByPlayer(type);
			int damage = randomDamageGenerator.generate();
			player.attackedByBossMonster(damage);
			OutputView.printPlayerAttackDamage(type);
			if (bossMonster.bossHpZero()) {
				break;
			}
			OutputView.printBossAttackDamage(damage);
			if (player.playerHpZero()) {
				OutputView.printFailGameStatus(bossMonster, player);
				OutputView.printPlayerHpZero(player.getName());
				break;
			}
			OutputView.printPlayGameStatus(bossMonster, player);
		}
	}

	private AttackType inputAttackType() {
		String type = InputView.readAttackType();
		return AttackType.valueOfType(type);
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
