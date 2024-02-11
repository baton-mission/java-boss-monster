package bossmonster.domain;

public class Game {

    private final BossMonster bossMonster;
    private final Player player;
    private static int numberOfTimes = 0;

    public Game(final BossMonster bossMonster, final Player player){
        this.bossMonster = bossMonster;
        this.player = player;
    }

    public BossMonster getBossMonster(){
        return bossMonster;
    }

    public Player getPlayer(){
        return player;
    }

    public void addNumberOfTimes(){
        numberOfTimes++;
    }

    public int getNumberOfTimes(){
        return numberOfTimes;
    }
}
