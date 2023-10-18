package bossmonster.domain.player;

public class PlayerStats {

    public static final int HP_AND_MP_SUM = 200;
    private final PlayerHp playerHp;
    private final PlayerMp playerMp;

    private PlayerStats(PlayerHp playerHp, PlayerMp playerMp) {
        this.playerHp = playerHp;
        this.playerMp = playerMp;
    }

    public static PlayerStats createPlayerStats(int hp, int mp) {
        validateSumOfHpAndMp(hp, mp);
        return new PlayerStats(new PlayerHp(hp), new PlayerMp(mp));
    }

    private static void validateSumOfHpAndMp(int hp, int mp) {
        if (hp + mp != HP_AND_MP_SUM) {
            throw new IllegalArgumentException("[ERROR] hp와 mp 의 합은 200이어야합니다");
        }
    }

    public void affectHp(int damage) {
        playerHp.reduceHp(damage);
    }

    public void affectMp(Skill skill) {
        playerMp.changeMp(skill);
    }

    public PlayerHp getPlayerHp() {
        return playerHp;
    }

    public PlayerMp getPlayerMp() {
        return playerMp;
    }


    public boolean isInsufficientMpForSkill(Skill skill) {
        return playerMp.isInsufficientMp(skill);
    }

    public boolean hasHPGreaterThanZero() {
        return playerHp.hasHPGreaterThanZero();
    }
}
