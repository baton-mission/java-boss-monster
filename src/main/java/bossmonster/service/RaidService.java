package bossmonster.service;

import bossmonster.constant.PlayerConstant;
import bossmonster.domain.Monster;
import bossmonster.domain.Player;
import bossmonster.dto.MonsterDTO;
import bossmonster.dto.PlayerDTO;

public class RaidService {
	private static Monster monster;
	private static Player player;

	public RaidService() {
	}

	public static MonsterDTO getMonsterDTO() {
		return new MonsterDTO(monster.getNowHp(), monster.getMaxHp());
	}

	public static PlayerDTO getPlayerDTO() {
		return new PlayerDTO(player.getName(), player.getNowHp(), player.getNowMp(),
			player.getMaxHp(), player.getMaxMp());
	}

	public void createMonster(int monsterHp) {
		monster = new Monster(monsterHp);
	}

	public void createPlayer(String playerName, int playerHp, int playerMp) {
		player = new Player(playerName, playerHp, playerMp);
	}

	public int attackByPlayer(PlayerConstant playerConstant) {
		int damage = player.createAttack(playerConstant);

		return monster.getAttackByPlayer(damage);
	}

	public int attackByMonster() {
		int damage = monster.createAttack();

		return player.getAttackByMonster(damage);
	}

	public boolean isEndGame() {
		return monster.getNowHp() <= 0 || player.getNowHp() <= 0;
	}
}
