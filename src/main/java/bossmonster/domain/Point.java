package bossmonster.domain;

import bossmonster.ExceptionMessage;

public class Point {
	private int startAmount;
	private int curAmount;

	public Point(int amount) {
		isNegative(amount);
		this.startAmount = amount;
		this.curAmount = amount;
	}

	private void isNegative(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException(ExceptionMessage.PLAYER_STATS_NEGATIVE);
		}
	}

	public boolean isMoreTHen(int amount) {
		return curAmount > amount;
	}

	public boolean isEqualOrMoreThen(int amount) {
		return curAmount >= amount;
	}

	public boolean isLowerThen(int amount) {
		return this.curAmount < amount;
	}

	public void reduceAmount(int amount) {
		this.curAmount = Math.max(0, this.curAmount - amount);
	}

	public void addAmount(int amount) {
		this.curAmount = Math.min(this.startAmount, this.curAmount + amount);
	}

	public int getStartAmount() {
		return startAmount;
	}

	public int getCurAmount() {
		return curAmount;
	}
}
