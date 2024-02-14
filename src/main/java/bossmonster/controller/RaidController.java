package bossmonster.controller;

import static bossmonster.constant.MonsterConstant.*;
import static bossmonster.constant.PlayerConstant.*;
import static bossmonster.view.message.ErrorMessage.*;

import java.util.List;

import bossmonster.service.RaidService;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class RaidController {
	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();
	private static RaidService raidService;

	public RaidController() {
		raidService = new RaidService();
		setInitStatus();
	}

	private static int inputMonsterHp() {
		int monsterHp = inputView.readMonsterHp();
		if (monsterHp < MONSTER_MIN_HP.getMonsterConstant()
			|| monsterHp > MONSTER_MAX_HP.getMonsterConstant()) {
			throw new IllegalArgumentException();
		}
		return monsterHp;
	}

	private static String inputPlayerName() {
		String name = inputView.readPlayerName();

		if (name.length() > LENGTH_OF_NAME.getConstant()) {
			throw new IllegalArgumentException();
		}
		return name;
	}

	private static List<Integer> inputPlayerHpMp() {
		List<Integer> playerHpMp = inputView.readPlayerHpMp();

		if (playerHpMp.size() != COUNT_OF_HP_MP.getConstant())
			throw new IllegalArgumentException();
		if (playerHpMp.stream().mapToInt(Integer::valueOf).sum() != SUM_OF_HP_MP.getConstant())
			throw new IllegalArgumentException();

		return playerHpMp;
	}

	private void setInitStatus() {
		int monsterHp = setMonsterHp();
		String playerName = setPlayerName();
		List<Integer> playerHpMp = setPlayerHpMp();

		raidService.createMonster(monsterHp);
		raidService.createPlayer(playerName, playerHpMp.get(0), playerHpMp.get(1));
	}

	private int setMonsterHp() {
		outputView.printInputMonsterHp();

		while (true) {
			try {
				return inputMonsterHp();
			} catch (NumberFormatException e) {
				outputView.printErrorMessage(MUST_INTEGER_BUT_NOT);
			} catch (IllegalArgumentException e) {
				outputView.printErrorMessage(MONSTER_HP_MORE_THAN_100_LESS_THAN_300);
			}
		}
	}

	private String setPlayerName() {
		outputView.printInputPlayerName();

		while (true) {
			try {
				return inputPlayerName();
			} catch (IllegalArgumentException e) {
				outputView.printErrorMessage(PLAYER_NAME_LENGTH_LESS_THAN_5_WORDS);
			}
		}
	}

	private List<Integer> setPlayerHpMp() {
		outputView.printInputPlayerHpMp();

		while (true) {
			try {
				return inputPlayerHpMp();
			} catch (NumberFormatException e) {
				outputView.printErrorMessage(MUST_INTEGER_BUT_NOT);
			} catch (IllegalArgumentException e) {
				outputView.printErrorMessage(SUM_OF_PLAYER_HP_AND_MP_IS_200);
			}
		}
	}

	public void playGame() {
	}
}
