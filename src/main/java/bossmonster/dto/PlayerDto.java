package bossmonster.dto;

import bossmonster.domain.Player;

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

    public static class Status {
        private final String name;
        private final int maxHp;
        private final int hp;
        private final int maxMp;
        private final int mp;

        public Status(String name, int maxHp, int hp, int maxMp, int mp) {
            this.name = name;
            this.maxHp = maxHp;
            this.hp = hp;
            this.maxMp = maxMp;
            this.mp = mp;
        }

        public String getName() {
            return name;
        }

        public int getMaxHp() {
            return maxHp;
        }

        public int getHp() {
            return hp;
        }

        public int getMaxMp() {
            return maxMp;
        }

        public int getMp() {
            return mp;
        }

        public static Status from(Player player) {
            return new Status(player.getName(), player.getMaxHp(), player.getCurrentHp(),
                    player.getMaxMp(), player.getCurrentMp());
        }
    }
}
