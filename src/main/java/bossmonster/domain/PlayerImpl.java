package bossmonster.domain;


class PlayerImpl extends Player {
    PlayerImpl(String name, int hp, int mp) {
        super(name, hp, mp);
    }

    @Override
    void attack(Boss boss, int value) {
        recoveryMp(10);
        boss.hit(value);
    }

    @Override
    void magicAttack(Boss boss, int value){
        useMp(30);
        boss.hit(value);
    }
}
