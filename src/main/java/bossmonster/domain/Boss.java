package bossmonster.domain;

import bossmonster.ExceptionMessage;

public class Boss {
	private String name;
	private int startHp;
	private int startMp;
	private int curHp;
	private int curMp;
	private BossStatus status;

	public Boss(int hp) {
		validate(hp);
		this.name = "BOSS";
		this.startHp = hp;
		this.startMp = hp;
		this.curHp = hp;
		this.curMp = hp;
		this.status = BossStatus.NORMAL;
	}

	private void validate(int hp) {
		isInRange(hp);
	}

	private void isInRange(int hp) {
		if (hp < GameOption.BOSS_HP_MIN_INCLUSIVE ||
				hp > GameOption.BOSS_HP_MAX_INCLUSIVE) {
			throw new IllegalArgumentException(ExceptionMessage.BOSS_HP_RANGE);
		}
	}

	public boolean isAlive() {
		return curHp > 0;
	}

	public void attacked(int damage) {
		handleBossStatus(damage > 0);
		this.curHp = Math.max(curHp - damage, 0);
	}

	private void handleBossStatus(boolean isAttacked) {
		if (isAttacked) {
			setStatus(BossStatus.ATTACKED);
			return;
		}
		setStatus(BossStatus.NORMAL);
	}

	public void setStatus(BossStatus status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public int getCurHp() {
		return curHp;
	}

	public int getStartHp() {
		return startHp;
	}

	public String getStatusImg() {
		return status.toString();
	}

	public int attackPlayer() {
		return getAttackDamage();
	}

	private int getAttackDamage() {
		return (int) (Math.random() * 21);
	}
}
