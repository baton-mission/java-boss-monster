package bossmonster.view;

import static bossmonster.view.message.InputMessage.*;
import static bossmonster.view.message.OutputMessage.*;

import bossmonster.constant.AttackConstant;
import bossmonster.dto.MonsterDTO;
import bossmonster.dto.PlayerDTO;

public class OutputView {
	public static void printInputMonsterHp() {
		System.out.println(MONSTER_HP.getMessage());
	}

	public static void printInputPlayerName() {
		System.out.println(PLAYER_NAME.getMessage());
	}

	public static void printInputPlayerHpMp() {
		System.out.println(PLAYER_HP_MP.getMessage());
	}

	public static void printInputWhetherAttack() {
		System.out.println(DOUBLE_DASH_MESSAGE.getMessage());
		System.out.println(WHETHER_PHYSICAL_OR_MAGIC.getMessage());
	}

	public static void printMonsterHp(MonsterDTO monsterDTO) {
		System.out.printf(MONSTER_HP_MESSAGE.getMessage(), monsterDTO.getNowHp(), monsterDTO.getMaxHp());
		System.out.println();
	}

	private static void printPlayerHpMp(PlayerDTO playerDTO) {
		System.out.printf(PLAYER_HP_MP_MESSAGE.getMessage(), playerDTO.getName(), playerDTO.getNowHp(),
			playerDTO.getMaxHp(), playerDTO.getNowMp(), playerDTO.getMaxMp());
		System.out.println();
	}

	public static void printStartGame(MonsterDTO monsterDTO, PlayerDTO playerDTO) {
		System.out.println(RAID_INIT_MESSAGE.getMessage());
		System.out.println(DOUBLE_DASH_MESSAGE.getMessage());
		printMonsterHp(monsterDTO);
		System.out.println(DASH_MESSAGE.getMessage());
		System.out.println(MONSTER_INIT_MESSAGE.getMessage());
		System.out.println(DASH_MESSAGE.getMessage());
		printPlayerHpMp(playerDTO);
	}

	public static void printPlayerAttack(AttackConstant attack, int playerAttack) {
		System.out.printf(PLAYER_ATTACK_MESSAGE.getMessage(), attack.getAttackString(), playerAttack);
		System.out.println();
	}

	public static void printMonsterAttack(int monsterAttack) {
		System.out.printf(MONSTER_ATTACK_MESSAGE.getMessage(), monsterAttack);
		System.out.println();
	}

	public static void printProgressGame(MonsterDTO monsterDTO, PlayerDTO playerDTO) {
		System.out.println(DOUBLE_DASH_MESSAGE.getMessage());
		printMonsterHp(monsterDTO);
		System.out.println(DASH_MESSAGE.getMessage());
		System.out.println(MONSTER_ATTACKED_MESSAGE.getMessage());
		System.out.println(DASH_MESSAGE.getMessage());
		printPlayerHpMp(playerDTO);
	}

	public static void printRaidSuccess(String playerName, int raidRound) {
		System.out.printf(RAID_SUCCESS_MESSAGE.getMessage(), playerName, raidRound);
	}

	public static void printRaidFail(String playerName) {
		System.out.printf(RAID_FAIL_MESSAGE.getMessage(), playerName);
	}

	public static void printErrorMessage(String errorMessage) {
		System.out.println(errorMessage);
	}
}
