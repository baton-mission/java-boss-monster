package bossmonster.controller;

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

	private void setInitStatus() {
	}

	public void playGame() {
	}
}
