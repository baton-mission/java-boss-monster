package bossmonster.dto;

public class PlayerDTO {
	String name;
	int nowHp;
	int nowMp;
	int maxHp;
	int maxMp;

	public PlayerDTO(String name, int nowHp, int nowMp, int maxHp, int maxMp) {
		this.name = name;
		this.nowHp = nowHp;
		this.nowMp = nowMp;
		this.maxHp = maxHp;
		this.maxMp = maxMp;
	}

	public String getName() {
		return name;
	}

	public int getNowHp() {
		return nowHp;
	}

	public int getNowMp() {
		return nowMp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public int getMaxMp() {
		return maxMp;
	}
}
