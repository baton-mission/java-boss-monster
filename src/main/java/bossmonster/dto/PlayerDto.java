package bossmonster.dto;

public class PlayerDto {

    public static class HpMp {
        private final int hp;
        private final int mp;

        public HpMp(int hp, int mp) {
            this.hp = hp;
            this.mp = mp;
        }

        public int getHp() {
            return hp;
        }

        public int getMp() {
            return mp;
        }
    }
}
