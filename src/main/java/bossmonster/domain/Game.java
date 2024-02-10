package bossmonster.domain;

public class Game {

    private final BossMonster bossMonster;
    private final Player player;

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
}
