package bossmonster.domain;

import static bossmonster.constant.PlayerConstant.*;
import static bossmonster.view.message.ErrorMessage.*;

import bossmonster.constant.PlayerConstant;

public class Player {
	String name;
	int maxHp;
	int maxMp;
	int nowHp;
	int nowMp;

	public Player(String name, int maxHp, int maxMp) {
		this.name = name;
		this.maxHp = maxHp;
		this.maxMp = maxMp;
		this.nowHp = this.maxHp;
		this.nowMp = this.maxMp;
		isValid();
	}

	public String getName() {
		return name;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public int getMaxMp() {
		return maxMp;
	}

	public int getNowHp() {
		return nowHp;
	}

	public int getNowMp() {
		return nowMp;
	}

	private void isValid() {
		if (name.length() > LENGTH_OF_NAME.getConstant())
			throw new IllegalArgumentException();
		if (maxHp + maxMp != SUM_OF_HP_MP.getConstant())
			throw new IllegalArgumentException();
	}

	public int createAttack(PlayerConstant attack) {
		if (attack == PHYSICAL_ATTACK) {
			modifyMpByAttack(10);
			return PHYSICAL_DAMAGE.getConstant();
		}

		modifyMpByAttack(-30);
		return MAGIC_DAMAGE.getConstant();
	}

	public void modifyMpByAttack(int difference) {
		if (nowMp + difference >= maxMp) {
			nowMp = maxMp;
			return;
		}
		if (nowMp + difference <= 0) {
			throw new IllegalArgumentException(MAGIC_ATTACK_CONSUME_MP.getMessage());
		}

		nowMp += difference;
	}

	public int getAttackByMonster(int damage) {
		if (nowHp <= damage) {
			int preHp = nowHp;
			nowHp = 0;
			return preHp;
		}

		nowHp -= damage;
		return damage;
	}
}
