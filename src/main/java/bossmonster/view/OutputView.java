package bossmonster.view;

import bossmonster.ExceptionMessage;
import bossmonster.Message;

public class OutputView {
	public static void printError(IllegalArgumentException e) {
		System.out.println(ExceptionMessage.ERROR_PREFIX + e.getMessage());
	}

	public static void printRadeStart() {
		System.out.println(Message.START_RADE);
	}
}
