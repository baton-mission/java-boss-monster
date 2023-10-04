package bossmonster.domain;

public class BasicRuleChecker implements RuleChecker {
    @Override
    public boolean checkBossInitHp(int hp) {
        return hp >= 100 && hp <= 300;
    }

    @Override
    public boolean checkPlayerName(String name) {
        return name.length() <= 5 && !name.isEmpty() && !name.isBlank();
    }

    @Override
    public boolean checkPlayerHpAndMP(String hpAndMp) {
        try {
            String[] split = hpAndMp.split(",");
            int hp = Integer.parseInt(split[0]);
            int mp = Integer.parseInt(split[1]);
            return hp + mp == 200 && hp > 0 && mp > 0;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean checkPlayerCanMagicAttack(Player player, int requireMp) {
        return player.canUseMp(requireMp);
    }
}
