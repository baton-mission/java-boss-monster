package bossmonster.domain;

import bossmonster.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

import static bossmonster.domain.GameOption.BOSS_DAMAGE_MAX_EXCLUSIVE;

public class Boss {
	private String name;
	private Point hp;
	private BossStatus status;

	public Boss(int hp) {
		validate(hp);
		this.name = "BOSS";
		this.hp = new Point(hp);
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
		return hp.isEqualOrMoreThen(GameOption.MIN_HP);
	}

	public void attacked(int damage) {
		handleBossStatus(damage > 0);
		hp.reduceAmount(damage);
	}

	private void handleBossStatus(boolean isAttacked) {
		if (isAttacked) {
			setStatus(BossStatus.ATTACKED);
			return;
		}
		setStatus(BossStatus.NORMAL);
	}

	public int attackPlayer() {
		return getAttackDamage();
	}

	private int getAttackDamage() {
		return (int) (Math.random() * BOSS_DAMAGE_MAX_EXCLUSIVE);
	}

	// TODO Setter 없애는 방향으로 리펙터링
	public void setStatus(BossStatus status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public List<Integer> getHp() {
		return new ArrayList<>(List.of(hp.getCurAmount(), hp.getStartAmount()));
	}

	public String getStatusImg() {
		return status.toString();
	}
}
