package bossmonster.domain.player;

import bossmonster.domain.bossmonster.BossMonster;
import bossmonster.domain.character.Character;
import bossmonster.domain.player.constant.PlayerAttackOption;
import bossmonster.domain.player.dto.PlayerInfo;

public interface Player
        extends Character {
    PlayerInfo getPlayerInfo();

    void attackBossMonster(BossMonster bossMonster, PlayerAttackOption attackOption);
}
