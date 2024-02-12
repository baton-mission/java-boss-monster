package bossmonster.view;

import static bossmonster.view.message.InputMessage.*;
import static bossmonster.view.message.OutputMessage.*;

import bossmonster.view.message.MagicMessage;

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

	public static void printMonsterHp(int monsterNowHp, int monsterMaxHp) {
		System.out.printf(MONSTER_HP.getMessage(), monsterNowHp, monsterMaxHp);
		System.out.println();
	}

	private static void printPlayerHpMp(String playerName, int playerMaxHp, int playerMaxMp) {
		System.out.printf(PLAYER_HP_MP_MESSAGE.getMessage(), playerName, playerMaxHp, playerMaxMp);
		System.out.println();
	}

	public static void printStartGame(int monsterMaxHp, String playerName, int playerMaxHp, int playerMaxMp) {
		System.out.println(RAID_INIT_MESSAGE.getMessage());
		System.out.println(DOUBLE_DASH_MESSAGE.getMessage());
		printMonsterHp(monsterMaxHp, monsterMaxHp);
		System.out.println(DASH_MESSAGE.getMessage());
		System.out.println(MONSTER_INIT_MESSAGE.getMessage());
		System.out.println(DASH_MESSAGE.getMessage());
		printPlayerHpMp(playerName, playerMaxHp, playerMaxMp);
	}

	public static void printPlayerAttack(MagicMessage attack, int playerAttack) {
		System.out.printf(PLAYER_ATTACK_MESSAGE.getMessage(), attack.getAttackString(), playerAttack);
		System.out.println();
	}

	public static void printMonsterAttack(int monsterAttack) {
		System.out.printf(MONSTER_ATTACK_MESSAGE.getMessage(), monsterAttack);
		System.out.println();
	}

	public static void printProgressGame(int monsterNowHp, int monsterMaxHp, String playerName, int playerMaxHp, int playerNowHp,
		int playerMaxMp, int playerNowMp) {
		System.out.println(DOUBLE_DASH_MESSAGE.getMessage());
		printMonsterHp(monsterNowHp, monsterMaxHp);
		System.out.println(DASH_MESSAGE.getMessage());
		System.out.println(MONSTER_ATTACKED_MESSAGE.getMessage());
		System.out.println(DASH_MESSAGE.getMessage());
		printPlayerHpMp(playerName, playerMaxHp, playerMaxMp);
	}

	public static void printRaidSuccess(int playerName, int raidRound) {
		System.out.printf(RAID_SUCCESS_MESSAGE.getMessage(), playerName, raidRound);
	}

	public static void printRaidFail(int playerName) {
		System.out.printf(RAID_FAIL_MESSAGE.getMessage(), playerName);
	}
}
