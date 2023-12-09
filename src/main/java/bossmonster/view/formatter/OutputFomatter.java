package bossmonster.view.formatter;

import bossmonster.domain.game.GameCharacters;
import bossmonster.domain.Hp;
import bossmonster.domain.game.MonsterGame;
import bossmonster.domain.PlayerAttack;

public class OutputFomatter {
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

    public static int toGameCount(MonsterGame monsterGame) {
        return monsterGame.getGameCount().getGameCount();
    }

    public static String toPlayerAttack(PlayerAttack playerAttack) {
        return playerAttack.getMessage();
    }

    public static int toPlayerAttackDamage(PlayerAttack playerAttack) {
        return playerAttack.getHpDamage();
    }

    public static int toMonsterAttackDamage(Hp monsterAttack) {
        return monsterAttack.getHp();
    }

    public static String toPlayerName(MonsterGame monsterGame) {
        return monsterGame.getGameCharacters().getPlayer().getPlayerName().getPlayerName();
    }
}
