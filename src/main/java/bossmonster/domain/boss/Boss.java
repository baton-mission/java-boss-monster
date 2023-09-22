package bossmonster.domain.boss;

import bossmonster.message.ExceptionMessage;
import bossmonster.domain.GameOption;
import bossmonster.domain.Point;

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
		isLegalHpRange(hp);
	}

	private void isLegalHpRange(int hp) {
		if (hp < GameOption.BOSS_HP_MIN_INCLUSIVE ||
				hp > GameOption.BOSS_HP_MAX_INCLUSIVE) {
			throw new IllegalArgumentException(ExceptionMessage.BOSS_HP_RANGE);
		}
	}

	public boolean isAlive() {
		return hp.isEqualOrMoreThen(GameOption.MIN_HP);
	}

	public void attacked(int damage) {
		handleBossStatus(damage > 0, false);
		hp.reduceAmount(damage);
	}

	public void handleBossStatus(boolean isAttacked, boolean isVictory) {
		if (isVictory) {
			status = BossStatus.VICTORY;
			return;
		}
		if (isAttacked) {
			status = BossStatus.ATTACKED;
			return;
		}
		status = BossStatus.NORMAL;
	}

	public int attackPlayer() {
		return getAttackDamage();
	}

	private int getAttackDamage() {
		return (int) (Math.random() * BOSS_DAMAGE_MAX_EXCLUSIVE);
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
