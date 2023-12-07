package bossmonster.view.formatter;

import bossmonster.common.Symbol;
import bossmonster.domain.GameCharacters;

public class OutputFomatter {
    public static final String WINNERS_SEPARATOR = Symbol.COMMA;

    public static int toCurrentMonsterHp(GameCharacters gameCharacters) {
        return gameCharacters.getMonster().getCurrentHp().getHp();
    }

    public static int toTotalMonsterHp(GameCharacters gameCharacters) {
        return gameCharacters.getMonster().getTotalHp().getHp();
    }

    public static String toPlayerName(GameCharacters gameCharacters) {
        return gameCharacters.getPlayer().getPlayerName().getPlayerName();
    }

    public static int toCurrentPlayerHp(GameCharacters gameCharacters) {
        return gameCharacters.getPlayer().getPlayerVital().getCurrentHp().getHp();
    }

    public static int toTotalPlayerHp(GameCharacters gameCharacters) {
        return gameCharacters.getPlayer().getPlayerVital().getTotalHp().getHp();
    }

    public static int toCurrentPlayerMp(GameCharacters gameCharacters) {
        return gameCharacters.getPlayer().getPlayerVital().getCurrentMp().getMp();
    }

    public static int toTotalPlayerMp(GameCharacters gameCharacters) {
        return gameCharacters.getPlayer().getPlayerVital().getTotalMp().getMp();
    }
}
