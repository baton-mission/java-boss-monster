package bossmonster.domain;

public interface RuleChecker {
    boolean checkBossInitHp(int hp);
    boolean checkPlayerName(String name);
    boolean checkPlayerHpAndMP(String hpAndMp);
    boolean checkPlayerCanMagicAttack(Player player, int requireMp);
}
