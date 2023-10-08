package bossmonster.domain;

public interface RuleChecker {
    boolean isAllowedBossInitHp(int hp);
    boolean isAllowedPlayerName(String name);
    boolean isAllowedPlayerHpAndMP(String hpAndMp);
    boolean canPlayerMagicAttack(Player player, int requireMp);
}
