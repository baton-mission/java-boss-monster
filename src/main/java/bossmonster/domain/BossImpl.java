package bossmonster.domain;

class BossImpl extends Boss {

    BossImpl(int hp) {
        super(hp);
    }

    @Override
    void attack(Player player, int value) {
        player.hit(value);
    }
}
