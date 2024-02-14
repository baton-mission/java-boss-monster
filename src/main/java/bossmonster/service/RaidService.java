package bossmonster.service;

import bossmonster.domain.Monster;
import bossmonster.domain.Player;

public class RaidService {
	private static Monster monster;
	private static Player player;

	public RaidService() {
	}

	public void createMonster(int monsterHp) {
		monster = new Monster(monsterHp);
	}

	public void createPlayer(String playerName, int playerHp, int playerMp) {
		player = new Player(playerName, playerHp, playerMp);
	}
}
