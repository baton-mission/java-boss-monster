package bossmonster.Domain;

public class Game {
    private int turn;
    private Boss boss;
    private Player player;

    public Game(int turn, Boss boss, Player player) {
        this.turn = turn;
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
