package bossmonster.controller;

import bossmonster.domain.BossMonster;
import bossmonster.view.InputView;

public class BossMonsterGame {

	private BossMonster inputBossHp() {
		int bossHp = InputView.readBossHp();
		return new BossMonster(bossHp);
	}
}
