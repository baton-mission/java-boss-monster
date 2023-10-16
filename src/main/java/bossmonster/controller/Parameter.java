package bossmonster.controller;

public enum Parameter {
    BOSS("boss"),
    BOSS_HP("bossHp"),
    BOSS_ATTACK("bossAttack"),
    BOSS_SPRITE("bossSprite"),
    PLAYER_ATTACK_SELECT("attackSelect"),
    PLAYER_ATTACK_TYPE("attackType"),
    PLAYER("player"),
    PLAYER_NAME("playerName"),
    PLAYER_HP("playerHp"),
    PLAYER_ATTACK("playerAttack"),
    PLAYER_MP("playerMp"),
    BATTLE("battle"),
    BOSS_WIN("bossWin"),
    PLAYER_WIN("playerWin"),
    BATTLE_COUNT("battleCount"),
    ERROR("error");
    private final String name;

    Parameter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
