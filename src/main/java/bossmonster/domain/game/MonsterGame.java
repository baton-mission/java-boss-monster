package bossmonster.domain.game;

import bossmonster.domain.Hp;
import bossmonster.domain.PlayerAttack;

public class MonsterGame {
    private final GameCharacters gameCharacters;
    private final GameCount gameCount;

    public MonsterGame(GameCharacters gameCharacters, GameCount gameCount) {
        this.gameCharacters = gameCharacters;
        this.gameCount = gameCount;
    }

    public static MonsterGame init(GameCharacters gameCharacters) {
        return new MonsterGame(gameCharacters, GameCount.init());
    }

    public boolean isPlayerOver() {
        return gameCharacters.isPlayerOver();
    }

    public void applyPlayerAttack(PlayerAttack playerAttack) {
        gameCharacters.applyPlayerAttack(playerAttack);
        gameCount.increase();
    }

    public void applyMonsterAttack(Hp monsterAttack) {
        if (!gameCharacters.isMonsterOver()) {
            gameCharacters.applyMonsterAttack(monsterAttack);
        }
    }

    public boolean isMonsterOver() {
        return gameCharacters.isMonsterOver();
    }

    public boolean isAnyCharacterOver() {
        return gameCharacters.isMonsterOver() || gameCharacters.isPlayerOver();
    }

    public GameCount getGameCount() {
        return gameCount;
    }

    public GameCharacters getGameCharacters() {
        return gameCharacters;
    }
}
