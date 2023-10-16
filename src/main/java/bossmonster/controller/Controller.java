package bossmonster.controller;

import bossmonster.domain.battle.GameState;

import java.util.Map;

public interface Controller {
    GameState process(Map<String, String> param, Map<String, Object> model);
}
