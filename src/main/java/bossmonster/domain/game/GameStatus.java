package bossmonster.domain.game;

public enum GameStatus {

    INIT("       ^-^\n"
            + "     / 0 0 \\\n"
            + "    (   \"   )\n"
            + "     \\  -  /\n"
            + "      - ^ -"),  //게임의 상태에 따라서 출력값이 달라진다. 게임상태를 표현하는게 주목적이다.
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
