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
		String bossHp = InputView.readBossHp();
		Health health = new Health(toInteger(bossHp));
		return new BossMonster(health);
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
			OutputView.printAttackType();
			AttackType type = repeat(() -> inputAttackType(player));
			attackBossByPlayer(bossMonster, player, type);
			int damage = attackPlayerByBoss(player);
			OutputView.printPlayerAttackDamage(type);
			if (checkBossHpZero(bossMonster, player, count)) {
				break;
			}
			OutputView.printBossAttackDamage(damage);
			if (checkPlayerHpZero(bossMonster, player)) {
				break;
			}
			OutputView.printPlayGameStatus(bossMonster, player);
		}
	}

	private AttackType inputAttackType(Player player) {
		String type = InputView.readAttackType();
		AttackType attackType = AttackType.valueOfType(type);
		if (player.validateRemainMP(attackType)) {
			return attackType;
		}
		throw new IllegalArgumentException("");
	}

	private void attackBossByPlayer(BossMonster bossMonster, Player player, AttackType type) {
		if (player.validateRemainMP(type)) {
			player.attack(type);
			bossMonster.attackedByPlayer(type);
		}
	}

	private int attackPlayerByBoss(Player player) {
		int damage = randomDamageGenerator.generate();
		player.attackedByBossMonster(damage);
		return damage;
	}

	private boolean checkBossHpZero(BossMonster bossMonster, Player player, int count) {
		if (bossMonster.bossHpZero()) {
			OutputView.printRaidSuccessMessage(player.getName(), count);
			return true;
		}
		return false;
	}

	private boolean checkPlayerHpZero(BossMonster bossMonster, Player player) {
		if (player.playerHpZero()) {
			OutputView.printFailGameStatus(bossMonster, player);
			OutputView.printPlayerHpZero(player.getName());
			return true;
		}
		return false;
	}

	private Integer toInteger(String number) {
		try {
			return Integer.valueOf(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 보스의 체력은 숫자만 입력이 가능합니다.");
		}
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
