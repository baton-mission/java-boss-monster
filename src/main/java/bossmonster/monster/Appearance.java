package bossmonster.monster;

public enum Appearance {

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

    private String appearance;

    Appearance(String appearance) {
        this.appearance = appearance;
    }
}
