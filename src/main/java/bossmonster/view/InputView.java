package bossmonster.view;

import bossmonster.ExceptionMessage;
import bossmonster.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static String readBossHp() {
		System.out.println(Message.READ_BOSS_HP);
		return getValidatedString();
	}

	public static String readPlayerName() {
		System.out.println(Message.READ_PLAYER_NAME);
		return getValidatedString();
	}

	public static String readPlayerInfo() {
		System.out.println(Message.READ_PLAYER_HP_MP);
		return getValidatedString();
	}

	public static String readAttackType() {
		System.out.println(Message.READ_ATTACK_TYPE);
		return getValidatedString();
	}

	private static String getValidatedString() {
		String inputValue = getValueWithoutCheckError();
		isBlank(inputValue);
		return inputValue;
	}

	private static String getValueWithoutCheckError() {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new IllegalArgumentException(ExceptionMessage.IO_EXCEPTION);
		}
	}

	private static void isBlank(String value) {
		if (value.isBlank()) {
			throw new IllegalArgumentException(ExceptionMessage.BLANK);
		}
	}



}
