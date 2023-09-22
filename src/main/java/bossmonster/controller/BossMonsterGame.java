package bossmonster.controller;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.view.InputView;

public class BossMonsterGame {

	private BossMonster inputBossHp() {
		int bossHp = InputView.readBossHp();
		return new BossMonster(bossHp);
	}

	private Player inputPlayer() {
		String playerName = InputView.readPlayer();
		return new Player(playerName);
	}
}
