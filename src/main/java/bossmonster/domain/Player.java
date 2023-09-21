package bossmonster.domain;

import bossmonster.ExceptionMessage;

import java.util.List;

import static bossmonster.domain.GameOption.*;

// TODO 책임 분리 필요
public class Player {
	private String name;
	private int startHp;
	private int startMp;
	private int curHp;
	private int curMp;
	private AttackType attackType;

	public Player() {
	}

	public void setName(String name) {
		validateName(name);
		this.name = name;
	}

	public void setHpAndMp(List<Integer> playerStats) {
		validateStats(playerStats);
		startHp = playerStats.get(HP_INDEX);
		startMp = playerStats.get(MP_INDEX);
		this.curHp = startHp;
		this.curMp = startMp;
	}

	public void setAttackType(AttackType attackType) {
		this.attackType = attackType;
	}

	private void validateName(String name) {
		isBlank(name);
		isLegalLength(name);
	}

	private void validateStats(List<Integer> playerStats) {
		isLegalSize(playerStats);
		isPositiveNumber(playerStats);
		isLegalSumValue(playerStats);
	}

	private void isLegalSize(List<Integer> playerStats) {
		if (playerStats.size() != GameOption.PLAYER_STATS_SIZE) {
			throw new IllegalArgumentException(ExceptionMessage.PLAYER_STATS_SIZE);
		}
	}

	private void isPositiveNumber(List<Integer> playerStats) {
		playerStats.forEach(v -> {
			if (isNegative(v)) {
				throw new IllegalArgumentException(ExceptionMessage.PLAYER_STATS_NEGATIVE);
			}
		});
	}

	private boolean isNegative(Integer v) {
		return v < 0;
	}

	private void isLegalSumValue(List<Integer> playerStats) {
		Integer sumValue = playerStats.stream()
				.reduce(Integer::sum)
				.get();
		if (!sumValue.equals(GameOption.PLAYER_SUM_VALUE)) {
			throw new IllegalArgumentException(ExceptionMessage.PLAYER_STATS_SUM_VALUE);
		}
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

	public boolean isAlive() {
		return curHp > 0;
	}

	public String getName() {
		return name;
	}

	public int getStartHp() {
		return startHp;
	}

	public int getStartMp() {
		return startMp;
	}

	public int getCurHp() {
		return curHp;
	}

	public int getCurMp() {
		return curMp;
	}

	public int getAttackDamage() {
		if (attackType.equals(AttackType.MAGIC) && curMp < PLAYER_MAGIC_ATTACK_MP_COST) {
			return 0;
		}
		return attackType.getDamage();
	}

	public void handleCost() {
		if (attackType.equals(AttackType.PHYSICAL)) {
			this.curMp = Math.min(startMp, this.curMp + PLAYER_MP_RECOVER);
			return;
		}
		if (attackType.equals(AttackType.MAGIC)) {
			this.curMp = Math.max(PLAYER_MIN_MP, this.curMp - PLAYER_MAGIC_ATTACK_MP_COST);
			return;
		}
	}

	public void attacked(int attackDamage) {
		this.curHp = Math.max(PLAYER_MIN_HP, this.curHp - attackDamage);
	}

	public String getAttackTypeName() {
		return this.attackType.getTypeName();
	}
}
