package bossmonster.domain;

public class BossGame {

    private final Boss boss;
    private final Player player;
    private TurnCount turnCount;

    private BossGame(Boss boss, Player player) {
        this(boss, player, TurnCount.init());
    }

    private BossGame(Boss boss, Player player, TurnCount turnCount) {
        this.boss = boss;
        this.player = player;
        this.turnCount = turnCount;
    }

    public static BossGame init(Boss boss, Player player) {
        return new BossGame(boss, player);
    }

    public void effectPlayerMpWith(AttackType attackType) {
        player.effectedMpBy(attackType);
    }

    public void attackToBossFromPlayer(AttackType attackType) {
        turnCount = turnCount.increase();
        boss.attackedByPlayer(attackType);
    }

    public int attackPlayerFromBoss() {
        if (isBossDead()) {
            return boss.zeroDamage();
        }
        return boss.attackTo(player);
    }

    public boolean isBossDead() {
        return boss.isDead();
    }

    public String getPlayerName() {
        return player.getPlayerName();
    }

    public int getTurnCount() {
        return turnCount.getTurnCount();
    }

    public boolean isPlayerDead() {
        return player.isDead();
    }

    public int getBossInitialHp() {
        return boss.getInitialBossHp();
    }

    public int getBossCurrentHp() {
        return boss.getBossHp();
    }

    public int getPlayerCurrentHp() {
        return player.getPlayerHp();
    }

    public int getPlayerInitialHp() {
        return player.getInitialPlayerHp();
    }

    public int getPlayerCurrentMp() {
        return player.getPlayerMp();
    }

    public int getPlayerInitialMp() {
        return player.getInitialPlayerMp();
    }
}
