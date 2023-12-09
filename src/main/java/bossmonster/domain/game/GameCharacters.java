package bossmonster.domain.game;

import bossmonster.domain.Hp;
import bossmonster.domain.PlayerAttack;
import bossmonster.domain.monster.Monster;
import bossmonster.domain.player.Player;

public class GameCharacters {
    private final Monster monster;
    private final Player player;

    private GameCharacters(Monster monster, Player player) {
        this.monster = monster;
        this.player = player;
    }

    public static GameCharacters of(Monster monster, Player player) {
        return new GameCharacters(monster, player);
    }

    public boolean isPlayerOver() {
        return player.isOver();
    }

    public boolean isMonsterOver() {
        return monster.isOver();
    }

    public void applyPlayerAttack(PlayerAttack playerAttack) {
        player.affectMpBy(playerAttack);
        monster.damagedBy(playerAttack);
    }

    public void applyMonsterAttack(Hp monsterAttack) {
        player.damagedBy(monsterAttack);
    }

    public void validateAttackMp(PlayerAttack playerAttack) {
        player.validateAttackMp(playerAttack);
    }

    public Monster getMonster() {
        return monster;
    }

    public Player getPlayer() {
        return player;
    }
}
