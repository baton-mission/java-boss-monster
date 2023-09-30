package bossmonster.domain.player;

import bossmonster.domain.character.Character;
import bossmonster.dto.PlayerInfo;

public interface Player
        extends Character {
    PlayerInfo getPlayerInfo();
}
