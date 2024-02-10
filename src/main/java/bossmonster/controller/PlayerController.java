package bossmonster.controller;

import bossmonster.domain.Player;

public class PlayerController {
    private static final int MP_PLUS = 10;

    public Player hit(Player player, int damage){
        if(player.getHp() <= damage){
            return new Player(0, player.getMp(), player);
        }
        return new Player(player.getHp()-damage, player.getInitMp(), player);
    }

    public Player recover(Player player){
        int mp = player.getMp() + MP_PLUS;
        if(mp > player.getInitMp()){
            mp = player.getInitMp();
        }
        return new Player(player.getHp(), mp, player);
    }

    public boolean die(Player player){
        return player.getHp() == 0;
    }
}
