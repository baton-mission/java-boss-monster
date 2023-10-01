package bossmonster;

public enum AttackType {
    PHYSICAL(1, 10, 0, 10), MAGICAL(2, 20, 30, 0);

    int typeNum;
    int damage;
    int mpNeeded;
    int reGenMp;

    private AttackType(int num, int damage, int mpNeeded, int reGenMp) {
        this.typeNum = num;
        this.damage = damage;
        this.mpNeeded = mpNeeded;
        this.reGenMp = reGenMp;
    }

    public int getTypeNum() {
        return this.typeNum;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getmpNeeded() {
        return this.mpNeeded;
    }

    public int getReGenMp() {
        return this.reGenMp;
    }
}
