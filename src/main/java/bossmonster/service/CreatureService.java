package bossmonster.service;

import bossmonster.domain.creatures.Boss;
import bossmonster.domain.creatures.Player;

import java.util.Map;

import static bossmonster.controller.Parameter.*;

public class CreatureService {

    public Boss createBoss(int bossHp) {
        return new Boss(bossHp, 0);
    }

    public Player createPlayer(Map<String, String> param) {
        String name = param.get(PLAYER_NAME.getName());
        int hp = Integer.parseInt(param.get(PLAYER_HP.getName()));
        int mp = Integer.parseInt(param.get(PLAYER_MP.getName()));

        return new Player(hp, mp, name);
    }
}
