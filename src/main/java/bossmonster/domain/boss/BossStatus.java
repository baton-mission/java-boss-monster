package bossmonster.domain.boss;

public enum BossStatus {
	NORMAL(0, "   ^-^\n" +
			" / 0 0 \\\n" +
			"(   \"   )\n" +
			" \\  -  /\n" +
			"  - ^ -"),
	ATTACKED(1, "   ^-^\n" +
			" / x x \\\n" +
			"(   \"\\  )\n" +
			" \\  ^  /\n" +
			"  - ^ -"),
	VICTORY(2, "   ^-^\n" +
			" / ^ ^ \\\n" +
			"(   \"   )\n" +
			" \\  3  /\n" +
			"  - ^ -");

	private final int status;
	private final String img;

	BossStatus(int status, String img) {
		this.status = status;
		this.img = img;
	}

	@Override
	public String toString() {
		return this.img;
	}
}
