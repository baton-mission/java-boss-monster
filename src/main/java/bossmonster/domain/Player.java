package bossmonster.domain;

import bossmonster.ExceptionMessage;

import java.util.List;

import static bossmonster.domain.GameOption.*;

public class Player {
	private String name;
	private Stats stats;
	private AttackType attackType;

	public Player() {
	}

	public boolean isAlive() {
		return stats.isAlive();
	}

	public int attackBoss() {
		int attackDamage = stats.calculateAttackDamage(attackType);
		stats.handleCost(attackType);
		stats.addAttackCount();
		return attackDamage;
	}

	public void attacked(int attackDamage) {
		stats.reduceHp(attackDamage);
	}

	public void setName(String name) {
		validateName(name);
		this.name = name;
	}

	private void validateName(String name) {
		isBlank(name);
		isLegalLength(name);
	}

	private void isBlank(String name) {
		if (name.isBlank()) {
			throw new IllegalArgumentException(ExceptionMessage.BLANK);
		}
	}

	private void isLegalLength(String name) {
		if (name.length() > PLAYER_NAME_MAX_INCLUSIVE) {
			throw new IllegalArgumentException(ExceptionMessage.PLAYER_NAME_LENGTH);
		}
	}

	public void setStats(List<Integer> playerStats) {
		this.stats = new Stats(playerStats);
	}

	public void setAttackType(AttackType attackType) {
		this.attackType = attackType;
	}

	public String getAttackTypeName() {
		return this.attackType.getTypeName();
	}

	public int getAttackCount() {
		return stats.getAttackCount();
	}

	public String getName() {
		return name;
	}

	public List<Integer> getHp() {
		return stats.getHp();
	}

	public List<Integer> getMp() {
		return stats.getMp();
	}
}
