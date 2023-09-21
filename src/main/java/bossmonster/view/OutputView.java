package bossmonster.view;

import bossmonster.ExceptionMessage;

public class OutputView {
	public static void printError(IllegalArgumentException e) {
		System.out.println(ExceptionMessage.ERROR_PREFIX + e.getMessage());
	}
}
