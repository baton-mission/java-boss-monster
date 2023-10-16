package bossmonster.dto;

public class BattleDTO {
    private int damage;
    private String attackName;

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public BattleDTO(int damage, String attackName) {
        this.damage = damage;
        this.attackName = attackName;
    }

    public void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    public int getDamage() {
        return damage;
    }

    public String getAttackName() {
        return attackName;
    }
}
