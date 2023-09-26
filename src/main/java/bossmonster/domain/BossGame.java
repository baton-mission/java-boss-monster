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
    public void attack(AttackType attackType) {
        turnCount = turnCount.increase();
        player.effectedBy(attackType);
        boss.effectedBy(attackType);
    }
}
