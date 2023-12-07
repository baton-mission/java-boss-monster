package bossmonster.domain;

public class MonsterGame {
    private final GameCharacters gameCharacters;
    private final GameCount gameCount;
    private final boolean gameOver;

    public MonsterGame(GameCharacters gameCharacters, GameCount gameCount, boolean gameOver) {
        this.gameCharacters = gameCharacters;
        this.gameCount = gameCount;
        this.gameOver = gameOver;
    }

    public static MonsterGame from(GameCharacters gameCharacters) {
        return new MonsterGame(gameCharacters, GameCount.init(), false);
    }

    public boolean isPlayerOver() {
        return gameCharacters.isPlayerOver();
    }

    public void applyPlayerAttack(PlayerAttack playerAttack) {
        gameCharacters.applyPlayerAttack(playerAttack);
        gameCount.increase();
    }

    public void applyMonsterAttack(Hp monsterAttack) {
        gameCharacters.applyMonsterAttack(monsterAttack);
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
