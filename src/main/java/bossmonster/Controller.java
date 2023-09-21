package bossmonster;

import bossmonster.domain.Boss;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class Controller {
	public void run() {
		Boss boss = initBoss();
	}

	private Boss initBoss() {
		try {
			int bossHp = Converter.stringToInt(InputView.readBossHp());
			return new Boss(bossHp);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			return initBoss();
		}
	}
}
