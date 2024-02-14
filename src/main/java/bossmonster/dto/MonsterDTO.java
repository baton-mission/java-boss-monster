package bossmonster.dto;

public class MonsterDTO {
	int nowHp;
	int maxHp;

	public MonsterDTO(int nowHp, int maxHp) {
		this.nowHp = nowHp;
		this.maxHp = maxHp;
	}

	public int getNowHp() {
		return nowHp;
	}

	public int getMaxHp() {
		return maxHp;
	}
}
