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

		if (monster.getNowHp() <= damage) {
			damage -= monster.getNowHp();
			monster = new Monster(0);
			return damage;
		}

		monster = new Monster(monster.getNowHp() - damage);
		return damage;
	}

	public int attackByMonster() {
		int damage = monster.createAttack();

		if (player.getNowHp() <= damage) {
			damage -= player.getNowHp();
			player = new Player(player.getName(), 0, player.getMaxMp());
			return damage;
		}

		player = new Player(player.getName(), player.getNowHp() - damage, player.getMaxMp());
		return damage;
	}

	public boolean isEndGame() {
		return monster.getNowHp() <= 0 || player.getNowHp() <= 0;
	}
}
