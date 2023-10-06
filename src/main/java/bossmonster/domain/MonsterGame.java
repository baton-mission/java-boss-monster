package bossmonster.domain;

public class MonsterGame {

    private GameStatus gameStatus;
    private int matchCount;
    private Monster monster;

    private Player player;

    public MonsterGame(Monster monster, Player player) {
        this.gameStatus = GameStatus.RUN;
        this.matchCount = 0;
        this.monster = monster;
        this.player = player;
    }

    public void proceedPlayerTurn(Skill skill) {
        if (player.isAlive()) {
            player.takeDamage(skill, monster);
        }
    }

    public void proceedMonsterTurn(int damage) {
        if (monster.isAlive()) {
            monster.takeDamage(damage, player);
        }
    }

    public GameResult getGameResult() {
        if(player.isAlive()) {
            return GameResult.WIN;
        }
        return GameResult.LOSE;
    }

    private String findWinnerName() {
        if(player.isAlive()) {
            return player.getName();
        }
        return "monster";
    }

    public boolean isGameInProgress() {
        return gameStatus.isRunning();
    }

    public void updateGame() {
        updateMatchCount();
        updateGameStatus();
    }

    private void updateMatchCount() {
        matchCount++;
    }

    private void updateGameStatus() {
        if (player.isDead() || monster.isDead()) {
            gameStatus = GameStatus.STOP;
        }
    }
}
