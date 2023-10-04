package bossmonster.domain.monster;

public enum BossMonsterAppearance {

    DEFAULT("   ^-^\n" +
            " / 0 0 \\\n" +
            "(   \"   )\n" +
            " \\  -  /\n" +
            "  - ^ -"),
    HAPPY("   ^-^\n" +
          " / ^ ^ \\\n" +
          "(   \"   )\n" +
          " \\  3  /\n" +
          "  - ^ -"),
    SICK("   ^-^\n" +
         " / x x \\\n" +
         "(   \"\\  )\n" +
         " \\  ^  /\n" +
         "  - ^ -\n");

    private final String appearance;

    BossMonsterAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getAppearance() {
        return appearance;
    }
}
