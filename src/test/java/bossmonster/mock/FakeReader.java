package bossmonster.mock;

import bossmonster.view.reader.Reader;

public class FakeReader implements Reader {
    private final String input;

    public FakeReader(String input) {
        this.input = input;
    }

    @Override
    public String readLine() {
        return input;
    }
}
