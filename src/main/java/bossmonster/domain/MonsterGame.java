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

    public void applyAttack(PlayerAttack playerAttack, Hp monsterAttack) {
        gameCharacters.applyAttack(playerAttack, monsterAttack);
        gameCount.increase();
    }
}
