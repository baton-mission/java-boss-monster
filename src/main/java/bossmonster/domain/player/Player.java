package bossmonster.domain.player;

import bossmonster.domain.character.Character;
import bossmonster.domain.player.dto.PlayerInfo;

public interface Player
        extends Character {
    PlayerInfo getPlayerInfo();
}
