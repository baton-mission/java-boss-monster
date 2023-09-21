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
		return startHp > 0;
	}
}
