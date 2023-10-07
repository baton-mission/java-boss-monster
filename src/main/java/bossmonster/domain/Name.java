package bossmonster.domain;

import bossmonster.util.ErrorChecker;

public record Name(String name) {

    public Name {
        ErrorChecker.checkName(name);
    }
}
