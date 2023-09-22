package bossmonster.domain;

public class Health {

	private int hp;
	private int mp;

	public Health(int hp, int mp) {
		this.hp = hp;
		this.mp = mp;
	}

	public boolean validateBossHpRange() {
		return hp < 100 || hp > 300;
	}

	public boolean validatePlayerHpAndMp() {
		return (hp + mp) != 200;
	}

	public boolean isHpZero() {
		return hp <= 0;
	}

	public void spendHp(int damage) {
		hp -= damage;
	}

	public void spendHp(AttackType attackType) {
		hp -= attackType.getDamage();
	}

	public void calculateMp(AttackType attackType) {
		if (attackType.equals(AttackType.PHYSICAL)) {
			mp += attackType.getEffect();
		}
		if (attackType.equals(AttackType.MAGIC)) {
			mp -= attackType.getEffect();
		}
	}

	public int getHp() {
		return hp;
	}

	public int getMp() {
		return mp;
	}
}
