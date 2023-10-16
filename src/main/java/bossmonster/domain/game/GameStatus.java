package bossmonster.domain.game;

public enum GameStatus {

    INIT("       ^-^\n"
            + "     / 0 0 \\\n"
            + "    (   \"   )\n"
            + "     \\  -  /\n"
            + "      - ^ -"),
    PLAY("       ^-^\n"
            + "     / x x \\\n"
            + "    (   \"   )\n"
            + "     \\  -  /\n"
            + "      - ^ -"),
    END("       ^-^\n"
            + "     / ^ ^ \\\n"
            + "    (   \"   )\n"
            + "     \\  -  /\n"
            + "      - ^ -");

    String character;

    GameStatus(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }
}
