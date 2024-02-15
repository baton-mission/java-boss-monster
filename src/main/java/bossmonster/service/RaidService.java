package bossmonster.service;

import static bossmonster.constant.PlayerConstant.*;
import static bossmonster.view.message.ErrorMessage.*;

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

	private int attackMonsterByPhysical() {
		int damage = PHYSICAL_DAMAGE.getConstant();
		return damage;
	}

	private int attackMonsterByMagic() {
		int damage = MAGIC_DAMAGE.getConstant();
		return damage;
	}

	public int attackByPlayer(PlayerConstant playerConstant) {
		if (playerConstant == PHYSICAL_ATTACK)
			return attackMonsterByPhysical();
		if (playerConstant == MAGIC_ATTACK)
			return attackMonsterByMagic();

		throw new IllegalArgumentException(PLAYER_SHOULD_ATTACK_MONSTER.getMessage());
	}

	public int attackByMonster() {
		int damage = 0;
		return damage;
	}

	public boolean isEndGame() {
		if (monster.getNowHp() <= 0 || player.getNowHp() <= 0)
			return true;
		return false;
	}
}
