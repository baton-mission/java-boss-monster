package bossmonster.Domain;

public class Game {
    private int turn;
    private Boss boss;
    private Player player;

    public Game(Boss boss, Player player) {
        this.turn = 0;
        this.boss = boss;
        this.player = player;
    }

    public int getTurn() {
        return turn;
    }

    public Boss getBoss() {
        return boss;
    }

    public Player getPlayer() {
        return player;
    }

    public void increaseTurn() {
        turn++;
    }
}
