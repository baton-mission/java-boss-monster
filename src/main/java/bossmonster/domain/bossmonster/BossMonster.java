package bossmonster.domain.bossmonster;

import bossmonster.domain.character.Character;
import bossmonster.domain.player.Player;
import bossmonster.domain.bossmonster.dto.BossMonsterInfo;

public interface BossMonster
        extends Character {
    BossMonsterInfo getBossMonsterInfo();

    int attackPlayer(Player player);
}
