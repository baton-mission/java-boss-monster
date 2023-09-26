package bossmonster.domain;

public class BossGame {

    private final Boss boss;

    private final Player player;

    private TurnCount turnCount;

    private BossGame(Boss boss, Player player, TurnCount turnCount) {
        this.boss = boss;
        this.player = player;
        this.turnCount = turnCount;
    }

    private BossGame(Boss boss, Player player) {
        this(boss, player, TurnCount.init());
    }

    public static BossGame init(Boss boss, Player player) {
        return new BossGame(boss, player);
    }

    // TODO : turnCount를 외부로 return 해서 로직을 제어하진 않는 이상 내부 변수이고 값이 바뀐다면 final을 제거하고 재할당한다.
    public int attack(AttackType attackType) {
        turnCount = turnCount.increase();
        player.effectedMpBy(attackType);
        boss.effectedHpBy(attackType);
        int bossDamage = boss.attackTo(player);
        return bossDamage;
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
