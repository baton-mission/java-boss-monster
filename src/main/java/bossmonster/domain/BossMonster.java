package bossmonster.domain;

public class BossMonster {

	private final Hp hp;

	public BossMonster(Hp hp) {
		validateHpRange(hp);
		this.hp = hp;
	}

	private void validateHpRange(Hp hp) {
		if (hp.validateBossHpRange()) {
			throw new IllegalArgumentException("[ERROR] 보스 몬스터의 초기 HP는 100이상 300이하 입니다.");
		}
	}
}
