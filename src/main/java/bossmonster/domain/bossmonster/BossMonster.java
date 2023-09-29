package bossmonster.domain.bossmonster;

import bossmonster.domain.character.Character;
import bossmonster.dto.BossMonsterInfo;

public interface BossMonster
        extends Character {

    BossMonsterInfo getBossMonsterInfo();
}
