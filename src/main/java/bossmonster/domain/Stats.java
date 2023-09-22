package bossmonster.domain;

import bossmonster.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

import static bossmonster.domain.GameOption.PLAYER_MAGIC_ATTACK_MP_COST;
import static bossmonster.domain.GameOption.PLAYER_MP_RECOVER;

public class Stats {
	private Point hp;
	private Point mp;
	private int attackCount;

	public Stats(List<Integer> stats) {
		validateStats(stats);
		this.hp = new Point(stats.get(GameOption.HP_INDEX));
		this.mp = new Point(stats.get(GameOption.MP_INDEX));
		this.attackCount = attackCount;
	}

	private void validateStats(List<Integer> playerStats) {
		isLegalSize(playerStats);
		isLegalSumValue(playerStats);
	}

	private void isLegalSize(List<Integer> playerStats) {
		if (playerStats.size() != GameOption.PLAYER_STATS_SIZE) {
			throw new IllegalArgumentException(ExceptionMessage.PLAYER_STATS_SIZE);
		}
	}

	private void isLegalSumValue(List<Integer> playerStats) {
		Integer sumValue = playerStats.stream()
				.reduce(Integer::sum)
				.get();
		if (!sumValue.equals(GameOption.PLAYER_SUM_VALUE)) {
			throw new IllegalArgumentException(ExceptionMessage.PLAYER_STATS_SUM_VALUE);
		}
	}

	public boolean isAlive() {
		return hp.isEqualOrMoreThen(1);
	}

	public void addAttackCount() {
		attackCount++;
	}

	public int getAttackCount() {
		return attackCount;
	}

	public boolean hasEnoughMp(int amount) {
		return mp.isEqualOrMoreThen(amount);
	}

	public void handleCost(AttackType attackType) {
		if (attackType.equals(AttackType.PHYSICAL)) {
			mp.addAmount(PLAYER_MP_RECOVER);
			return;
		}
		if (attackType.equals(AttackType.MAGIC)) {
			if (!mp.isEqualOrMoreThen(PLAYER_MAGIC_ATTACK_MP_COST)) {
				return;
			}
			mp.reduceAmount(PLAYER_MAGIC_ATTACK_MP_COST);
		}
	}

	public void reduceHp(int attackDamage) {
		hp.reduceAmount(attackDamage);
	}

	public List<Integer> getHp() {
		return new ArrayList<>(List.of(hp.getCurAmount(), hp.getStartAmount()));
	}

	public List<Integer> getMp() {
		return new ArrayList<>(List.of(mp.getCurAmount(), mp.getStartAmount()));
	}
}
