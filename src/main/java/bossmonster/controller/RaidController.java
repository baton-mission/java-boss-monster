package bossmonster.controller;

import static bossmonster.constant.MonsterConstant.*;
import static bossmonster.constant.PlayerConstant.*;
import static bossmonster.view.message.ErrorMessage.*;

import java.util.List;

import bossmonster.dto.MonsterDTO;
import bossmonster.dto.PlayerDTO;
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
			throw new IllegalArgumentException(MONSTER_HP_MORE_THAN_100_LESS_THAN_300.getMessage());
		}
		return monsterHp;
	}

	private static String inputPlayerName() {
		String name = inputView.readPlayerName();

		if (name.length() > LENGTH_OF_NAME.getConstant()) {
			throw new IllegalArgumentException(PLAYER_NAME_LENGTH_LESS_THAN_5_WORDS.getMessage());
		}
		return name;
	}

	private static List<Integer> inputPlayerHpMp() {
		List<Integer> playerHpMp = inputView.readPlayerHpMp();

		if (playerHpMp.size() != COUNT_OF_HP_MP.getConstant())
			throw new IllegalArgumentException(COUNT_OF_PLAYER_HP_AND_MP_IS_2.getMessage());
		if (playerHpMp.stream().anyMatch(i -> i < 0))
			throw new IllegalArgumentException(MUST_POSITIVE_BUT_NOT.getMessage());
		if (playerHpMp.stream().mapToInt(Integer::valueOf).sum() != SUM_OF_HP_MP.getConstant())
			throw new IllegalArgumentException(SUM_OF_PLAYER_HP_AND_MP_IS_200.getMessage());

		return playerHpMp;
	}

	private static int inputWhetherAttack() {
		int whetherAttack = inputView.readWhetherAttack();

		if (whetherAttack == PHYSICAL_ATTACK.getConstant() || whetherAttack == MAGIC_ATTACK.getConstant())
			return whetherAttack;

		throw new IllegalArgumentException(PLAYER_SHOULD_ATTACK_MONSTER.getMessage());
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
				throw new IllegalArgumentException(MUST_INTEGER_BUT_NOT.getMessage());
			} catch (IllegalArgumentException e) {
				outputView.printErrorMessage(e.getMessage());
			}
		}
	}

	private String setPlayerName() {
		outputView.printInputPlayerName();

		while (true) {
			try {
				return inputPlayerName();
			} catch (IllegalArgumentException e) {
				outputView.printErrorMessage(e.getMessage());
			}
		}
	}

	private List<Integer> setPlayerHpMp() {
		outputView.printInputPlayerHpMp();

		while (true) {
			try {
				return inputPlayerHpMp();
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(MUST_INTEGER_BUT_NOT.getMessage());
			} catch (IllegalArgumentException e) {
				outputView.printErrorMessage(e.getMessage());
			}
		}
	}

	private int setAttack() {
		outputView.printInputWhetherAttack();

		while (true) {
			try {
				return inputWhetherAttack();
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(MUST_INTEGER_BUT_NOT.getMessage());
			} catch (IllegalArgumentException e) {
				outputView.printErrorMessage(e.getMessage());
			}
		}
	}

	public void playGame() {
		outputView.printStartGame(raidService.getMonsterDTO(), raidService.getPlayerDTO());

		int gameRound = 0;
		do {
			++gameRound;
			if (!isAblePlayerAttack() || !isAbleMonsterAttack()) {
				break;
			}
			MonsterDTO monsterDTO = raidService.getMonsterDTO();
			PlayerDTO playerDTO = raidService.getPlayerDTO();
			outputView.printProgressGame(monsterDTO, playerDTO);
		} while (true);

		printEndGame(gameRound);
	}

	private boolean isAblePlayerAttack() {
		if (raidService.getPlayerDTO().getNowHp() == 0)
			return false;

		attackMonster();
		return true;
	}

	private boolean isAbleMonsterAttack() {
		if (raidService.getMonsterDTO().getNowHp() == 0)
			return false;

		attackPlayer();
		return true;
	}

	private void attackMonster() {
		int attack = setAttack();

		if (attack == PHYSICAL_ATTACK.getConstant()) {
			int damage = raidService.attackByPlayer(PHYSICAL_ATTACK);
			outputView.printPlayerPhysicalAttack(damage);
		}
		if (attack == MAGIC_ATTACK.getConstant()) {
			int damage = raidService.attackByPlayer(MAGIC_ATTACK);
			outputView.printPlayerMagicalAttack(damage);
		}
	}

	private void attackPlayer() {
		int damage = raidService.attackByMonster();
		outputView.printMonsterAttack(damage);
	}

	private void printEndGame(int raidRound) {
		MonsterDTO monsterDTO = raidService.getMonsterDTO();
		PlayerDTO playerDTO = raidService.getPlayerDTO();
		if (monsterDTO.getNowHp() == 0) {
			outputView.printRaidSuccess(playerDTO.getName(), raidRound);
		}

		if (playerDTO.getNowHp() == 0) {
			outputView.printRaidFail(playerDTO.getName());
		}
	}
}
