package bossmonster.domain;

public class BossMonster {

	private int hp;

	public BossMonster(int hp) {
		validateHpRange(hp);
		this.hp = hp;
	}

	private void validateHpRange(int hp) {
		if (hp < 100 || hp > 300) {
			throw new IllegalArgumentException("[ERROR] 보스 몬스터의 초기 HP는 100이상 300이하 입니다.");
		}
	}
}
