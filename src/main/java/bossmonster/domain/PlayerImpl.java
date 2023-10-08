package bossmonster.domain;


class PlayerImpl extends Player {
    PlayerImpl(String name, int hp, int mp) {
        super(name, hp, mp);
    }

    @Override
    void attack(Boss boss, int damageValue) {
        recoveryMp(10);
        boss.hit(damageValue);
    }

    @Override
    void magicAttack(Boss boss, int damageValue){
        useMp(30);
        boss.hit(damageValue);
    }
}
