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
		return readValidatedString();
	}

	public static String readPlayerName() {
		System.out.println(Message.READ_PLAYER_NAME);
		return readValidatedString();
	}

	public static String readPlayerInfo() {
		System.out.println(Message.READ_PLAYER_HP_MP);
		return readValidatedString();
	}

	private static String readValidatedString() {
		String inputValue = readValueWithoutCheckError();
		isBlank(inputValue);
		return inputValue;
	}

	private static String readValueWithoutCheckError() {
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
