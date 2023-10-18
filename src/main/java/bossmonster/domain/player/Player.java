package bossmonster.domain.player;

import bossmonster.domain.monster.Monster;

public class Player {

    private PlayerName playerName;

    private PlayerStats playerStats;

    public Player(PlayerName playerName, PlayerStats playerStats) {
        this.playerName = playerName;
        this.playerStats = playerStats;
    }

    public void receiveDamage(int damage) {
        playerStats.affectHp(damage);
    }

    public void attack(Monster monster,Skill skill) {
        checkPlayerStats(skill);
        monster.receiveDamage(skill.getDamage());
        playerStats.affectMp(skill); //mp를쓴다는게 확실하니까 꺼내서 보내줘도 괜찮을거같다.
        // 밖에서 알고있는게 찝찝함 근데 이미 알고있으니까 꺼내줘도 좋겠다.
    }
    public void checkPlayerStats(Skill skill) {
        if (playerStats.isInsufficientMpForSkill(skill)) {
            throw new IllegalArgumentException("MP가 없어 스킬을 시전할 수 없습니다. 다른 스킬을 선택해주세요");
        }
    }
    public boolean isAlive() {
        return playerStats.hasHPGreaterThanZero();
    }
    public boolean isDead() {
        return !isAlive();
    }

    public PlayerName getName() {
        return playerName;
    }

    public PlayerStats getPlayerStats() {
        return playerStats;
    }


}
