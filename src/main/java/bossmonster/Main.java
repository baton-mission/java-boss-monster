package bossmonster;

import bossmonster.controller.BossMonsterGame;
import bossmonster.domain.RandomDamageGenerator;

public class Main {
	public static void main(String[] args) {
		BossMonsterGame bossMonsterGame = new BossMonsterGame(new RandomDamageGenerator());
		bossMonsterGame.startGame();
	}
}
