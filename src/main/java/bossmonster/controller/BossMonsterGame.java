package bossmonster.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
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
		BossMonster bossMonster = repeat(this::inputBossHp);
		Player player = repeat(this::inputPlayer);
		OutputView.printStartRaidMessage();
		OutputView.printStartGameStatus(bossMonster, player);
		play(bossMonster, player);
	}

	private BossMonster inputBossHp() {
		OutputView.printBossHp();
		int bossHp = InputView.readBossHp();
		Health health = new Health(bossHp);
		return new BossMonster(health, randomDamageGenerator);
	}

	private Player inputPlayer() {
		OutputView.printPlayerName();
		String playerName = InputView.readPlayer();
		List<Integer> health = repeat(this::inputPlayerHpAndMp);
		return new Player(playerName, new Health(health.get(0), health.get(1)));
	}

	private List<Integer> inputPlayerHpAndMp() {
		OutputView.printPlayerHpAndMp();
		String hpAndMp = InputView.readPlayerHpAndMp();
		return Arrays.stream(hpAndMp.split(","))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	private void play(BossMonster bossMonster, Player player) {
		int count = 0;
		while (true) {
			count++;
			OutputView.printSelectType();
			AttackType type = repeat(this::inputAttackType);
			attackBossBy(bossMonster, player, type);
			int damage = attackPlayerBy(bossMonster, player);
			OutputView.printPlayerAttackDamage(type);
			if (checkBossHpZero(bossMonster, player, count)) {
				break;
			}
			OutputView.printBossAttackDamage(damage);
			if (checkPlayerDead(player)) {
				OutputView.printFailGameStatus(bossMonster, player);
				OutputView.printFail(player.getName());
				break;
			}
			OutputView.printPlayGameStatus(bossMonster, player);
		}
	}

	private AttackType inputAttackType() {
		String type = InputView.readAttackType();
		return AttackType.valueOfType(type);
	}

	private void attackBossBy(BossMonster bossMonster, Player player, AttackType type) {
		if (player.isRemainMP(type)) {
			player.attack(type);
			bossMonster.attackedByPlayer(type);
		}
	}

	private int attackPlayerBy(BossMonster bossMonster, Player player) {
		int boss = bossMonster.generateBossHitDamage();
		player.attackedBy(boss);
		return boss;
	}

	private boolean checkBossHpZero(BossMonster bossMonster, Player player, int count) {
		if (bossMonster.bossHpZero()) {
			OutputView.printRaidSuccessMessage(player.getName(), count);
			return true;
		}
		return false;
	}

	private boolean checkPlayerDead(Player player) {
		return player.isPlayerDead();
	}

	private <T> T repeat(Supplier<T> inputReader) {
		try {
			return inputReader.get();
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			return repeat(inputReader);
		}
	}
}
