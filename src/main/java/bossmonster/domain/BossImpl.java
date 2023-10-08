package bossmonster.domain;

class BossImpl extends Boss {

    BossImpl(int hp) {
        super(hp);
    }

    @Override
    void attack(Player player, int damageValue) {
        player.hit(damageValue);
    }
}
