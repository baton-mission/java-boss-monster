package bossmonster.view.message;

public enum OutputMessage {
	RAID_INIT_MESSAGE("보스 레이드를 시작합니다!"),
	MONSTER_INIT_MESSAGE("   ^-^\n / 0 0 \\\n(   \"   )\n \\  -  /\n  - ^ -"),
	MONSTER_ATTACKED_MESSAGE("   ^-^\n / x x \\\n(   \"\\  )\n \\  ^  /\n  - ^ -"),
	MONSTER_WIN_MESSAGE("   ^-^\n / ^ ^ \\\n(   \"   )\n \\  3  /\n  - ^ -"),
	MONSTER_HP_MESSAGE("BOSS HP [%d/%d]"),
	PLAYER_HP_MP_MESSAGE("%s HP [%d/%d] MP [%d/%d]"),
	DASH_MESSAGE("____________________________"),
	DOUBLE_DASH_MESSAGE("============================"),
	PLAYER_ATTACK_MESSAGE("%s을 했습니다. (입힌 데미지: %d)"),
	MONSTER_ATTACK_MESSAGE("보스가 공격 했습니다. (입힌 데미지: %s)"),
	RAID_SUCCESS_MESSAGE("%s 님이 6번의 전투 끝에 보스 몬스터를 잡았습니다."),
	RAID_FAIL_MESSAGE("%s의 HP가 0이 되었습니다.\n"
		+ "보스 레이드에 실패했습니다.");

	private final String message;

	OutputMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
