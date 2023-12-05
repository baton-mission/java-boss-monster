package bossmonster.domain;

import bossmonster.exception.ManaShortageException;
import bossmonster.exception.Validator;
import java.util.LinkedHashMap;
import java.util.List;

public class Player {

    private String name;
    private PlayerStatus status;
    private List<AttackType> attackType;

    public Player(String name, int maxHP, int maxMP, List<AttackType> attackType) {
        this.name = Validator.validatePlayerName(name);
        Validator.validatePlayerStatus(maxHP, maxMP);
        this.status = new PlayerStatus(maxHP, maxMP);
        this.attackType = attackType;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return status.isAlive();
    }

    public int getMaxHP() {
        return status.getMaxHP();
    }

    public int getCurrentHP() {
        return status.getCurrentHP();
    }

    public int getMaxMP() {
        return status.getMaxMP();
    }

    public int getCurrentMP() {
        return status.getCurrentMP();
    }

    public int attack(AttackType attackType) {
        if (status.getCurrentMP() < attackType.getMpUsage()) {
            throw new ManaShortageException();
        }
        recoverMP(attackType.getMpRecover());
        return attackType.getDamage();
    }

    public void takeDamage(int damage) {
        status.setCurrentHP(damage);
    }

    private void recoverMP(int mp) {
        status.setCurrentMP(mp);
    }
}
